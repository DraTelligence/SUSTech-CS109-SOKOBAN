package view.game.informationPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

@SuppressWarnings("FieldMayBeFinal")
public class InformationPanelBody extends JComponent {
    public InformationPanelBody() {
        this.setBounds(0, -10, 555, 190);
    }

    @Override
    public void paintComponent(Graphics panel) {
        Graphics2D g2d = (Graphics2D) panel.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // paint the shadow
        final int SHADOW_WIDTH = 5;
        g2d.setColor(new Color(0, 0, 0, 30));
        g2d.fillRoundRect(0 - SHADOW_WIDTH, -30 - SHADOW_WIDTH, 543 + SHADOW_WIDTH * 2, 185 + SHADOW_WIDTH * 2,
                40 + SHADOW_WIDTH, 30 + SHADOW_WIDTH);

        // paint a round-corner rectangle
        g2d.setColor(new Color(220, 140, 45));
        g2d.fillRoundRect(0, -30, 543, 185, 40, 30);
    }
}
