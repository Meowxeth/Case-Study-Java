package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Menu {
    // Variables

    private JButton adoboButton;
    private JButton siniButton;
    private JButton bicolButton;
    private JButton kaldeButton;
    private JButton gulamButton;
    private JButton cokeButton;

    private ImageIcon adoboIcon;
    private ImageIcon siniIcon;
    private ImageIcon bicolIcon;
    private ImageIcon kaldeIcon;

    private ImageIcon gulamIcon;
    private ImageIcon cokeIcon;

    public void setUpUI(JLayeredPane layeredPane) {
        ImageIcon backgroundImage = new ImageIcon("resources/assets/bg.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

        layeredPane.add(backgroundLabel, Integer.valueOf(1));

        adoboIcon = new ImageIcon("resources/assets/cards/adobo.png");
        siniIcon = new ImageIcon("resources/assets/cards/sini.png");
        bicolIcon = new ImageIcon("resources/assets/cards/bicolex.png");
        kaldeIcon = new ImageIcon("resources/assets/cards/kalde.png");
        gulamIcon = new ImageIcon("resources/assets/cards/gulam.png");
        cokeIcon = new ImageIcon("resources/assets/cards/coke.png");

        // Adobo Button
        Image image = adoboIcon.getImage();
        Image scaledImage = image.getScaledInstance(217, 305, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        adoboButton = new JButton(scaledIcon);
        adoboButton.setBorder(BorderFactory.createEmptyBorder());
        adoboButton.setContentAreaFilled(false);
        adoboButton.setBorderPainted(false);
        adoboButton.setBounds(60, 130, 217, 305);

        AdoboFunc adoboFunc = new AdoboFunc();
        adoboFunc.adoboFunc(layeredPane, adoboButton);

        // Sinigang Button
        Image imageSini = siniIcon.getImage();
        Image scaledImageSini = imageSini.getScaledInstance(217, 305, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSini = new ImageIcon(scaledImageSini);

        siniButton = new JButton(scaledIconSini);
        siniButton.setBorder(BorderFactory.createEmptyBorder());
        siniButton.setContentAreaFilled(false);
        siniButton.setBorderPainted(false);
        siniButton.setBounds(318, 130, 217, 305);

        SiniFunc siniFunc = new SiniFunc();
        siniFunc.siniFunc(layeredPane, siniButton);

        // Bicol Express Button
        Image imageBicol = bicolIcon.getImage();
        Image scaledImageBicol = imageBicol.getScaledInstance(217, 305, Image.SCALE_SMOOTH);
        ImageIcon scaledIconBicol = new ImageIcon(scaledImageBicol);

        bicolButton = new JButton(scaledIconBicol);
        bicolButton.setBorder(BorderFactory.createEmptyBorder());
        bicolButton.setContentAreaFilled(false);
        bicolButton.setBorderPainted(false);
        bicolButton.setBounds(62, 469, 217, 305);

        BicolFunc bicolFunc = new BicolFunc();
        bicolFunc.bicolFunc(layeredPane, bicolButton);

        // Kaldereta Button
        Image imageKalde = kaldeIcon.getImage();
        Image scaledImageKalde = imageKalde.getScaledInstance(217, 305, Image.SCALE_SMOOTH);
        ImageIcon scaledIconKalde = new ImageIcon(scaledImageKalde);

        kaldeButton = new JButton(scaledIconKalde);
        kaldeButton.setBorder(BorderFactory.createEmptyBorder());
        kaldeButton.setContentAreaFilled(false);
        kaldeButton.setBorderPainted(false);
        kaldeButton.setBounds(320, 469, 217, 305);

        KaldeFunc kaldeFunc = new KaldeFunc();
        kaldeFunc.kaldeFunc(layeredPane, kaldeButton);

        //Gulaman Button
        Image imageGulam = gulamIcon.getImage();
        Image scaledImageGulam = imageGulam.getScaledInstance(217, 216, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGulam = new ImageIcon(scaledImageGulam);

        gulamButton = new JButton(scaledIconGulam);
        gulamButton.setBorder(BorderFactory.createEmptyBorder());
        gulamButton.setContentAreaFilled(false);
        gulamButton.setBorderPainted(false);
        gulamButton.setBounds(62, 861, 217, 216);

        //Coke Button
        Image imageCoke = cokeIcon.getImage();
        Image scaledImageCoke = imageCoke.getScaledInstance(217, 216, Image.SCALE_SMOOTH);
        ImageIcon scaledIconCoke = new ImageIcon(scaledImageCoke);

        cokeButton = new JButton(scaledIconCoke);
        cokeButton.setBorder(BorderFactory.createEmptyBorder());
        cokeButton.setContentAreaFilled(false);
        cokeButton.setBorderPainted(false);
        cokeButton.setBounds(320, 861, 217, 216);


        //Text on the menu
        JLabel grubsLabel = new JLabel("Grubs Menu"); //Timer Display set to 25:00 initially
        grubsLabel.setBounds(27, 44, 500, 66); //Timer Display Positioning

        //Sets the font of the grubs menu (Font type, font size)
        try{
            Font menuFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/assets/fonts/Montserrat-Bold.ttf"));
            menuFont = menuFont.deriveFont(Font.PLAIN, 54);
            grubsLabel.setFont(menuFont);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }

        //Drinks Label

        JLabel drinksLabel = new JLabel("Drinks");
        drinksLabel.setBounds(32, 803, 500, 47);

        //Sets the font of the grubs menu (Font type, font size)
        try{
            Font drinksFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/assets/fonts/Montserrat-Bold.ttf"));
            drinksFont = drinksFont.deriveFont(Font.BOLD, 40);
            drinksLabel.setFont(drinksFont);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }

        layeredPane.add(adoboButton, Integer.valueOf(2));
        layeredPane.add(siniButton, Integer.valueOf(2));
        layeredPane.add(bicolButton, Integer.valueOf(2));
        layeredPane.add(kaldeButton, Integer.valueOf(2));
        layeredPane.add(gulamButton, Integer.valueOf(2));
        layeredPane.add(cokeButton, Integer.valueOf(2));
        layeredPane.add(grubsLabel, Integer.valueOf(2));
        layeredPane.add(drinksLabel, Integer.valueOf(2));

    }
}
