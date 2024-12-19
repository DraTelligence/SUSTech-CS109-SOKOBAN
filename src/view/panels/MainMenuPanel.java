package view.panels;

import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

@SuppressWarnings("unused")
public class MainMenuPanel extends JLayeredPane {
    private final CardLayout ownerLayout;
    JButton startButton, settingsButton, exitButton , logInButton;

    public MainMenuPanel(CardLayout ownerLayout) {
        this.setBounds(0,0,555,785);
        this.ownerLayout=ownerLayout;
        this.setOpaque(false);
        this.setLayout(null);
        
        // add background picture
        ImageIcon loginBackground = new ImageIcon("E:\\workSpace\\files\\java\\Sokoban\\data\\icons\\Backgrounds\\startBackground.png");
        loginBackground.setImage(loginBackground.getImage().getScaledInstance(555, 785, Image.SCALE_DEFAULT));
        JLabel BgImage = new JLabel(loginBackground);
        BgImage.setBounds(0, 0, loginBackground.getIconWidth(), loginBackground.getIconHeight());
        
        this.add(BgImage);
        this.moveToBack(BgImage);

        // add buttons
        this.startButton =new JButton();
        this.logInButton=new JButton();
        this.exitButton=new JButton();
        this.settingsButton=new JButton();

        this.startButton.setBounds(170,365,200,40);
        this.logInButton.setBounds(170, 425, 200, 40);
        this.settingsButton.setBounds(230, 550, 100, 40);
        this.exitButton.setBounds(170,480,200,40);

        this.startButton.setContentAreaFilled(false);
        this.logInButton.setContentAreaFilled(false);
        this.exitButton.setContentAreaFilled(false);
        this.settingsButton.setContentAreaFilled(false);

        this.add(startButton);
        this.add(logInButton);
        this.add(exitButton);
        this.add(settingsButton);

        startButton.addActionListener(e -> {
            ownerLayout.show(this.getParent(), "level select menu panel");
        });
        logInButton.addActionListener(e -> {
            ownerLayout.show(this.getParent(),"user system panel");
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        settingsButton.addActionListener(e -> {
            ownerLayout.show(this.getParent(),"SettingsPanel");
        });
    }

}