package view.game.buttonPanel;

import java.awt.Color;
import java.awt.geom.Area;
import view.game.buttonPanel.buttonState.ButtonState;
import view.game.buttonPanel.buttonState.FunctionButtonState;

public abstract class ButtonFunction extends AreaButton {
    private Area buttonArea;
    private Color buttonColor;
    private Color textColor;

    public ButtonFunction() {
        setColor(FunctionButtonState.NORMAL);
    }

    @Override
    public final void setColor(ButtonState state) {
        this.buttonColor = state.getBUTTON_COLOR();
        this.textColor = state.getTEXT_COLOR();

        repaint();
    }

    @Override
    final public void setPressed(){
        this.setColor(FunctionButtonState.PRESSED);
    }

    @Override
    final public void setNormal(){
        this.setColor(FunctionButtonState.NORMAL);
    }

    @Override
    final public void setEntered(){
        this.setColor(FunctionButtonState.ENTERED);
    }

    @Override
    final public void setButtonArea(Area buttonArea) {
        this.buttonArea = buttonArea;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    @Override
    public Area getButtonArea() {
        return buttonArea;
    }
}
