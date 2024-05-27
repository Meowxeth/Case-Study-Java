package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class BicolFunc {
    public void bicolFunc(JLayeredPane layeredPane, JButton bicolButton){
        bicolButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Clicked Bicol Express");

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        bicolButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                bicolButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                bicolButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
