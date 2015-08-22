
package moving_objects;


public class Missile extends Sprite {
    
    private final int BOARD_WIDTH = 600;
    private final int MISSILE_SPEED = 2;
    
    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        load_image("missile.png");  
        get_image_dimensions();
    }
    
    public void move() {
        
        position_x += MISSILE_SPEED;
        
        if (position_x > BOARD_WIDTH) {
            visible = false;
            //this.setVisible(false);
        }
    }
    
}
