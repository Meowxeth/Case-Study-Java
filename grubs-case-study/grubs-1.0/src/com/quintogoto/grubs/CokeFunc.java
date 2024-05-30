package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CokeFunc {
    JLabel quantLabel;
    int counter = 1;
    int orderId = 6;

    Init init = new Init();
    private OrderRecorder orderRecorder;

    public CokeFunc(OrderRecorder orderRecorder) {
        this.orderRecorder = orderRecorder;
    }

    public void cokeFunc(JLayeredPane layeredPane, JButton cokeButton, JScrollPane scrollPane) {
        cokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon cokeChosen = new ImageIcon("resources/assets/cards/chosen-coke.png");
                JLabel backgroundLabel = new JLabel(cokeChosen);
                backgroundLabel.setBounds(0, 0, cokeChosen.getIconWidth(), cokeChosen.getIconHeight());

                //Adds the background of Adobo selected card to the layered pane
                layeredPane.add(backgroundLabel, Integer.valueOf(3));

                //Sets the label of the quantity counter, starting String and positioning
                quantLabel = new JLabel(Integer.toString(counter));
                quantLabel.setBounds(295, 935, 50, 35);

                //Confirm Button Initialization
                ImageIcon confirmIcon = new ImageIcon("resources/assets/btns/ConfirmBtn.png");
                JButton confirmButton = new JButton(init.imageIconSetup(confirmIcon, 218, 59));
                init.buttonSetup(confirmButton, 191, 1070, 218, 59);

                //Plus Button Initialization
                ImageIcon addIcon = new ImageIcon("resources/assets/btns/GreenAddBtn.png");
                JButton addButton = new JButton(init.imageIconSetup(addIcon, 48, 48));
                init.buttonSetup(addButton, 385, 930, 48, 48);

                //Minus Button Initialization
                ImageIcon minusIcon = new ImageIcon("resources/assets/btns/Minus.png");
                JButton minusButton = new JButton(init.imageIconSetup(minusIcon, 48, 48));
                init.buttonSetup(minusButton, 166, 930, 48, 48);

                //Functionality of all the buttons
                addQuant(layeredPane, addButton);
                minusQuant(layeredPane, minusButton);
                confirm(layeredPane, confirmButton, addButton, minusButton, backgroundLabel, scrollPane);

                //Sets the font of the quantity label
                init.fontSetterMont(30, quantLabel);

                layeredPane.add(confirmButton, Integer.valueOf(4));
                layeredPane.add(quantLabel, Integer.valueOf(4));
                layeredPane.add(addButton, Integer.valueOf(4));
                layeredPane.add(minusButton, Integer.valueOf(4));

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        scrollPane.getVerticalScrollBar().setValue(0);
                    }
                });

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        //Hand cursor on hover
        init.mouseListener(cokeButton);
    }

    public void confirm(JLayeredPane layeredPane, JButton confirmButton, JButton addButton, JButton minusButton, JLabel backgroundLabel, JScrollPane scrollPane){
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderRecorder.addQuant(getCount());
                orderRecorder.addOrder(orderId);

                layeredPane.remove(confirmButton);
                layeredPane.remove(addButton);
                layeredPane.remove(quantLabel);
                layeredPane.remove(backgroundLabel);
                layeredPane.remove(minusButton);

                counter = 1;

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        scrollPane.getVerticalScrollBar().setValue(0);
                    }
                });


                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        init.mouseListener(confirmButton);
    }

    public void addQuant(JLayeredPane layeredPane, JButton addButton){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;

                quantLabel.setText(Integer.toString(counter));
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        init.mouseListener(addButton);
    }

    public void minusQuant(JLayeredPane layeredPane, JButton minusButton){
        Init init = new Init();
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                quantLabel.setText(Integer.toString(counter));
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        init.mouseListener(minusButton);

    }

    public int getCount(){
        return counter;
    }
}