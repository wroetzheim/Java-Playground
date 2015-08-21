
package thread_animation;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Thread_animation extends JFrame {

    
    public Thread_animation() {
        initialize_ui();
    
    } // end Thread_animation method
    
    private void initialize_ui() {
        
        add(new Board());

        setResizable(false);
        pack();
        
        setTitle("Star");    
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } // end initialize_ui method
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {                
                JFrame animation = new Thread_animation();
                animation.setVisible(true);                
            
            } // end run Override method
        });
    
    } // end main method
    
}
