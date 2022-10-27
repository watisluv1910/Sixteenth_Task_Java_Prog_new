package org.stylePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StylePicker {

    private static JFrame frame;

    public StylePicker() {

        if (GraphicsEnvironment.isHeadless()) {

            throw new HeadlessException();
        }

        EventQueue.invokeLater(StylePicker::createFrameAndGUI);
    }

    private static void addComponents(Container contentPane) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create menu to choose color and font style
        JMenuBar menuBar = new JMenuBar();

        JMenu colorMenu = new JMenu("Color");
        JMenu fontStyleMenu = new JMenu("Font style");

        // Create menu items for color menu
        JMenuItem redMenuItem = new JMenuItem("Red");
        JMenuItem blackMenuItem = new JMenuItem("Black");
        JMenuItem blueMenuItem = new JMenuItem("Blue");

        // Create menu items for font style menu
        JMenuItem timesNewRoman = new JMenuItem("Times New Roman");
        JMenuItem sansSerif = new JMenuItem("Sans Serif");
        JMenuItem courierNew = new JMenuItem("Courier New");

        // Add menu items to color menu
        colorMenu.add(redMenuItem);
        colorMenu.add(blackMenuItem);
        colorMenu.add(blueMenuItem);

        // Add menu items to font style menu
        fontStyleMenu.add(timesNewRoman);
        fontStyleMenu.add(sansSerif);
        fontStyleMenu.add(courierNew);

        // Add color menu and font style menu to menu bar
        menuBar.add(colorMenu);
        menuBar.add(fontStyleMenu);

        // Add menu bar to main panel
        mainPanel.add(menuBar, BorderLayout.NORTH);

        // Hashmap  of Color() values with color names
        var colorMap = Map.of(
                "Red", Color.RED,
                "Black", Color.BLACK,
                "Blue", Color.BLUE
        );

        // Create text area
        JTextArea textArea = new JTextArea();

        // Create for loop to initialize all menu items with action listeners
        for (int i = 0; i < 3; i++) {

            // Add action listener to color menu items
            colorMenu.getItem(i).addActionListener(e -> {

                // Get text from menu item
                String color = e.getActionCommand();

                // Set color to textarea text
                textArea.setForeground(colorMap.get(color));
            });

            // Add action listener to font style menu items
            fontStyleMenu.getItem(i).addActionListener(e -> {

                // Get text from menu item
                String fontStyle = e.getActionCommand();

                // Set font style to label
                textArea.setFont(new Font(fontStyle, Font.PLAIN, textArea.getFont().getSize()));
            });
        }

        // Add text area to main panel
        mainPanel.add(textArea, BorderLayout.CENTER);

        // Add main panel to content pane
        contentPane.add(mainPanel);
    }

    private static void createFrameAndGUI() {

        frame = new JFrame("Menu");
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addComponents(frame.getContentPane());

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        // frame.pack(); // Window will be sized according to the size of its components
        frame.setVisible(true);
    }
}
