/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic_image;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author will
 */
public class board extends JPanel {
    
    private Image pensive_square;

    public board() {

        initBoard();
    }
    
    private void initBoard() {
        
        loadImage();
        
        int w = pensive_square.getWidth(this);
        int h =  pensive_square.getHeight(this);
        setPreferredSize(new Dimension(w, h));        
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("pensive_square.jpg");
        pensive_square = ii.getImage();        
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawString("This is my cat, Penelope", 10, 15);
        g.drawImage(pensive_square, 0, 20, null);
    }
}

