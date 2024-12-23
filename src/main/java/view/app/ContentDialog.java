package view.app;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ContentDialog extends JDialog {
    public ContentDialog(String text) {
        super((Dialog) null);

        JLabel contentLabel1 = new JLabel(text);

        // set the font of two labels
        contentLabel1.setFont(new Font("", Font.ROMAN_BASELINE, 16));

        // set the color of the content
        contentLabel1.setForeground(Color.black);

        // set the location of two labels
        contentLabel1.setBounds(245, 80, 280, 45);

        contentLabel1.setAlignmentX(TOP_ALIGNMENT);

        // set two buttons to confirm/cancel
        JButton confirmButton = new JButton("好吧");
        confirmButton.setBackground(Color.LIGHT_GRAY);
        confirmButton.setBorderPainted(false);
        confirmButton.setBounds(125, 186, 98, 31);

        this.add(confirmButton);
        this.add(contentLabel1);

        this.setSize(new Dimension(350,300));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // add ActionListner to two buttons
        confirmButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            this.dispose();
        });
    }
}
