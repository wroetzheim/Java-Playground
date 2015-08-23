
package moving_objects;

import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Sprite {
    
    protected int position_x;
    protected int position_y;
    protected int image_width;
    protected int image_height;
    protected boolean visible;
    protected Image image;
    protected static Image background;
    
    public Sprite(int x, int y) {

        this.position_x = x;
        this.position_y = y;
        visible = true;
    }
    
    protected void load_image(String file_name) {

        ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource("images/"+file_name));
        image = ii.getImage();
    }
    
    protected static Image load_background(String file_name) {
        
        ImageIcon bi = new ImageIcon(Sprite.class.getClassLoader().getResource("images/"+file_name));
        background = bi.getImage();
        return background;
    }
    
    protected void get_image_dimensions() {

        image_width = image.getWidth(null);
        image_height = image.getHeight(null);
    } 
    
    public Image get_image() {
        return image;
    }

    public int get_position_x() {
        return position_x;
    }

    public int get_position_y() {
        return position_y;
    }

    public boolean is_visible() {
        return visible;
    }

    public void set_visible(Boolean visible_value) {
        visible = visible_value;
    }
    
    public Rectangle getBounds(String sprite_type) {
        if (sprite_type == "player") {
            return new Rectangle(position_x, position_y, image_width, image_height);
        }
        else {
            return new Rectangle(position_x, position_y, image_width, image_height);
        }
        
    }
    
} // end Sprite class
