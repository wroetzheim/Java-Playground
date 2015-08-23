
package moving_objects;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Spaceship extends Sprite {
    
    private int direction_x;
    private int direction_y;
    private ArrayList<Missile> missiles;

    public Spaceship(int position_x, int position_y) {
        super(position_x, position_y);
        
        initialize_spaceship();
    }
    
    private void initialize_spaceship() {
        
        missiles = new ArrayList();
        load_image("starship.png"); 
        get_image_dimensions(); 
    }
    
    public void move() {
        
        if (position_x +  direction_x <= -1 || position_x + direction_x >= Board.WINDOW_WIDTH - image_width) {
            position_x += 0;
        }
        else {
            position_x += direction_x; 
        }
        
        if (position_y + direction_y <= -1 || position_y + direction_y >= Board.WINDOW_HEIGHT - image_height +5) {
           position_y += 0; 
        }
        else {
           position_y += direction_y; 
        }
        
    }
    
    public ArrayList get_missiles() {
        return missiles;
    }
    
    public void key_pressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            
            case KeyEvent.VK_LEFT:
                direction_x = -2; 
                break;
            case KeyEvent.VK_RIGHT:
                direction_x = 2;
                break;
            case KeyEvent.VK_UP:
                direction_y = -2;
                break;
            case KeyEvent.VK_DOWN:
                direction_y = 2;
                break;
            case KeyEvent.VK_SPACE:
                shoot_missile();
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
    
    public void shoot_missile() {
        missiles.add(new Missile(position_x + image_width, position_y + image_height / 2));
    }

    
}
