/*
 * Copyright (C) 2015 will
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.will.basic_drawing;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Will Roetzheim
 */
public class board extends JPanel {
    
   @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawCircle(g);
    
    } // end paintComponent override method
    
    
    private void drawCircle(Graphics g) {
        
        Graphics2D graphic = (Graphics2D) g;
        
        RenderingHints rh = new RenderingHints(
                                    RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON
                                );
        
        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);
        
        graphic.setRenderingHints(rh);
        
        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();
        
        Ellipse2D circle = new Ellipse2D.Double(10, 10, w-20, h-20);
        
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            graphic.draw(at.createTransformedShape(circle));
        }
        
        
        
        //graphic.draw(circle);
        
    } //end drawCircle method
   
} // end board class
