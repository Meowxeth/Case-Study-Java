package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdoboFunc {
    public void adoboFunc(JLayeredPane layeredPane, JButton adoboButton){
        adoboButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Clicked Adobo");

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        adoboButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                adoboButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                adoboButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
