package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This class is to create basic JComponent.
 */
public class MainFrame_desserted extends JFrame {
    public MainFrame_desserted() {
        super("SOKOBAN");

        this.setLayout(null);

        this.setBounds(0, 0, 800, 400);
        this.setLocationRelativeTo(null);

        // components
        ImageIcon startIcon = new ImageIcon("icons\\start.png");
        ImageIcon registerIcon = new ImageIcon("icons\\register.png");
        ImageIcon exitIcon = new ImageIcon("icons\\exit.png");

        InvisibleButton startButton = new InvisibleButton(startIcon, _ -> {
        });
        InvisibleButton RegisterButton = new InvisibleButton(registerIcon, _ -> {
        });
        InvisibleButton exitBUtton = new InvisibleButton(exitIcon, _ -> {
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class InvisibleButton extends JButton {
        InvisibleButton(final ImageIcon image, final ActionListener a) {
            // set the button invisible
            this.setContentAreaFilled(false);
            this.setBorder(null);

            // set the size of the button according to the image
            this.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconWidth()));

            // set the location of the button align with the image
            // TODO: set location

            this.setVisible(true);
            this.addActionListener(a);
        }
    }
}