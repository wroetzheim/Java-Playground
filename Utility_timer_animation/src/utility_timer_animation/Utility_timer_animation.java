
package utility_timer_animation;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Utility_timer_animation extends JFrame {

    public Utility_timer_animation() {
    
        initialize_ui();
    
    } // end Utility_timer_animation method
    
    private void initialize_ui() {
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    } //end initialize_ui method

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {                
                
                JFrame animation = new Utility_timer_animation();
                animation.setVisible(true);                
            
            } // end run Override method
        
        });
    
    } // end main method
    
    
} // end Utility_timer_animation class
