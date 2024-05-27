package com.quintogoto.grubs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
public class Main extends JFrame{
    protected JLayeredPane layeredPane;

    public Main(){
        setTitle("Grubs");
        setSize(600, 900);
        setResizable(false); // Making the JFrame not resizable
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

        layeredPane = new JLayeredPane(); // Creating a JLayeredPane to manage layers of components
        setContentPane(layeredPane); // Setting the content pane of the JFrame to the JLayeredPane



        Menu menuObj = new Menu();
        menuObj.setUpUI(layeredPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Using SwingUtilities.invokeLater to run the GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creating an instance of the Main class to start the application
                new Main();
            }
        });
    }
}
