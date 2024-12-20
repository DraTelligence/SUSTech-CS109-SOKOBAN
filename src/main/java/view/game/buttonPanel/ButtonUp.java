package view.game.buttonPanel;

import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.DirectionButtonState;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonUp extends AreaButton {

    public ButtonUp() {
        super("moveUp", DirectionButtonState.NORMAL);

        this.setBounds(0,0,555,785);

        Area buttonArea = new Area(new RoundRectangle2D.Double(210,619,135,50,10,10));
        this.setButtonArea(buttonArea);
    }
}
