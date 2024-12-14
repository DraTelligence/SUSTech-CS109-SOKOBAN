package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;


public class LoginFrame extends JFrame {
    private JTextField username;
    private JTextField password;
    private JButton submitBtn;
    private JButton resetBtn;
    private LevelFrame levelFrame;


    public LoginFrame(int width, int height) {

        ImageIcon loginBackground = new ImageIcon("src/pictures/loginBackground.png");
        JLabel lGL = new JLabel(loginBackground);
        this.add(lGL);
        lGL.setBounds(0,0,loginBackground.getIconWidth(),loginBackground.getIconHeight());
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel panel =(JPanel) cp;
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());
        this.getLayeredPane().add(lGL, Integer.MIN_VALUE);
        setSize(loginBackground.getIconWidth(),loginBackground.getIconHeight());
        setLocationRelativeTo(null);
        this.setTitle("Login Frame");
        this.setLayout(null);

//        this.setSize(width, height);
        JLabel userLabel = FrameUtil.createJLabel(this, new Point(50, 70), 70, 40, "username:");
        JLabel passLabel = FrameUtil.createJLabel(this, new Point(50, 80), 70, 40, "password:");
        username = FrameUtil.createJTextField(this, new Point(230, 255), 160, 40);
        password = FrameUtil.createJTextField(this, new Point(230, 335), 160, 40);

        submitBtn = FrameUtil.createButton(this, "Confirm", new Point(280, 435), 150, 40);
        submitBtn.setContentAreaFilled(false);
        resetBtn = FrameUtil.createButton(this, "Reset", new Point(130, 435), 150, 40);
        resetBtn.setContentAreaFilled(false);

        submitBtn.addActionListener(e -> {
            System.out.println("Username = " + username.getText());
            System.out.println("Password = " + password.getText());
            if (this.levelFrame != null) {
                this.levelFrame.setVisible(true);
                this.setVisible(false);
            }
            //todo: check login info

        });
        resetBtn.addActionListener(e -> {
            username.setText("");
            password.setText("");
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setLevelFrame(LevelFrame levelFrame) {
        this.levelFrame = levelFrame;
    }
}
