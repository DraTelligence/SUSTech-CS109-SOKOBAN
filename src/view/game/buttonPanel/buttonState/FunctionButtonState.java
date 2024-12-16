package view.game.buttonPanel.buttonState;

import java.awt.Color;

public enum FunctionButtonState implements ButtonState {
    NORMAL(new Color(255, 255, 255), new Color(65, 190, 65)),
    ENTERED(new Color(255, 255, 255), new Color(45, 155, 30)),
    PRESSED(new Color(164, 233, 164), new Color(115, 210, 115));

    private final Color TEXT_COLOR;
    private final Color BUTTON_COLOR;

    private FunctionButtonState(Color textColor, Color bottonColor) {
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
}
