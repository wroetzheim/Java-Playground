/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_image;

import java.awt.EventQueue;
import javax.swing.JFrame;


/**
 *
 * @author will
 */
public class image extends JFrame {
    
    public image() {

        initUI();
    }

    private void initUI() {

        add(new board());

        pack();

        setTitle("Pensive Square");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                image an_image = new image();
                an_image.setVisible(true);
            }
        });
    }
    
}
