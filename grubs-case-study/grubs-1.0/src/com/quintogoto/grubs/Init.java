package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Init {
    public void fontSetterMont(int size, JLabel textLabel){
        //Sets the font
        try{
            Font fontType = Font.createFont(Font.TRUETYPE_FONT, new File("resources/assets/fonts/Montserrat-Bold.ttf"));
            fontType = fontType.deriveFont(Font.BOLD, size);
            textLabel.setFont(fontType);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public ImageIcon imageIconSetup(ImageIcon icon, int width, int height){

        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return scaledIcon;
    }

    public void buttonSetup(JButton button, int x, int y, int width, int height){


        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(x, y, width, height);
    }

    public void mouseListener(JButton button){
        button.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}