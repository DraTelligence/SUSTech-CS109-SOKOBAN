package view.game.buttonPanel;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import view.game.buttonPanel.buttonState.FunctionButtonState;

@SuppressWarnings("FieldMayBeFinal")
public class ButtonHint extends AreaButton{
    public ButtonHint(){
        super("getHint", FunctionButtonState.NORMAL);

        Area buttonArea=new Area();

        // creat area of the button
        buttonArea.add(new Area(new RoundRectangle2D.Double(448, 667, 85, 60,8,8)));
        buttonArea.add(new Area(new RoundRectangle2D.Double(448,619,43,50,8,8)));
        buttonArea.add(new Area(new Ellipse2D.Double(448, 619, 85, 100)));

        this.setButtonArea(buttonArea);
    }
}
