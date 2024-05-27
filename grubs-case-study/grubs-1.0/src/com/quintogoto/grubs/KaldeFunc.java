package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class KaldeFunc {
    public void kaldeFunc(JLayeredPane layeredPane, JButton kaldeButton){
        kaldeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Clicked Kaldereta");

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        kaldeButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                kaldeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                kaldeButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
