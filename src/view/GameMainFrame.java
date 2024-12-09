package view;

import java.awt.Window;
import javax.swing.*;

/**
 * This class is to create basic JComponent.
 */
public class GameMainFrame extends JFrame{
    public GameMainFrame(){
        super("SOKOBAN");

        this.setLayout(null);

        this.setBounds(0,0,800,400);
        this.setLocationRelativeTo(null);

        // components
        ImageIcon startIcon;
        JButton startButton;
        ImageIcon RegisterIcon;
        JButton RegisterButton;
        ImageIcon exitIcon;
        JButton exitButton;

        

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}