package com.quintogoto.grubs;

import javax.swing.*; //Importing all the swing tools and classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    protected JLayeredPane layeredPane; //Created a variable to be set as content pane, this is the variable that we would add contents to

    public Main() {
        JFrame frame = new JFrame("GRUBS"); //Sets the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //If the user clicked close then the application will close

        frame.setSize(600, 800); //Sets the initial size of the window to 600 by 800
        frame.setResizable(false); // Making the JFrame not resizable to avoid GUI conflicts

        layeredPane = new JLayeredPane(); // Creating a JLayeredPane to manage layers of components
        layeredPane.setPreferredSize(new java.awt.Dimension(600, 1200)); // Setting the scrollable size of the window, starts with 600 by 800 but when scrolled in extends to 600 by 1200
        layeredPane.setLayout(null); //Layout set to null, the layout would just be the layers

        // Wrap the JLayeredPane in a JScrollPane, Making the window scrollable
        JScrollPane scrollPane = new JScrollPane(layeredPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //Making the Horizontal Bar Disappear

        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        frame.setContentPane(scrollPane); // Sets the content pane to the scrollPane above

        // Create a label to display the image of startup logo
        JLabel startupBackgroundLabel = new JLabel(new ImageIcon("Case-Study-Java/grubs-case-study/grubs-1.0/resources/assets/grubs-startup.png"));
        startupBackgroundLabel.setBounds(0, 0, 600, 1200); // Adjust the size and position as needed
        layeredPane.add(startupBackgroundLabel, Integer.valueOf(5));

        // Create a timer to hide the startup logo after 4 seconds
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startupBackgroundLabel.setVisible(false);
            }
        });

        // Start the timer (it will fire once after 4 seconds)
        timer.setRepeats(false);
        timer.start();

        Menu menuObj = new Menu(scrollPane);
        menuObj.setUpUI(layeredPane); //Displaying the Menu UI
        frame.setVisible(true);

        requestFocusInWindow();//Requests that this Component get the input focus
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


