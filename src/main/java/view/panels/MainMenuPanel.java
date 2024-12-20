package view.panels;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import controller.MainMenuController;

@SuppressWarnings("unused")
public class MainMenuPanel extends JLayeredPane {
    private final MainMenuController controller;
    JButton buttons[] = new JButton[4];
    JButton startButton, settingsButton, exitButton , logInButton;

    public MainMenuPanel(MainMenuController controller) {
        this.setBounds(0,0,555,785);
        this.controller=controller;
        this.setOpaque(false);
        this.setLayout(null);
        
        // add background picture
        ImageIcon loginBackground = new ImageIcon("icons\\Backgrounds\\startBackground.png");
        loginBackground.setImage(loginBackground.getImage().getScaledInstance(555, 785, Image.SCALE_DEFAULT));
        JLabel BgImage = new JLabel(loginBackground);
        BgImage.setBounds(0, 0, loginBackground.getIconWidth(), loginBackground.getIconHeight());
        
        this.add(BgImage);
        this.moveToBack(BgImage);

        // add buttons
        this.startButton =new JButton("start");
        this.logInButton=new JButton("user");
        this.exitButton=new JButton("exit");
        this.settingsButton=new JButton("settings");

        buttons[0]=startButton;
        buttons[1]=logInButton;
        buttons[2]=exitButton;
        buttons[3]=settingsButton; 

        this.startButton.setBounds(170,365,200,40);
        this.logInButton.setBounds(170, 425, 200, 40);
        this.settingsButton.setBounds(230, 550, 100, 40);
        this.exitButton.setBounds(170,480,200,40);

        for(var button:buttons){
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            this.add(button);
        }
    }

    public void addMenuListener(ActionListener listener){
        for(var button: buttons){
            button.addActionListener(listener);
        }
    }
}