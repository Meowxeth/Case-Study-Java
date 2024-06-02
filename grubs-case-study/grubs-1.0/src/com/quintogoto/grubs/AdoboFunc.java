package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdoboFunc {
    JLabel quantLabel;
    int counter = 1;
    int orderId = 1;

    Init init = new Init();
    private final OrderRecorder orderRecorder;

    public AdoboFunc(OrderRecorder orderRecorder) {
        this.orderRecorder = orderRecorder;
    }

    public void adoboFunc(JLayeredPane layeredPane, JButton adoboButton, JScrollPane scrollPane, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JButton siniButton, JLabel drinksLabel, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel, JLabel grubsLabel) {
        adoboButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdersCounter ordC = new OrdersCounter(orderRecorder);
                ordC.undisplayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

                init.removeMenu(layeredPane, adoboButton, siniButton, bicolexButton, kalderButton, gulamButton, cokeButton, drinksLabel);

                ImageIcon adoboChosen = new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/chosen-adobo.png");
                JLabel backgroundLabel = new JLabel(adoboChosen);
                backgroundLabel.setBounds(0, 0, adoboChosen.getIconWidth(), adoboChosen.getIconHeight());

                //Adds the background of Adobo selected card to the layered pane
                layeredPane.add(backgroundLabel, Integer.valueOf(3));

                //Return button initialization
                JButton returnButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/return.png", 74, 22));
                init.buttonSetup(returnButton, 477, 28, 74, 22);

                //Sets the label of the quantity counter, starting String and positioning
                quantLabel = new JLabel(Integer.toString(counter));
                quantLabel.setBounds(295, 605, 50, 35);

                //Confirm Button Initialization
                JButton confirmButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/ConfirmBtn.png", 218, 59));
                init.buttonSetup(confirmButton, 191, 698, 218, 59);

                //Plus Button Initialization
                JButton addButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/GreenAddBtn.png", 48, 48));
                init.buttonSetup(addButton, 386, 600, 48, 48);

                //Minus Button Initialization
                JButton minusButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/Minus.png", 48, 48));
                init.buttonSetup(minusButton, 167, 600, 48, 48);

                //Functionality of all the buttons
                addQuant(layeredPane, addButton);
                minusQuant(layeredPane, minusButton);
                confirm(layeredPane, confirmButton, addButton, minusButton, backgroundLabel, adoboButton, bicolexButton, kalderButton, gulamButton, cokeButton, siniButton, drinksLabel, returnButton, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);
                returnBtn(layeredPane, confirmButton, addButton, minusButton, backgroundLabel, adoboButton, bicolexButton, kalderButton, gulamButton, cokeButton, siniButton, drinksLabel, returnButton, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel, grubsLabel);

                //Sets the font of the quantity label
                init.fontSetterMont(30, quantLabel);

                layeredPane.add(returnButton, Integer.valueOf(4));
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
        init.mouseListener(adoboButton);
    }

    public void returnBtn(JLayeredPane layeredPane, JButton confirmButton, JButton addButton, JButton minusButton, JLabel backgroundLabel, JButton adoboButton, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JButton siniButton, JLabel drinksLabel, JButton returnButton, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel, JLabel grubsLabel){
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                layeredPane.remove(returnButton);
                layeredPane.remove(confirmButton);
                layeredPane.remove(addButton);
                layeredPane.remove(quantLabel);
                layeredPane.remove(backgroundLabel);
                layeredPane.remove(minusButton);

                layeredPane.add(adoboButton);
                layeredPane.add(siniButton);
                layeredPane.add(bicolexButton);
                layeredPane.add(kalderButton);
                layeredPane.add(gulamButton);
                layeredPane.add(cokeButton);
                layeredPane.add(drinksLabel);

                counter = 1;

                if(!(orderRecorder.getOrders().isEmpty())){
                    OrdersCounter orderC = new OrdersCounter(orderRecorder);
                    orderC.displayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

                }

                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        init.mouseListener(returnButton);
    }
    public void confirm(JLayeredPane layeredPane, JButton confirmButton, JButton addButton, JButton minusButton, JLabel backgroundLabel, JButton adoboButton, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JButton siniButton, JLabel drinksLabel, JButton returnButton, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel){
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderRecorder.addQuant(getCount());
                orderRecorder.addOrder(layeredPane, orderId);

                layeredPane.remove(returnButton);
                layeredPane.remove(confirmButton);
                layeredPane.remove(addButton);
                layeredPane.remove(quantLabel);
                layeredPane.remove(backgroundLabel);
                layeredPane.remove(minusButton);
                layeredPane.remove(returnButton);

                layeredPane.add(adoboButton);
                layeredPane.add(siniButton);
                layeredPane.add(bicolexButton);
                layeredPane.add(kalderButton);
                layeredPane.add(gulamButton);
                layeredPane.add(cokeButton);
                layeredPane.add(drinksLabel);

                counter = 1;

                if(!(orderRecorder.getOrders().isEmpty())){
                    OrdersCounter orderC = new OrdersCounter(orderRecorder);
                    orderC.displayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

                }

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
                if(counter == 10){
                    // Calculate the position to center the dialog in the 600x800 area
                    int dialogWidth = 300;  // Approximate width of the dialog
                    int dialogHeight = 200; // Approximate height of the dialog
                    int parentWidth = 600;
                    int targetHeight = 800;

                    int x = ((parentWidth - dialogWidth) / 2) + 20;
                    int y = (targetHeight - dialogHeight) / 2;

                    // Array for custom button message for notification
                    Object[] options = {"Go Back to Ordering"};

                    // Create the option dialog
                    JOptionPane pane = new JOptionPane("You reached the quantity limit of 10", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION,null, options,options[0]);

                    JDialog dialog = pane.createDialog(layeredPane, "Quantity Limit Reached");
                    dialog.setLocation(layeredPane.getX() + x, layeredPane.getY() + y);
                    dialog.setVisible(true);
                }
                else{
                    counter++;

                    quantLabel.setText(Integer.toString(counter));
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            }
        });

        init.mouseListener(addButton);


    }

    public void minusQuant(JLayeredPane layeredPane, JButton minusButton){
        Init init = new Init();
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter == 1){
                    System.out.println();
                }
                else{
                    counter--;
                    quantLabel.setText(Integer.toString(counter));
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
            }
        });

        init.mouseListener(minusButton);

    }

    public int getCount(){
        return counter;
    }
}