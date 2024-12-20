package view.game.buttonPanel.buttonState;

import java.awt.Color;

public interface ButtonState {
    Color getTEXT_COLOR();

    Color getBUTTON_COLOR();

    ButtonState getNormalState();

    ButtonState getPressedState();

    ButtonState getEnteredState();
}