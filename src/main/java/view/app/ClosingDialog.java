package view.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controller.AppController;

public class ClosingDialog extends JDialog {
    @SuppressWarnings("unused")
    public ClosingDialog() {
        System.out.println("trying to exit...");

        JLabel contentLabel1 = new JLabel("R U sure to close the game?");
        JLabel contentLabel2 = new JLabel("unsaved game will be saved");

        // set the font of two labels
        contentLabel1.setFont(new Font("", Font.ROMAN_BASELINE, 18));
        contentLabel2.setFont(new Font("", Font.ROMAN_BASELINE, 16));

        // set the color of the content
        contentLabel1.setForeground(Color.black);
        contentLabel2.setForeground(Color.black);

        // set the location of two labels
        contentLabel1.setBounds(65, 40, 280, 45);
        contentLabel2.setBounds(65, 65, 280, 45);

        contentLabel1.setAlignmentX(TOP_ALIGNMENT);

        // set two buttons to confirm/cancel
        JButton confirmButton = new JButton("YES");
        JButton cancelButton = new JButton("NO");
        confirmButton.setBackground(Color.LIGHT_GRAY);
        confirmButton.setBorderPainted(false);
        confirmButton.setBounds(65, 126, 98, 31);
        cancelButton.setBounds(175, 126, 98, 31);
        cancelButton.setBackground(Color.LIGHT_GRAY);
        cancelButton.setBorderPainted(false);

        // add ActionListner to two buttons
        confirmButton.addActionListener((ActionEvent e) -> {
            try {
                checkAutoSavingWhenWindowClosed();
            } catch (NullPointerException exception) {
                System.out.println(exception.getMessage());
            }

            System.exit(0);
        });
        cancelButton.addActionListener((ActionEvent e) -> {
            this.dispose();
            this.setVisible(false);
        });

        // add components to dialog
        this.add(contentLabel1);
        this.add(contentLabel2);
        this.add(confirmButton);
        this.add(cancelButton);

        // set the dialog
        this.setTitle("really wanna quit???");
        this.setLayout(null);
        this.setModal(true);
        this.setSize(400, 230);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void checkAutoSavingWhenWindowClosed() throws NullPointerException {
        AppController.getInstance().exitProgram();
    }
}