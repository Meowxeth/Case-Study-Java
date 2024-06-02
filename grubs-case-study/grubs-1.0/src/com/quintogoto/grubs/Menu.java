package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


// This is the Menu where the product cards are displayed
public class Menu{
    OrderRecorder ord = new OrderRecorder(); //Creating an instance of the OrderRecorder class which is responsible for taking note of all the existing orders
    private final JScrollPane scrollPane; //Creating a private variable of the scrollPane to be set the same as the scrollPane from the Main class

    Init init = new Init(); //Creating an instance of the Init class where reusable methods are set
    public Menu(JScrollPane scrollPane){
        this.scrollPane = scrollPane;  //Constructor setting the scrollPane at this Menu class the same as the scrollPane at the Main class
    }

    public void setUpUI(JLayeredPane layeredPane) {
        //Setting up the background image and adding it to layer 1
        init.createBackgroundImage(layeredPane, "Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/bg.png", 1);

        // Adobo Button Initializer
        JButton adoboButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/adobo.png", 217, 305));
        init.buttonSetup(adoboButton, 60, 130, 217, 305);

        // Sinigang Button
        JButton siniButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/sini.png", 217, 305));
        init.buttonSetup(siniButton, 318, 130, 217, 305);

        // Bicol Express Button
        JButton bicolButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/bicolex.png", 217, 305));
        init.buttonSetup(bicolButton, 62, 469, 217, 305);

        // Kaldereta Button
        JButton kaldeButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/kalde.png", 217, 305));
        init.buttonSetup(kaldeButton, 320, 469, 217, 305);

        //Gulaman Button
        JButton gulamButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/gulam.png", 217, 216));
        init.buttonSetup(gulamButton, 62, 861, 217, 216);

        //Coke Button
        JButton cokeButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/coke.png", 217, 216));
        init.buttonSetup(cokeButton, 320, 861, 217, 216);

        //Cancel Button Initialization for Order Display
        JButton cancelButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/cancel.png", 66, 23));
        init.buttonSetup(cancelButton, 372, 77, 80, 28);

        //Checkout Button Initialization for Order Display
        JButton checkoutButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/checkout.png", 66, 23));
        init.buttonSetup(checkoutButton, 458, 77, 80, 28);

        //Grubs logo
        ImageIcon grubsImage = new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/grubs-logo.png");
        JLabel grubsLogoLabel = new JLabel(grubsImage);
        grubsLogoLabel.setBounds(45, 26, 53, 61);
        layeredPane.add(grubsLogoLabel, Integer.valueOf(2));

        //Sets the label of the text that says "ORDERS:"
        JLabel ordersLabel = new JLabel("ORDERS: ");
        ordersLabel.setBounds(416, 35, 104, 24);
        init.fontSetterMont(20, ordersLabel);

        //Orders Quantity label, Displays the actual number of orders, the 1 in "ORDERS: 1"
        JLabel ordersQuantLabel = new JLabel(Integer.toString(ord.getOrders().size()));
        ordersQuantLabel.setBounds(526, 30, 50, 35);
        init.fontSetterMont(20, ordersQuantLabel);

        //A text that says GRUBS MENU
        JLabel grubsLabel = new JLabel("Grubs Menu"); //Timer Display set to 25:00 initially
        grubsLabel.setBounds(98, 33, 345, 55); //Timer Display Positioning
        init.fontSetterMont(40, grubsLabel);

        //Label that displays the text "Drinks"
        JLabel drinksLabel = new JLabel("Drinks");
        drinksLabel.setBounds(32, 803, 500, 47);
        init.fontSetterMont(40, drinksLabel);

        layeredPane.add(grubsLabel, Integer.valueOf(2));
        //Displays all the elements in the layered pane
        init.displayMenu(layeredPane, adoboButton, siniButton, bicolButton, kaldeButton, gulamButton, cokeButton, drinksLabel);



        //Adobo Button Functionality
        AdoboFunc adoboFunc = new AdoboFunc(ord);
        adoboFunc.adoboFunc(layeredPane, adoboButton, scrollPane, bicolButton, kaldeButton, gulamButton, cokeButton, siniButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel, grubsLabel);

        //Sinigang Button Functionality
        SiniFunc siniFunc = new SiniFunc(ord);
        siniFunc.siniFunc(layeredPane, siniButton, scrollPane, kaldeButton, bicolButton, cokeButton, adoboButton, gulamButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

        //Bicol Button Functionality
        BicolFunc bicolFunc = new BicolFunc(ord);
        bicolFunc.bicolFunc(layeredPane, bicolButton, scrollPane, kaldeButton, siniButton, cokeButton, adoboButton, gulamButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

        //Kalde Button Functionality
        KaldeFunc kaldeFunc = new KaldeFunc(ord);
        kaldeFunc.kaldeFunc(layeredPane, kaldeButton, scrollPane, bicolButton, siniButton, cokeButton, adoboButton, gulamButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

        //Gulaman Button Functionality
        GulamFunc gulamFunc = new GulamFunc(ord);
        gulamFunc.gulamFunc(layeredPane, gulamButton, scrollPane, bicolButton, kaldeButton, cokeButton, adoboButton, siniButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

        //Coke Button Functionality
        CokeFunc cokeFunc = new CokeFunc(ord);
        cokeFunc.cokeFunc(layeredPane, cokeButton, scrollPane, bicolButton, kaldeButton, gulamButton, adoboButton, siniButton, drinksLabel, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

        //Checkout Button Functionality
        CheckoutFunc checkoutFunc = new CheckoutFunc(ord);
        checkoutFunc.checkoutFunc(layeredPane, checkoutButton,  cancelButton, ordersLabel, ordersQuantLabel, adoboButton, siniButton, bicolButton, kaldeButton, gulamButton, cokeButton, drinksLabel, grubsLabel);

        //Cancel Button Functionality
        CancelFunc cancelFunc = new CancelFunc(ord);
        cancelFunc.cancelFunc(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);
    }
}
class OrderRecorder {
    ArrayList<Integer> quant = new ArrayList<>(); //An arraylist that stores the quantity of each orders
    ArrayList<Integer> orders = new ArrayList<>(); //An arraylist that stores the orders via orderIDs

    public void addQuant(int value){ //Adds the quantity to the quant Array List
        quant.add(value);
        System.out.println(quant);
    }

    public void addOrder(JLayeredPane layeredPane, int value){ //Adds the order ID to the orders Array List
        if(orders.size() == 8){
            // Calculate the position to center the dialog in the 600x800 area
            int dialogWidth = 300;  // Approximate width of the dialog
            int dialogHeight = 200; // Approximate height of the dialog
            int parentWidth = 600;
            int targetHeight = 800;
            int x = ((parentWidth - dialogWidth) / 2) + 20;
            int y = (targetHeight - dialogHeight) / 2;

            // Array for custom button message for notification
            Object[] options = {"Go Back"};

            // Create the option dialog
            JOptionPane pane = new JOptionPane("You reached the order limit of 8", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION,null, options,options[0]);

            JDialog dialog = pane.createDialog(layeredPane, "Order Limit Reached 8/8");
            dialog.setLocation(layeredPane.getX() + x, layeredPane.getY() + y);
            dialog.setVisible(true);
        }
        else{
            orders.add(value);
            System.out.println(orders);
        }
    }

    public ArrayList<Integer> getOrders(){ //A getter method to get the orders ArrayList
        return orders;
    }
}

class OrdersCounter {
    private final OrderRecorder orderRecorder;

    public OrdersCounter(OrderRecorder orderRecorder){
        this.orderRecorder = orderRecorder;
    }
    public void displayOrders(JLayeredPane layeredPane, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel){
        ordersQuantLabel.setText(Integer.toString(orderRecorder.getOrders().size()));

        layeredPane.add(cancelButton, Integer.valueOf(2));
        layeredPane.add(checkoutButton, Integer.valueOf(2));
        layeredPane.add(ordersLabel, Integer.valueOf(2));
        layeredPane.add(ordersQuantLabel, Integer.valueOf((2)));
    }
    public void undisplayOrders(JLayeredPane layeredPane, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel){
        layeredPane.remove(cancelButton);
        layeredPane.remove(checkoutButton);
        layeredPane.remove(ordersLabel);
        layeredPane.remove(ordersQuantLabel);
    }
}

class CancelFunc{
    Init init = new Init();
    int sum = 0;
    private final OrderRecorder orderRecorder;
    public CancelFunc(OrderRecorder orderRecorder){
        this.orderRecorder = orderRecorder;
    }
    public void cancelFunc(JLayeredPane layeredPane, JButton cancelButton, JButton checkoutButton, JLabel ordersLabel, JLabel ordersQuantLabel){
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdersCounter ordC = new OrdersCounter(orderRecorder); //Creating an instance of the order counter responsible for displaying the order quantities, cancel button, and checkout button

                // Create a label to display the "Order Cancelled" image
                JLabel backgroundLabel = new JLabel(new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/orderCancelled.png"));
                backgroundLabel.setBounds(0, 0, 600, 800);
                layeredPane.add(backgroundLabel, Integer.valueOf(3));

                // Create a timer to hide the label after 3 seconds
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        backgroundLabel.setVisible(false);
                    }
                });

                orderRecorder.orders.clear(); //Clear the orders ArrayList after cancel, cancelling the entire order
                orderRecorder.quant.clear(); //Clear the quant ArrayList after cancel, clearing the quantities currently stored
                ordC.undisplayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel); //Undisplay the orders counter display since there are no orders after clear

                // Start the timer (it will fire once after 3 seconds)
                timer.setRepeats(false);
                timer.start();

                ; sum = 0;//Resets the total price to 0
            }
        });

