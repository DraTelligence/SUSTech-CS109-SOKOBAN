package view.game.buttonPanel.buttonState;

import java.awt.Color;

public enum DirectionButtonState implements ButtonState {
    NORMAL(new Color(255, 255, 255), new Color(120, 85, 70)),
    ENTERED(new Color(255, 255, 255), new Color(95, 65, 55)),
    PRESSED(new Color(190, 170, 165), new Color(190, 170, 165));

    private final Color TEXT_COLOR;
    private final Color BUTTON_COLOR;

    private DirectionButtonState(Color textColor, Color bottonColor) {
        this.TEXT_COLOR = textColor;
        this.BUTTON_COLOR = bottonColor;
    }

    @Override
    public Color getTEXT_COLOR() {
        return TEXT_COLOR;
    }

    @Override
    public Color getBUTTON_COLOR() {
        return BUTTON_COLOR;
    }

    @Override
    public ButtonState getNormalState() {
        return NORMAL;
    }

    @Override
    public ButtonState getPressedState() {
        return PRESSED;
    }

    @Override
    public ButtonState getEnteredState() {
        return ENTERED;
    }
}