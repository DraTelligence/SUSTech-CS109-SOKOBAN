package view.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class InformationPanel extends JPanel {
    public InformationPanel() {
        
    }
    

    @Override
    public void paintComponent(Graphics panel){
        Graphics2D g2d= (Graphics2D)panel.create();

        //paint a inner shadow
        int shadowWidth=10;
        int shift=0,opacity=40;
        for(;shift<=shadowWidth;){
            g2d.setColor;
            g2d.drawRoundRect(opacity, opacity, shadowWidth, shift, shadowWidth, opacity);;
        }
        
        // paint a round-corner rectangle
        g2d.fillRoundRect(0, -20, 555, 185, 70, 30);
        
    }
}