        init.mouseListener(cancelButton);
    }
}

class CheckoutFunc{
    Init init = new Init();
    private final OrderRecorder orderRecorder;
    String[] arrayList = new String[8]; //String arraylist to store the name of the orders
    int[] priceArrayList = new int[8]; //int arraylist to store the price of the orders
    ArrayList<JLabel> dynamicLabels = new ArrayList<>(); //An Array List to store all dynamic labels to easily remove them after return or confirm checkout
    public CheckoutFunc(OrderRecorder orderRecorder){
        this.orderRecorder = orderRecorder;
    }
    public void checkoutFunc(JLayeredPane layeredPane, JButton checkoutButton, JButton cancelButton, JLabel ordersLabel, JLabel ordersQuantLabel, JButton adoboButton, JButton siniButton, JButton bicolexButton, JButton kalderButton, JButton gulamButton, JButton cokeButton, JLabel drinksLabel, JLabel grubsLabel) {
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelFunc cF = new CancelFunc(orderRecorder); //Creating an instance of the cancel button functionality
                OrdersCounter ordC = new OrdersCounter(orderRecorder); //Creating an instance of the orders counter
                ordC.undisplayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel); //Removing the orders counter display to avoid bugs

                init.removeMenu(layeredPane, adoboButton, siniButton, bicolexButton, kalderButton, gulamButton, cokeButton, drinksLabel); //Removes the menu layer to avoid bugs

