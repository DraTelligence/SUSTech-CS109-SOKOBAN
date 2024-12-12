package view.panels;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JLayeredPane;

public class GameMainPanel extends JLayeredPane {
    private final int MAP_LAYER = 1;
    private final int GUI_LAYER = 2;

    public GameMainPanel(Dimension size, CardLayout ownerLayout) {
        // initialize the panel
        this.setSize(size);

        
    }
}