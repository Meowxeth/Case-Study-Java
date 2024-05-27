package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Main extends JFrame {
    protected JLayeredPane layeredPane;

    public Main() {
//        setTitle("Grubs");
//        setSize(600, 800);
//      setResizable(false); // Making the JFrame not resizable
        JFrame frame = new JFrame("Grubs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the User Clicked Close, The Window will Close
        // Create a KeyStroke for the ESC key
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

        // Map the KeyStroke to an action key
        String actionKey = "ESCAPE";

        // Get the InputMap and ActionMap for the root pane
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getRootPane().getActionMap();

        // Add the key binding90
        inputMap.put(escapeKeyStroke, actionKey);
        actionMap.put(actionKey, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setSize(600, 800);
        frame.setResizable(false); // Making the JFrame not resizable


        layeredPane = new JLayeredPane(); // Creating a JLayeredPane to manage layers of components
        layeredPane.setPreferredSize(new java.awt.Dimension(600, 1200)); // Example size
        layeredPane.setLayout(null);
         // Setting the content pane of the JFrame to the JLayeredPane

        // Wrap the JLayeredPane in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(layeredPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.setContentPane(scrollPane);

        Menu menuObj = new Menu();
        menuObj.setUpUI(layeredPane); //Displaying the Menu UI
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Using SwingUtilities.invokeLater to run the GUI code on the Event Dispatch
        // Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creating an instance of the Main class to start the application
                new Main();
            }
        });
    }
}
