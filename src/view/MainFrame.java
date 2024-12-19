package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import view.panels.GameMainPanel;
import view.panels.LevelSelectMenuPanel;
import view.panels.MainMenuPanel;
import view.panels.UserSystemPanel;

/**
 * The MainFrame is the only frame of the game. The frame uses cardLayout, and
 * contains four different panels.
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super("SOKOBAN");

        Dimension size=new Dimension(555,785);

        CardLayout layout = new CardLayout();
        this.setLayout(layout);

        this.setSize(size);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        GameMainPanel gameMainPanel = new GameMainPanel(layout);
        LevelSelectMenuPanel levelSelectMenuPanel = new LevelSelectMenuPanel(layout);
        UserSystemPanel userSystemPanel = new UserSystemPanel(layout);
        MainMenuPanel mainMenuPanel = new MainMenuPanel(layout);

        this.add(mainMenuPanel, "menu main panel");
        this.add(gameMainPanel, "game main panel");
        this.add(userSystemPanel, "user system panel");
        this.add(levelSelectMenuPanel, "level select menu panel");

        // when the window is closed, do automatic saving
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new CloseDialog().setVisible(true);
            }
        });

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        layout.show(this.getContentPane(),"menu main panel");
    }

    private class CloseDialog extends JDialog {
        @SuppressWarnings("unused")
        public CloseDialog() {
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
    }

    private void checkAutoSavingWhenWindowClosed() throws NullPointerException {
        for (Component p : this.getComponents()) {
            if (p.isShowing() && p.getName().equals("gamePanel")) {
                System.out.println("auto saving...");

                // to be supported
            } else {
                System.out.println("not in game...");
            }
        }
    }
}
