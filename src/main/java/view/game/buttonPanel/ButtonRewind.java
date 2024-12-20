package view.game.buttonPanel;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.FunctionButtonState;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonRewind extends AreaButton {
    public ButtonRewind() {
        super("doRewind", FunctionButtonState.NORMAL);

        this.setBounds(0, 0, 555, 785);

        Area buttonArea = new Area();

        // creat area of the button
        buttonArea.add(new Area(new RoundRectangle2D.Double(22, 667, 85, 60, 8, 8)));
        buttonArea.add(new Area(new RoundRectangle2D.Double(64, 619, 43, 50, 8, 8)));
        buttonArea.add(new Area(new Ellipse2D.Double(22, 619, 85, 100)));

        this.setButtonArea(buttonArea);
    }
}
