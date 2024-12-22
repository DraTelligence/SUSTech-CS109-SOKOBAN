package view.game.buttonPanel;

import static java.awt.event.KeyEvent.VK_DOWN;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.DirectionButtonState;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonDown extends AreaButton {
    public ButtonDown() {
        super("moveDown", DirectionButtonState.NORMAL);

        Area buttonArea = new Area(new RoundRectangle2D.Double(210,678,135,50,10,10));
        this.setButtonArea(buttonArea);

        this.setKeyCode(VK_DOWN);
    }
}