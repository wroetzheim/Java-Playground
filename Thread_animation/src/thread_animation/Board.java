
package thread_animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Board extends JPanel implements Runnable {
    
    private final int WINDOW_WIDTH = 650;
    private final int WINDOW_HEIGHT = 650;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 5;

    private Image star;
    private Thread animator;
    private int x_position, y_position;

    public Board() {

        initialize_board();
    }
    
    private void loadImage() {

        ImageIcon ii = new ImageIcon("star.png");
        star = ii.getImage();
    }
    
    private void initialize_board() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x_position = INITIAL_X;
        y_position = INITIAL_Y;
    }
    
    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
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

    private void animation_cylce() {

        x_position += 1;
        y_position += 1;

        if (y_position > WINDOW_HEIGHT) {

            y_position = INITIAL_Y;
            x_position = INITIAL_X;
        }
    }
    
    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            animation_cylce();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
}
