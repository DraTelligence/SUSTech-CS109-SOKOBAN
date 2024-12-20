package view.game.buttonPanel;

import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.DirectionButtonState;
@SuppressWarnings("FieldMayBeFinal")
public class ButtonLeft extends AreaButton {

    public ButtonLeft() {
        super("moveLeft", DirectionButtonState.NORMAL);

        Area buttonArea = new Area(new RoundRectangle2D.Double(124,619,78,108,10,10));
        this.setButtonArea(buttonArea);
    }
}