                //Creates the background image of the checkout
                ImageIcon backgroundImage = new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/bg.png");
                JLabel backgroundLabel = new JLabel(backgroundImage);
                backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
                layeredPane.add(backgroundLabel, Integer.valueOf(3));

                //Text that displays "CHECKOUT"
                JLabel checkoutLabel = new JLabel("Checkout");
                checkoutLabel.setBounds(27, 20, 300, 70);
                init.fontSetterMont(54, checkoutLabel);
                layeredPane.add(checkoutLabel, Integer.valueOf(4));

                //Return button initialization
                JButton returnButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/ReturnBtn.png", 97, 47));
                init.buttonSetup(returnButton, 440, 29, 97, 47);
                layeredPane.add(returnButton, Integer.valueOf(4));

                //Confirm button initialization
                JButton confirmButton = new JButton(init.imageScaler("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/btns/ConfirmBtn.png", 218, 59));
                init.buttonSetup(confirmButton, 191, 698, 218, 59);
                layeredPane.add(confirmButton, Integer.valueOf(4));

                /*Sets the integer stored in the orders ArrayList to the actual string or name of the order and storing it to teh arrayList. Also sets the corresponding orderId to the corresponding price*/

                for (int i = 0; i < orderRecorder.orders.size(); i++) {
                    if (orderRecorder.orders.get(i) == 1) {
                        arrayList[i] = "Adobo    ₱75"; //\u20B1 is the Peso sign
                        priceArrayList[i] = 75; //Sets the price of the order at index i to 75 if the orderID is 1
                    } else if (orderRecorder.orders.get(i) == 2) {
                        arrayList[i] = "Sinigang    ₱80";
                        priceArrayList[i] = 80;
                    } else if (orderRecorder.orders.get(i) == 3) {
                        arrayList[i] = "Bicol Express    ₱70";
                        priceArrayList[i] = 70;
                    } else if (orderRecorder.orders.get(i) == 4) {
                        arrayList[i] = "Kaldereta    ₱95";
                        priceArrayList[i] = 95;
                    } else if (orderRecorder.orders.get(i) == 5) {
                        arrayList[i] = "Gulaman    ₱50";
                        priceArrayList[i] = 50;
                    } else if (orderRecorder.orders.get(i) == 6) {
                        arrayList[i] = "Coke    ₱45";
                        priceArrayList[i] = 45;
                    } else {
                        arrayList[i] = " ";
                        priceArrayList[i] = 0;
                    }
                }

