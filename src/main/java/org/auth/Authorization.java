package org.auth;

import org.app.SpringUtilities;

import javax.swing.*;
import java.awt.*;

public class Authorization {

    private static JFrame frame;

    public Authorization() {

        if (GraphicsEnvironment.isHeadless()) {

            throw new HeadlessException();
        }

        EventQueue.invokeLater(Authorization::createFrameAndGUI);
    }

    private static void addComponents(Container contentPane) {

        // Password check panel
        JPanel passwordCheckPanel = new JPanel(new SpringLayout());

        // Array with labels
        String[] labels = {"Service: ", "Username: ", "Password: "};

        // For loop to initialize all labels
        for (int i = 0; i < 3; i++) {

            // Add label to panel
            JLabel label = new JLabel(labels[i], SwingConstants.RIGHT);
            JTextField textField = new JTextField(20);
            label.setLabelFor(textField);

            // Add text field to panel from generated text field
            passwordCheckPanel.add(label);
            passwordCheckPanel.add(textField);
        }

        SpringUtilities.makeCompactGrid(passwordCheckPanel,
                3, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        // Add passwordCheckPanel to contentPane
        contentPane.add(passwordCheckPanel, BorderLayout.CENTER);
    }

    private static void createFrameAndGUI() {

        frame = new JFrame("Menu");
        frame.setSize(400, 150);
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
