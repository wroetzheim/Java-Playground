
package moving_objects;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Spaceship {
    private int direction_x;
    private int direction_y;
    private int position_x;
    private int position_y;
    private Image image;
    
    public Spaceship() {
        initialize_spaceship();
    }
    
    private void initialize_spaceship() {
        ImageIcon ii = new ImageIcon("spaceship.png");
        image = ii.getImage();
        position_x = 40;
        position_y = 60;  
    }
    
    public void move() {
        position_x += direction_x;
        position_y += direction_y;
    }
    
    public int get_position_x() {
        return position_x;
    }
    
    public int get_position_y() {
        return position_y;
    }
    
    public Image get_image() {
        return image;
    }
    
    public void key_pressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            
            case KeyEvent.VK_LEFT:
                direction_x = -1;
                break;
            case KeyEvent.VK_RIGHT:
                direction_x = 1;
                break;
            case KeyEvent.VK_UP:
                direction_y = -1;
                break;
            case KeyEvent.VK_DOWN:
                direction_y = 1;
                break;
        
        } //end switch checking key pressed
    
    } // end key_pressed method
    
    public void key_released(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            
            case KeyEvent.VK_LEFT:
                direction_x = 0;
                break;
            case KeyEvent.VK_RIGHT:
                direction_x = 0;
                break;
            case KeyEvent.VK_UP:
                direction_y = 0;
                break;
            case KeyEvent.VK_DOWN:
                direction_y = 0;
                break;
        
        } //end switch checking key released
    
    } // end key_released method
    

}
