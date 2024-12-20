package view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.AppController;

/**
 * The MainFrame is the only frame of the game. The frame uses cardLayout, and
 * contains four different panels.
 */
public class MainFrame extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 785; 

    private final CardLayout layout = new CardLayout();  
    private final JPanel cardPanel = new JPanel(layout);
    private final AppController appControllor = AppController.getInstance(layout,cardPanel);

    public MainFrame() {
        super("SOKOBAN");

        // initialize the frame
        this.setLayout(null);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setMaximizedBounds(getBounds());

        // when the window is closed, let appControllor handle it
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                appControllor.handleWindowClosing();
            }
        });
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        appControllor.start();
    }
}
