
package moving_objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Board extends JPanel implements ActionListener{
    
    private final int INITIAL_POSITION_X = 30;
    private final int INITIAL_POSITION_Y = 40;
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 700;
    private Timer timer;
    private Spaceship spaceship;
    private final int DELAY = 15;
    private ArrayList<Alien> aliens;
    private boolean in_game;
    private int number_of_aliens = 20;
    
    int background_x = 0;
    int background_y = -1200;
    
    String y_direction = "up";
    String x_direction = "left";
    
    int[][] position_grid = new int[number_of_aliens][2]; 

    public Board() {
      
        initialize_board();
    }
    private void number_of_enemies(int enemies) {
        position_grid = new int[enemies][2];
    }
    private void initialize_board() {
        
        number_of_enemies(number_of_aliens);

        for (int i=0; i< position_grid.length; i++) {
           position_grid[i][0] = random_integer_x();
           position_grid[i][1] = random_integer_y();
        }

        addKeyListener(new key_adapter());
        setFocusable(true);
        
        in_game = true;
        
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        spaceship = new Spaceship(INITIAL_POSITION_X, INITIAL_POSITION_Y);
        
        initialize_aliens();

        timer = new Timer(DELAY, this);
        timer.start();        
    
    } // end initialize_board method
    
    public void press_start(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            initialize_board();
            background_x = 0;
            background_y = -1200;
            y_direction = "up";
            x_direction = "left";
        }
    }
    
    public void initialize_aliens() {
        
        aliens = new ArrayList<>();
        
        for (int[] coordinate : position_grid ) {
            
            aliens.add(new Alien(coordinate[0], coordinate[1]));
        
        } // end loop through position_grid array list
    
    } // end initialize_aliens method
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        move_background(g);
        
        if (in_game == true) {
            
            draw_on_screen(g);
        }
        
        else {
            
            draw_game_over(g);
            in_game = false;
        }
        
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw_on_screen(Graphics g) {
        
        if (spaceship.is_visible()) {
           
            g.drawImage(spaceship.get_image(), spaceship.get_position_x(), spaceship.get_position_y(), this);
         
        }
        
        ArrayList<Missile> missle_array_list = spaceship.get_missiles();

        for (Missile a_missile : missle_array_list) {
            
            if (a_missile.is_visible()) {
                g.drawImage(a_missile.get_image(), a_missile.get_position_x(), a_missile.get_position_y(), this);
            }
        }
        
        for (Alien an_alien : aliens) {
            
            if (an_alien.is_visible()) {
                g.drawImage(an_alien.get_image(), an_alien.get_position_x(), an_alien.get_position_y(), this);
            }
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Aliens left: " + aliens.size(), 5, 15);
       // g.drawString("background: " + background_x + ", " + background_y, 50, 70);
    
    }
    
    private void draw_game_over(Graphics g) {
        int aliens_left = aliens.size();
        String message;
        String message2;
        String message3 = null;
        
        if (aliens_left == 0) {
            message = "You WON!";
            message2 = "Congratulations!"; 
            
        }
        
        else {
            message = "Game Over";
            message2 = aliens.size() + " aliens left.";
            message3 = "Press Space to Continue...";
            
        }
        Font small = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(message, (WINDOW_WIDTH - fm.stringWidth(message)) / 2, WINDOW_HEIGHT / 2 - 30);
        g.drawString(message2, (WINDOW_WIDTH - fm.stringWidth(message2)) / 2, WINDOW_HEIGHT / 2 + 0);
        g.setColor(Color.YELLOW);
        if (message3 != null && !message3.isEmpty()) {
            g.drawString(message3, (WINDOW_WIDTH - fm.stringWidth(message3)) / 2, WINDOW_HEIGHT / 2 + 30);
        }
    
    }
       
    @Override
    public void actionPerformed(ActionEvent e) {
        
        in_game();
        
        update_spaceship();
        update_missles();
        update_aliens();
        
        check_hitboxes();
        
        repaint();  
    }
    
    public void in_game() {
        
        if(!in_game) {
            
            timer.stop();
        }
    }
    
    public void update_spaceship() {
        
        if (spaceship.is_visible()) {
            
            spaceship.move();
        }
        
    }
    
    public void update_missles() {
        ArrayList<Missile> missile_array_list = spaceship.get_missiles();

        for (int i = 0; i < missile_array_list.size(); i++) {

            Missile m = missile_array_list.get(i);

            if (m.is_visible() == true) {

                m.move();
                
            } else {

                missile_array_list.remove(i);
            }
        }
        
    }
    
    private void update_aliens() {
        
        if (aliens.isEmpty()) {
            
            in_game = false;
            return;
        }
        
        int k = 0;
        for (int i = 0; i < aliens.size(); i++) {
            
            Alien an_alien = aliens.get(i);
            
            if (an_alien.is_visible()) {
                
                if (k == 0) {    
                    an_alien.move();
                    k = 1;
                }                
                else {
                    an_alien.move();
                    an_alien.move();
                    k = 0;
                } // end if k condition  
            }         
            else {            
                aliens.remove(i);
            } // end if visible condition
        }
    } // end update_aliens method
    
    private void move_background(Graphics g) {
        
        if (y_direction.equals("up")) {
            
            background_y -= 2;
            if (background_y <= -3700) {
                y_direction = "down";
            }
        }
        
        if (y_direction.equals("down")) {
           
            background_y += 1;
            if (background_y >= -10) {
                y_direction = "up";
            }
        }
        
        if (x_direction.equals("left")) {
            background_x += 1;
            if (background_x >= -10) {
                x_direction = "right";
            }
        }
        
        if (x_direction.equals("right")) {
            background_x -= 2;
            if (background_x <= -2300) {
                x_direction = "left";
            }
        }
        
        g.drawImage(Sprite.load_background("HiRes.jpg"), background_x, background_y, null);
        
    }
    
    public void check_hitboxes() {
        
        Rectangle ship_hitbox = spaceship.getBounds("player");
        
        for (Alien an_alien : aliens) {
            Rectangle alien_hitbox = an_alien.getBounds("not player");
            
            if(ship_hitbox.intersects(alien_hitbox)) {
                spaceship.set_visible(false);
                an_alien.set_visible(false);
                in_game = false;
            }
        }
        
        ArrayList<Missile> missile_array_list = spaceship.get_missiles();
        
        for (Missile missile : missile_array_list) {
            
            Rectangle missile_hitbox = missile.getBounds("not player");
            
            for (Alien an_alien : aliens) {
                
                Rectangle alien_hitbox = an_alien.getBounds("not player");
                
                if (missile_hitbox.intersects(alien_hitbox)) {
                    missile.set_visible(false);
                    an_alien.set_visible(false);
                }
                  
            }
        }
    }
    
    public static int random_integer_x() {
        Random rand = new Random();
        int random_number = rand.nextInt((2000 - 600) + 1) + 600;
        return random_number;
    }
    
    public int random_integer_y() {
        Random rand = new Random();
        int random_number = rand.nextInt(((WINDOW_HEIGHT - 60) - 30) + 1) + 30;
        return random_number;
    }
    
    private class key_adapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            
            spaceship.key_released(e);
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (!in_game) {
                try {
                    Thread.sleep(1000);
                    press_start(e);
                    
                                     
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                
            }
            else {
                spaceship.key_pressed(e);
            }
            
        }
    }
}
