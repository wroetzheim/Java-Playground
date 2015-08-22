
package moving_objects;


public class Alien extends Sprite {
    
    private final int INITIAL_POSITION_X = 600;
    
    public Alien(int position_x, int position_y) {
        super(position_x, position_y);
        
        initialize_alien();
    
    } // end Alien constructor
    
    private void initialize_alien() {
        
        load_image("alien.png");
        get_image_dimensions();
    
    } // end initialize_alien method
    
    public void move() {
        
        if (position_x < 0) {
            position_x = INITIAL_POSITION_X;
        }
        
        position_x = position_x - 1;
        
    } // end move method
    
} // end Alien class
