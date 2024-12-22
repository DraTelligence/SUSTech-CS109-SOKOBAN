package view.userSystem;

import model.exceptions.UserAlreadyExistsException;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UserSystemController;
import model.user.UserSystem;

public class LogInPanel extends JLayeredPane {
    private JTextField username;
    private JTextField password;
    final private JButton logInBtn;
    final private JButton signUpBtn;

    @SuppressWarnings("unused")
    public LogIn() {
        this.setBounds(0, 0, 555, 785);

        // set background
        ImageIcon icon = new ImageIcon(
                "E:\\workSpace\\files\\java\\Sokoban\\data\\icons\\Backgrounds\\loginBackground.png");
        icon.setImage(icon.getImage().getScaledInstance(555, 785, Image.SCALE_DEFAULT));
        JLabel background = new JLabel(icon);
        background.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        this.add(background);
        this.moveToBack(background);

        // set a panel to contain other comps
        JPanel userSystemPanel = new JPanel();
        userSystemPanel.setBounds(0, 0, 555, 785);
        userSystemPanel.setOpaque(false);
        userSystemPanel.setLayout(null);

        this.add(userSystemPanel);
        this.moveToFront(userSystemPanel);

        // add other comps
        this.username = createJTextField(new Point(230, 255), 160, 40);
        this.password = createJTextField(new Point(230, 335), 160, 40);

        signUpBtn = createJButton(new Point(90, 435), 150, 40);
        signUpBtn.setContentAreaFilled(false);
        logInBtn = createJButton(new Point(255, 435), 150, 40);
        logInBtn.setContentAreaFilled(false);

        userSystemPanel.add(username);
        userSystemPanel.add(password);
        userSystemPanel.add(logInBtn);
        userSystemPanel.add(signUpBtn);

        signUpBtn.addActionListener((ActionEvent e) -> {
            try {
                UserSystemController.getInstance().signUp(username.getText(), password.getText());
            } catch (UserAlreadyExistsException ex) {
                JDialog dialog = new contentDialog("user already exists!");
            } catch (NullPointerException ex){
                JDialog dialog = new contentDialog("username or password cannot be empty!");
            }
        });

        logInBtn.addActionListener(e -> {
            UserSystemController.getInstance().logIn(username.getText(), password.getText());
        });
    }

    private class contentDialog extends JDialog {
        public contentDialog(String text) {
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

    private static JLabel createJLabel(Point location, int width, int height, String text) {
        JLabel jLabel = new JLabel(text);
        jLabel.setSize(width, height);
        jLabel.setLocation(location);
        return jLabel;
    }

    private static JTextField createJTextField(Point location, int width, int height) {
        JTextField jTextField = new JTextField();
        jTextField.setSize(width, height);
        jTextField.setLocation(location);
        return jTextField;
    }

    private static JButton createJButton(Point location, int width, int height) {
        JButton button = new JButton();
        button.setSize(width, height);
        button.setLocation(location);
        return button;
    }
}
