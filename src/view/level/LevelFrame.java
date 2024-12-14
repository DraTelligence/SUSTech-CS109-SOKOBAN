package view.level;

import model.MapMatrix;
import view.FrameUtil;
import view.game.GameFrame;

import javax.swing.*;
import java.awt.*;

public class LevelFrame extends JFrame {

    public LevelFrame(int width, int height) {
        ImageIcon loginBackground = new ImageIcon("src/pictures/levelBackground.png");
        JLabel lGL = new JLabel(loginBackground);
        this.add(lGL);
        lGL.setBounds(0,0,loginBackground.getIconWidth(),loginBackground.getIconHeight());
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        JPanel panel =(JPanel) cp;
        panel.setOpaque(false);
        this.getLayeredPane().add(lGL, Integer.MIN_VALUE);
        setSize(loginBackground.getIconWidth(),loginBackground.getIconHeight());
        setLocationRelativeTo(null);
        this.setTitle("Level");
        this.setLayout(null);
//        this.setSize(width, height);
        Font levelFont = new Font("Serif", Font.ITALIC,18);
        JButton level1Btn = FrameUtil.createButton(this, "Level1", new Point(100, 450), 100, 60);
//        level1Btn.setBackground(null);
        level1Btn.setContentAreaFilled(false);
        level1Btn.setForeground(Color.red);
        level1Btn.setFont(levelFont);
        JButton level2Btn = FrameUtil.createButton(this, "Level2", new Point(240, 410), 100, 60);
        level2Btn.setBackground(new Color(20,80,100));
        level2Btn.setForeground(Color.red);
        level2Btn.setFont(levelFont);
        level2Btn.setContentAreaFilled(false);

        level1Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 1},
                    {1, 0, 0, 0, 0, 1},
                    {1, 0, 20, 12, 0, 1},
                    {1, 0, 10, 2, 0, 1},
                    {1, 1, 1, 1, 1, 1},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        level2Btn.addActionListener(l->{
            MapMatrix mapMatrix = new MapMatrix(new int[][]{
                    {1, 1, 1, 1, 1, 0},
                    {1, 20, 0, 0, 1, 1},
                    {1, 0, 0, 2, 0, 1},
                    {1, 0, 10, 10, 2, 1},
                    {1, 1, 0, 1, 1, 1},
                    {0, 1, 1, 1, 0, 0},
            });
            GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
            this.setVisible(false);
            gameFrame.setVisible(true);
        });

        //todo: complete all level.

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
