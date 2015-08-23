
package moving_objects;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Moving_objects extends JFrame{
    
    public Moving_objects() {
        initialize_ui();
    }
    
    public void initialize_ui() {
        
        add(new Board());
        
        setSize(1000, 700);
        setResizable(false);
        
        setTitle("Moving Object Example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Moving_objects animation = new Moving_objects();
                animation.setVisible(true);
            }
        });
    }
    
}
