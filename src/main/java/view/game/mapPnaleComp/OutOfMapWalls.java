package view.game.mapPnaleComp;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OutOfMapWalls extends JLabel {
    static private final int SIZE = 45;
    final int wallType;

    public OutOfMapWalls(int wallType, int col, int row) {
        this.wallType = wallType;
        this.setBounds(45 * col, 45 * row, 45, 45);
        this.setBackground(Color.GRAY);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(getUrl()));
        icon.setImage(icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
        this.setIcon(icon);
    }

    private String getUrl() {
        return String.format("icons/Wall/wall%d.png", this.wallType);
    }
}
