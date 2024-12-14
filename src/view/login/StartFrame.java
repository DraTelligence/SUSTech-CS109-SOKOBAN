package view.login;

import view.FrameUtil;
import view.level.LevelFrame;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {
    private JButton start;
    private JButton select;
    private JButton quit;
    private JButton setting;

    public StartFrame(){
        ImageIcon loginBackground = new ImageIcon("src/pictures/startBackground.png");
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

        start = FrameUtil.createButton(this, "", new Point(170, 365), 200, 40);
        start.setContentAreaFilled(false);
        select = FrameUtil.createButton(this, "", new Point(170, 425), 200, 40);
        select.setContentAreaFilled(false);
        quit = FrameUtil.createButton(this, "", new Point(170, 480), 200, 40);
        quit.setContentAreaFilled(false);
        setting = FrameUtil.createButton(this, "", new Point(230, 550), 100, 40);
        setting.setContentAreaFilled(false);

        start.addActionListener(e -> {
            this.dispose();
            LoginFrame loginFrame = new LoginFrame(500,300);
            loginFrame.setVisible(true);
            LevelFrame levelFrame = new LevelFrame(500,300);
            levelFrame.setVisible(false);
            loginFrame.setLevelFrame(levelFrame);
        });
        select.addActionListener(e -> {

        });
        quit.addActionListener(e -> {
            this.dispose();
        });
        setting.addActionListener(e -> {

        });
    }
}
