
package moving_objects;

import java.util.Random;


public class Alien extends Sprite {
    
    private final int INITIAL_POSITION_X = 1200;
    
    public Alien(int position_x, int position_y) {
        super(position_x, position_y);
        
        initialize_alien();
    
    } // end Alien constructor
    
    private void initialize_alien() {
        
        load_image("spaceship_enemy.png");
        get_image_dimensions();
    
    } // end initialize_alien method
    
    
    
     
    public void move() {
        
        if (position_x < -20) {
            position_x = INITIAL_POSITION_X;
        }
        
        position_x = position_x - 1;
        
    } // end move method
    
} // end Alien class
