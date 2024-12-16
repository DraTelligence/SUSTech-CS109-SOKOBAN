package view.game.buttonPanel;

import java.awt.geom.Area;
import javax.swing.JComponent;
import view.game.buttonPanel.buttonState.ButtonState;

public abstract class AreaButton extends JComponent{
    public abstract void setButtonArea(Area buttonArea);

    public abstract Area getButtonArea();

    public abstract void setColor(ButtonState buttonState);
    public abstract void setPressed();
    public abstract void setEntered();
    public abstract void setNormal();

    public abstract String getCommand();
}