                int yOffset = 125; //Y offset for the positioning of the labels

                //Sets the orderNameLabel to the names stored in the ith index of the arrayList
                for (int i = 0; i < orderRecorder.orders.size(); i++) {
//                    if(i <= 8){ //Maximum of 8 orders to be displayed on the screen
                    JLabel orderNameLabel = new JLabel(arrayList[i]); //Sets the name
                    orderNameLabel.setBounds(27, yOffset + 7, 500, 60); //Sets the positioning
                    init.fontSetterPublicSans(30, orderNameLabel); //Sets the font
                    layeredPane.add(orderNameLabel, Integer.valueOf(4)); //Add it to the layer
                    dynamicLabels.add(orderNameLabel); // Add to the list of dynamiclabels displayed

                    JLabel priceLabel = new JLabel("₱" + Integer.toString(priceArrayList[i] * orderRecorder.quant.get(i))); //The price of the item * the quantity is the final price

                    cF.sum += (priceArrayList[i] * orderRecorder.quant.get(i)); //Sums up all the final prices to calculate the total
                    priceLabel.setBounds(460, yOffset + 7, 250, 60); //Sets the positioning of the prices
                    init.fontSetterPublicSans(30, priceLabel);
                    layeredPane.add(priceLabel, Integer.valueOf(4));
                    dynamicLabels.add(priceLabel); // Add to list

                    yOffset += 65; // Adjust the y-offset for the next item
//                    }
                }

