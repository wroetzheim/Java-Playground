
package swing_timer_animation;

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 *
 * @author will
 */
public class Swing_timer_animation extends JFrame {

    public Swing_timer_animation() {
        initialize_ui();
    }
    
    private void initialize_ui() {
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Animation");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame animation = new Swing_timer_animation();
                animation.setVisible(true);                
            }
        });
    }
    
}
