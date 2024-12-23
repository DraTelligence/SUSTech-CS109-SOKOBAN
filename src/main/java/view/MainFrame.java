package view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.AppController;

/**
 * The MainFrame is the only frame of the game. The frame uses cardLayout, and
 * contains four different panels.
 */
public class MainFrame extends JFrame {
    private final AppController appController = AppController.getInstance();

    private static MainFrame instance;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    private MainFrame() {
        super("SOKOBAN");

        // initialize the frame
        this.setLayout(null);
        this.setSize(new Dimension(555, 785));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setMaximizedBounds(getBounds());

        // when the window is closed, let appController handle it
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appController.handleWindowClosing();
            }
        });
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public void start(){
        appController.start();
        this.setVisible(true);
    }
}