                //Displays the quantity of each item
                for (int i = 0; i < orderRecorder.quant.size(); i++) {
                    if (i < 8) {
                        if (orderRecorder.quant.get(i) != null) {
                            JLabel quantityLabel = new JLabel("x" + orderRecorder.quant.get(i));
                            quantityLabel.setBounds(353, 132 + (i * 65), 250, 60); // Dynamically set the Y position based on index
                            init.fontSetterPublicSans(30, quantityLabel);
                            layeredPane.add(quantityLabel, Integer.valueOf(4)); // Adding the label to the layered pane
                            dynamicLabels.add(quantityLabel); // Add to list
//                        }
////                        else{
////                            System.out.println("Do Nothing");
////                        }
                        }
//                    else{
//                        System.out.println("Do Nothing");
//                    }
                    }
                }

                //Displays the text TOTAL
                JLabel totalLabel = new JLabel("TOTAL");
                totalLabel.setBounds(24, 645, 300, 70);
                init.fontSetterMont(35, totalLabel);
                layeredPane.add(totalLabel, Integer.valueOf(4));

                JLabel numTotalLabel = new JLabel("₱" + cF.sum); //Displays the total price of all items
                numTotalLabel.setBounds(434, 640, 300, 70); //Positioning
                init.fontSetterMont(40, numTotalLabel); //Sets the font
                layeredPane.add(numTotalLabel, Integer.valueOf(4)); //Add to layer 4

                //Return button listener
                returnButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //If orders ArrayList is not empty then display the order counter display
                        if(!(orderRecorder.getOrders().isEmpty())){
                            OrdersCounter orderC = new OrdersCounter(orderRecorder);
                            orderC.displayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);
                        }

                        //Displays the menu back if return is pressed
                        init.displayMenu(layeredPane, adoboButton, siniButton, bicolexButton, kalderButton, gulamButton, cokeButton, drinksLabel);

                        // Remove all dynamically added components from the layeredPane, the order names, quantity and the prices
                        for (JLabel label : dynamicLabels) {
                            layeredPane.remove(label);
                        }
                        // Clear the list after removing the labels
                        dynamicLabels.clear();

                        layeredPane.remove(checkoutLabel);
                        layeredPane.remove(backgroundLabel);
                        layeredPane.remove(returnButton);
                        layeredPane.remove(totalLabel);
                        layeredPane.remove(numTotalLabel);
                        layeredPane.remove(confirmButton);

                        //removes the buttons and other labels if return is pressed
                        init.removeCheckout(layeredPane, backgroundLabel, returnButton, totalLabel, numTotalLabel, confirmButton, checkoutLabel);

                        // Revalidate and repaint the layeredPane to update the UI
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
                });

                init.mouseListener(returnButton);

                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        init.displayMenu(layeredPane, adoboButton, siniButton, bicolexButton, kalderButton, gulamButton, cokeButton, drinksLabel);
                        OrdersCounter ordC = new OrdersCounter(orderRecorder);

                        // Create a label to display the image of order successful
                        JLabel successBackgroundLabel = new JLabel(new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/cards/orderSuccess.png"));
                        successBackgroundLabel.setBounds(0, 0, 600, 800); // Adjust the size and position as needed
                        layeredPane.add(successBackgroundLabel, Integer.valueOf(5));

                        // Create a timer to hide the label after 3 seconds
                        Timer timer = new Timer(3000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                successBackgroundLabel.setVisible(false);
                            }
                        });

                        //Removes  the orderNames, quantity, prices
                        for (JLabel label : dynamicLabels) {
                            layeredPane.remove(label);
                        }

                        // Clear the list after removing the labels
                        dynamicLabels.clear();

                        init.removeCheckout(layeredPane, backgroundLabel, returnButton, totalLabel, numTotalLabel, confirmButton, checkoutLabel);

                        orderRecorder.orders.clear();
                        orderRecorder.quant.clear();
                        ordC.undisplayOrders(layeredPane, cancelButton, checkoutButton, ordersLabel, ordersQuantLabel);

                        // Start the timer (it will fire once after 3 seconds)
                        timer.setRepeats(false);
                        timer.start();
                    }
                });

                init.mouseListener(confirmButton);
            }
        });

        init.mouseListener(checkoutButton);
    }
}


