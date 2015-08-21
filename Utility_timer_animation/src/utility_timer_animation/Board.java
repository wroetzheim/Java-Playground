
package utility_timer_animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel {
    
    private final int WINDOW_WIDTH = 650;
    private final int WINDOW_HEIGHT = 650;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;    
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 5;
    
    private Image star;
    private Timer timer;
    private int x_position, y_position;
    
    public Board() {
 
        initialize_board();        
    
    } // end Board method
    
    private void load_image() {
        
        ImageIcon ii = new ImageIcon("star.png");
        star = ii.getImage();        
    
    } // end load_image method
    
    private void initialize_board() {
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDoubleBuffered(true);
        
        load_image();

        x_position = INITIAL_X;
        y_position = INITIAL_Y;
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new schedule_task(), INITIAL_DELAY, PERIOD_INTERVAL);        
    
    }  // end initialize_board method
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw_star(g);
    
    } // end paintComponent Override method
    
    private void draw_star(Graphics g) {
        
        g.drawImage(star, x_position, y_position, this);
        Toolkit.getDefaultToolkit().sync();
    
    } // end draw_star method

    private class schedule_task extends TimerTask {

        @Override
        public void run() {
            x_position += 1;
            y_position += 1;

            if (y_position > WINDOW_HEIGHT) {
                y_position = INITIAL_Y;
                x_position = INITIAL_X;
            }
            
            repaint();
        }
    } // end schedule_task method
    
} // end Board class


