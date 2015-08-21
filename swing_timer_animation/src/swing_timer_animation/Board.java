/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_timer_animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    
    private final int WINDOW_WIDTH = 850;
    private final int WINDOW_HEIGHT = 650;
    private int initial_x = -40;
    private int initial_y = -40;
    private int ms_increment = 3;

    private Image star;
    private Timer animation_timer;
    private int x_position, y_position;

    public Board() {

        initBoard();
    
    }
    
    private void loadImage() {

        ImageIcon ii = new ImageIcon("star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.black);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDoubleBuffered(true);

        loadImage();
        
        x_position = initial_x;
        y_position = initial_y;
        
        animation_timer = new Timer(ms_increment, this);
        animation_timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x_position, y_position, this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x_position += 4;
        y_position += 4;
            
        if (y_position > WINDOW_HEIGHT) {
            
            y_position = initial_y + 50;
            x_position = initial_x ;
            initial_y = y_position;

            
            
        }

        if (initial_y > WINDOW_HEIGHT) {

            initial_y = -40;
            
        }
        
        repaint();
    }
}
