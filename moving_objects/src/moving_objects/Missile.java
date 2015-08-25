
package moving_objects;


public class Missile extends Sprite {
    
    private final int BOARD_WIDTH = 1000;
    private final int MISSILE_SPEED = 5;
    
    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        load_image("bullet.png");  
        get_image_dimensions();
    }
    
    public void move() {
        
        position_x += MISSILE_SPEED;
        
        if (position_x > BOARD_WIDTH+10) {
            visible = false;
            //this.setVisible(false);
        }
    }
    
}
