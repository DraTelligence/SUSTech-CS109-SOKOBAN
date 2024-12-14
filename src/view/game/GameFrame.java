package view.game;

import javax.swing.*;
import java.awt.*;

import controller.GameController;
import model.MapMatrix;
import view.FrameUtil;

public class GameFrame extends JFrame {

    private GameController controller;
    private JButton restartBtn;
    private JButton loadBtn;

    private JLabel stepLabel;
    private GamePanel gamePanel;

    public GameFrame(int width, int height, MapMatrix mapMatrix) {

        this.setTitle("2024 CS109 Project Demo");
        this.setLayout(null);
        this.setSize(width, height);

        ImageIcon loginBackground = new ImageIcon("src/pictures/gameBackground.png");
        JLabel lGL = new JLabel(loginBackground);
        lGL.setLocation(0,0);
        setSize(loginBackground.getIconWidth(),loginBackground.getIconHeight());
        lGL.setSize(this.getWidth(),this.getHeight());
//        this.add(lGL);
//        lGL.setBounds(0,0,loginBackground.getIconWidth(),loginBackground.getIconHeight());
//        Container cp = this.getContentPane();
//        cp.setLayout(new BorderLayout());
//        JPanel panel =(JPanel) cp;
//        panel.setOpaque(false);
//        this.getLayeredPane().add(lGL, Integer.MIN_VALUE);
//        setSize(loginBackground.getIconWidth(),loginBackground.getIconHeight());
//        setLocationRelativeTo(null);

        gamePanel = new GamePanel(mapMatrix);
        gamePanel.setLocation(100, 250 );
        this.add(gamePanel);
        this.controller = new GameController(gamePanel, mapMatrix);

        this.restartBtn = FrameUtil.createButton(this, "", new Point(210, 150), 190, 50);
        restartBtn.setContentAreaFilled(false);
        this.loadBtn = FrameUtil.createButton(this, "", new Point(210, 100), 150, 50);
        loadBtn.setContentAreaFilled(false);

        this.stepLabel = FrameUtil.createJLabel(this, "0", new Font("serif", Font.ITALIC, 30), new Point(235, 605), 180, 50);
        gamePanel.setStepLabel(stepLabel);
        stepLabel.setVisible(true);
        add(stepLabel);

        this.restartBtn.addActionListener(e -> {
            controller.restartGame();
            gamePanel.requestFocusInWindow();//enable key listener
        });
        this.loadBtn.addActionListener(e -> {
            String string = JOptionPane.showInputDialog(this, "Input path:");
            System.out.println(string);
            gamePanel.requestFocusInWindow();//enable key listener
        });
        //todo: add other button here
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(this.gamePanel::requestFocusInWindow);
        this.add(lGL);
    }

}
