
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
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    
    private final int INITIAL_POSITION_X = 30;
    private final int INITIAL_POSITION_Y = 40;
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private Timer timer;
    private Spaceship spaceship;
    private final int DELAY = 5;
    private ArrayList<Alien> aliens;
    private boolean in_game;
    
    private final int[][] position_grid = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 539},
        {790, 259}, {760, 320}, {790, 450},
        {980, 209}, {560, 45}, {510, 430},
        {930, 459}, {590, 80}, {530, 60},
        {940, 59}, {990, 330}, {920, 200},
        {900, 259}, {660, 550}, {540, 190},
        {810, 320}, {860, 20}, {740, 180},
        {820, 128}, {490, 470}, {700, 30}
    };
    
    public Board() {

        initialize_board();
    }
    
    private void initialize_board() {
        
        addKeyListener(new key_adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        in_game = true;
        
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        
        spaceship = new Spaceship(INITIAL_POSITION_X, INITIAL_POSITION_Y);
        
        initialize_aliens();
        
        timer = new Timer(DELAY, this);
        timer.start();        
    
    } // end initialize_board method
    
    public void initialize_aliens() {
        
        aliens = new ArrayList<>();
        
        for (int[] coordinate : position_grid ) {
            
            aliens.add(new Alien(coordinate[0], coordinate[1]));
        
        } // end loop through position_grid array list
    
    } // end initialize_aliens method
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (in_game == true) {
            
            draw_on_screen(g);
        }
        
        else {
            
            draw_game_over(g);
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
    
    }
    
    private void draw_game_over(Graphics g) {
        String message = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics fm = getFontMetrics(small);
        
        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(message, (WINDOW_HEIGHT - fm.stringWidth(message)) / 2, WINDOW_HEIGHT / 2);
    
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
        
        for (int i = 0; i < aliens.size(); i++) {
            
            Alien an_alien = aliens.get(i);
            
            if (an_alien.is_visible()) {
                an_alien.move();         
            }
            else {            
                aliens.remove(i);
            }
        }
    } // end update_aliens method
    
    public void check_hitboxes() {
        
        Rectangle ship_hitbox = spaceship.getBounds();
        
        for (Alien an_alien : aliens) {
            Rectangle alien_hitbox = an_alien.getBounds();
            
            if(ship_hitbox.intersects(alien_hitbox)) {
                spaceship.set_visible(false);
                an_alien.set_visible(false);
                in_game = false;
            }
        }
        
        ArrayList<Missile> missile_array_list = spaceship.get_missiles();
        
        for (Missile missile : missile_array_list) {
            
            Rectangle missile_hitbox = missile.getBounds();
            
            for (Alien an_alien : aliens) {
                
                Rectangle alien_hitbox = an_alien.getBounds();
                
                if (missile_hitbox.intersects(alien_hitbox)) {
                    missile.set_visible(false);
                    an_alien.set_visible(false);
                }
                  
            }
        }
    }
    
    private class key_adapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.key_released(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.key_pressed(e);
        }
    }
}
