package org.areas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Areas {

    private static JFrame frame;

    public Areas() {

        if (GraphicsEnvironment.isHeadless()) {

            throw new HeadlessException();
        }

        EventQueue.invokeLater(Areas::createFrameAndGUI);
    }

    private static void addComponents(Container pane) {

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Const array of sides of the world
        final String[] sides = {"North", "West", "Center", "East", "South"};

        // Const array of border layout sides
        final String[] borderLayoutSides = {
                BorderLayout.NORTH,
                BorderLayout.WEST,
                BorderLayout.CENTER,
                BorderLayout.EAST,
                BorderLayout.SOUTH
        };

        // For loop to initialize all panels
        for (int i = 0; i < 5; i++) {

            JPanel tempPanel = new JPanel(new BorderLayout());

            // Add label at the center of the panel
            JLabel label = new JLabel(sides[i], SwingConstants.CENTER);
            tempPanel.add(label, BorderLayout.CENTER);

            // Add visible borders to panel
            tempPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Make panel same size
            tempPanel.setPreferredSize(new Dimension(100, 100));

            // Add panel to mainPanel
            mainPanel.add(tempPanel, borderLayoutSides[i]);
        }

        pane.add(mainPanel);
    }

    private static void createFrameAndGUI() {

        frame = new JFrame("Menu");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addMouseListener(new TargetAreaListener());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addComponents(frame.getContentPane());

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        frame.pack(); // Window will be sized according to the size of its components
        frame.setVisible(true);
    }

    //  Mouse listener for targeting a specific area
    private static class TargetAreaListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // Show a dialog window when mouse enters one of the areas North, West, Center, East, South
            if (e.getY() < 100) {
                JOptionPane.showMessageDialog(frame, "North");
            } else if (e.getX() < 100) {
                JOptionPane.showMessageDialog(frame, "West");
            } else if (e.getX() > 300) {
                JOptionPane.showMessageDialog(frame, "East");
            } else if (e.getY() > 300) {
                JOptionPane.showMessageDialog(frame, "South");
            } else {
                JOptionPane.showMessageDialog(frame, "Center");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            // Show a dialog window when mouse enters one of the areas North, West, Center, East, South
//            if (e.getY() < 100) {
//                JOptionPane.showMessageDialog(frame, "North");
//            }
//            else if (e.getX() < 100) {
//                JOptionPane.showMessageDialog(frame, "West");
//            }
//            else if (e.getX() > 300) {
//                JOptionPane.showMessageDialog(frame, "East");
//            }
//            else if (e.getY() > 300) {
//                JOptionPane.showMessageDialog(frame, "South");
//            }
//            else {
//                JOptionPane.showMessageDialog(frame, "Center");
//            }
        }
    }
}
