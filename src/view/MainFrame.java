package view;

import java.awt.CardLayout;
import javax.swing.*;
import view.panels.*;

/**
 * The MainFrame is the only frame of the game. The frame uses cardLayout, and
 * contains four different panels.
 */
public class MainFrame extends JFrame {
    private JPanel[] panels;

    public MainFrame() {
        super("SOKOBAN");

        panels = new JPanel[4];

        CardLayout layout = new CardLayout();
        this.setLayout(layout);

        this.setBounds(0, 0, 800, 400);
        this.setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        LevelSelectMenuPanel levelSelectMenuPanel = new LevelSelectMenuPanel();
        UserSystemPanel userSystemPanel = new UserSystemPanel();
        MainMenuPanel mainMenuPanel = new MainMenuPanel();

        this.add(mainMenuPanel, "main menu panel");
        this.add(gamePanel, "game panel");
        this.add(userSystemPanel, "user system panel");
        this.add(levelSelectMenuPanel, "level select menu panel");

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}