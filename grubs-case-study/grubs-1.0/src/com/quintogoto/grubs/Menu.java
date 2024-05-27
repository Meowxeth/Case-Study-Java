package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.*;

public class Menu {
    //Variables

    private JButton adoboButton;
    private JButton siniButton;
    private JButton bicolButton;
    private JButton kaldeButton;

    private ImageIcon adoboIcon;
    private ImageIcon siniIcon;
    private ImageIcon bicolIcon;
    private ImageIcon kaldeIcon;

    public void setUpUI(JLayeredPane layeredPane){
        ImageIcon backgroundImage = new ImageIcon("resources/assets/bg-placeholder.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

        layeredPane.add(backgroundLabel, Integer.valueOf(1));

        adoboIcon = new ImageIcon("resources/assets/adobo.png");
        siniIcon = new ImageIcon("resources/assets/sinigang.png");
        bicolIcon = new ImageIcon("resources/assets/bicolex.png");
        kaldeIcon = new ImageIcon("resources/assets/kalder.png");

        //Adobo Button
        Image image = adoboIcon.getImage();
        Image scaledImage = image.getScaledInstance(250, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        adoboButton = new JButton(scaledIcon);
        adoboButton.setBorder(BorderFactory.createEmptyBorder());
        adoboButton.setContentAreaFilled(false);
        adoboButton.setBorderPainted(false);
        adoboButton.setBounds(25, 70, 250, 225);

        AdoboFunc adoboFunc = new AdoboFunc();
        adoboFunc.adoboFunc(layeredPane, adoboButton);

        //Sinigang Button
        Image imageSini = siniIcon.getImage();
        Image scaledImageSini = imageSini.getScaledInstance(250, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSini = new ImageIcon(scaledImageSini);

        siniButton = new JButton(scaledIconSini);
        siniButton.setBorder(BorderFactory.createEmptyBorder());
        siniButton.setContentAreaFilled(false);
        siniButton.setBorderPainted(false);
        siniButton.setBounds(310, 70, 250, 225);

        SiniFunc siniFunc = new SiniFunc();
        siniFunc.siniFunc(layeredPane, siniButton);

        //Bicol Express Button
        Image imageBicol = bicolIcon.getImage();
        Image scaledImageBicol = imageBicol.getScaledInstance(250, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledIconBicol = new ImageIcon(scaledImageBicol);

        bicolButton = new JButton(scaledIconBicol);
        bicolButton.setBorder(BorderFactory.createEmptyBorder());
        bicolButton.setContentAreaFilled(false);
        bicolButton.setBorderPainted(false);
        bicolButton.setBounds(25, 315, 250, 225);

        BicolFunc bicolFunc = new BicolFunc();
        bicolFunc.bicolFunc(layeredPane, bicolButton);

        //Kaldereta Button
        Image imageKalde = kaldeIcon.getImage();
        Image scaledImageKalde = imageKalde.getScaledInstance(250, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledIconKalde = new ImageIcon(scaledImageKalde);

        kaldeButton = new JButton(scaledIconKalde);
        kaldeButton.setBorder(BorderFactory.createEmptyBorder());
        kaldeButton.setContentAreaFilled(false);
        kaldeButton.setBorderPainted(false);
        kaldeButton.setBounds(310, 315, 250, 225);

        KaldeFunc kaldeFunc = new KaldeFunc();
        kaldeFunc.kaldeFunc(layeredPane, kaldeButton);

        layeredPane.add(adoboButton, Integer.valueOf(   2));
        layeredPane.add(siniButton, Integer.valueOf(   2));
        layeredPane.add(bicolButton, Integer.valueOf(   2));
        layeredPane.add(kaldeButton, Integer.valueOf(   2));
    }
}
