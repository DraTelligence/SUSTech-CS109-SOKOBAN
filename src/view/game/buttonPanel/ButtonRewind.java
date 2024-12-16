package view.game.buttonPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonRewind extends ButtonFunction{
    public ButtonRewind(){
        this.setBounds(0,0,555,785);
        this.setOpaque(false);

        Area buttonArea=new Area();

        // creat area of the button
        buttonArea.add(new Area(new RoundRectangle2D.Double(22, 667, 85, 60,8,8)));
        buttonArea.add(new Area(new RoundRectangle2D.Double(64,619,43,50,8,8)));
        buttonArea.add(new Area(new Ellipse2D.Double(22, 619, 85, 100)));

        this.setButtonArea(buttonArea);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d= (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(this.getButtonColor());
        g2d.fill(this.getButtonArea());

        g2d.dispose();
    }

    @Override
    public String getCommand() {
        return "REWIND";
    }
}
