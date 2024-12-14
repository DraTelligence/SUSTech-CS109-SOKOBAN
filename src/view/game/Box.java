package view.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Box extends JComponent {
    private final int value = 10;

    public Box(int width, int height) {
        this.setSize(width, height);
        this.setLocation(5, 5);
    }

    public void paintComponent(Graphics g) {
//        g.setColor(Color.ORANGE);
//        g.fillRect(0, 0, getWidth(), getHeight());
        ImageIcon Box = new ImageIcon("src/Pictures/Box.png");
        g.drawImage(Box.getImage(),0,0,40,40,this);
//        Border border = BorderFactory.createLineBorder(Color.black, 1);
//        this.setBorder(border);
    }

    public int getValue() {
        return value;
    }
}
