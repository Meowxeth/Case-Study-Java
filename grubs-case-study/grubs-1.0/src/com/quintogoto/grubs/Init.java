package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Init {
    public void createBackgroundImage(JLayeredPane layeredPane, String path, int layer){
        ImageIcon backgroundImage = new ImageIcon(path);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

        layeredPane.add(backgroundLabel, Integer.valueOf(layer));
    }
    public void fontSetterMont(int size, JLabel textLabel){
        //Sets the font
        try{
            Font fontType = Font.createFont(Font.TRUETYPE_FONT, new File("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/fonts/Montserrat-Bold.ttf"));
            fontType = fontType.deriveFont(Font.BOLD, size);
            textLabel.setFont(fontType);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }
    }

    public void fontSetterPublicSans(int size, JLabel textLabel){
        //Sets the font
        try{
            Font fontType = Font.createFont(Font.TRUETYPE_FONT, new File("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/fonts/Roboto-Regular.ttf"));
            fontType = fontType.deriveFont(Font.PLAIN, size);
            textLabel.setFont(fontType);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }
    }


    public void buttonSetup(JButton button, int x, int y, int width, int height){
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBounds(x, y, width, height);
    }

    public ImageIcon imageScaler(String path, int width, int height){
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        return scaledImageIcon;
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

    public void removeMenu(JLayeredPane layeredPane, JButton adoboButton, JButton siniButton, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JLabel drinksLabel){
        layeredPane.remove(adoboButton);
        layeredPane.remove(siniButton);
        layeredPane.remove(bicolexButton);
        layeredPane.remove(kalderButton);
        layeredPane.remove(gulamButton);
        layeredPane.remove(cokeButton);
        layeredPane.remove(drinksLabel);
    }
    public void displayMenu(JLayeredPane layeredPane, JButton adoboButton, JButton siniButton, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JLabel drinksLabel){
        layeredPane.add(adoboButton, Integer.valueOf(2));
        layeredPane.add(siniButton, Integer.valueOf(2));
        layeredPane.add(bicolexButton, Integer.valueOf(2));
        layeredPane.add(kalderButton, Integer.valueOf(2));
        layeredPane.add(gulamButton, Integer.valueOf(2));
        layeredPane.add(cokeButton, Integer.valueOf(2));
        layeredPane.add(drinksLabel, Integer.valueOf(2));
    }

    public void removeCheckout(JLayeredPane layeredPane, JLabel backgroundLabel, JButton returnButton, JLabel totalLabel, JLabel numTotalLabel, JButton confirmButton, JLabel checkoutLabel){
        layeredPane.remove(backgroundLabel);
        layeredPane.remove(returnButton);
        layeredPane.remove(totalLabel);
        layeredPane.remove(numTotalLabel);
        layeredPane.remove(confirmButton);
        layeredPane.remove(checkoutLabel);
    }
}