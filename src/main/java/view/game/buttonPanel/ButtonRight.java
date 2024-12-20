package view.game.buttonPanel;

import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.DirectionButtonState;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonRight extends AreaButton {

    public ButtonRight() {
        super("moveRight", DirectionButtonState.NORMAL);

        this.setBounds(0, 0, 555, 785);

        Area buttonArea = new Area(new RoundRectangle2D.Double(353, 619, 78, 108, 10, 10));
        this.setButtonArea(buttonArea);
    }
}
