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

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Will Roetzheim
 */
public class application extends JFrame {
    
    public application() {
        initalizeUI();
    }
    
    private void initalizeUI() {
        
        add(new board());
        
        setTitle("Basic Drawing");
        setSize(400,400);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    } // end initializeUI method
    
    public static void main (String [] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                application app = new application();
                app.setVisible(true);
            }
        });
                
    } // end main method
    
}
