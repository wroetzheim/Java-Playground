
package moving_objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{
    
    private Timer timer;
    private Spaceship spaceship;
    private final int DELAY = 3;

    public Board() {

        initialize_board();
    }
    
    private void initialize_board() {
        
        addKeyListener(new key_adapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        spaceship = new Spaceship();

        timer = new Timer(DELAY, this);
        timer.start();        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw_on_screen(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void draw_on_screen(Graphics g) {
        
        Graphics2D graphics = (Graphics2D) g;
        graphics.drawImage(spaceship.get_image(), spaceship.get_position_x(), spaceship.get_position_y(), this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        spaceship.move();
        repaint();  
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
