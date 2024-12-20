package view.game;

import java.util.ArrayList;
import javax.swing.JLayeredPane;
import view.game.buttonPanel.*;


public class ButtonPanel extends JLayeredPane{
    final private ArrayList<AreaButton> buttons;

    public ButtonPanel(){
        this.setBounds(0,0,555,785);
        this.setOpaque(false);

        buttons=new ArrayList<>(6);

        buttons.add(new ButtonLeft());
        buttons.add(new ButtonRight());
        buttons.add(new ButtonUp());
        buttons.add(new ButtonDown());
        buttons.add(new ButtonRewind());
        buttons.add(new ButtonHint());
        
        this.add(new ButtonPanelBody());
        for(var bt: buttons){
            this.add(bt,0);
        }

        this.setVisible(true);
    }

    public ArrayList<AreaButton> getButtons() {
        return buttons;
    }
}
