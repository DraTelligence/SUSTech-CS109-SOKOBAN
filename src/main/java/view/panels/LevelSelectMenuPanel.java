package view.panels;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class LevelSelectMenuPanel extends JPanel {

    public LevelSelectMenuPanel() {
    }
    
    
    
//         public LevelSelevctMenuPanel(int width, int height) {
//             ImageIcon loginBackground = new ImageIcon("src/pictures/levelBackground.png");
//             JLabel lGL = new JLabel(loginBackground);
//             this.add(lGL);
//             lGL.setBounds(0,0,loginBackground.getIconWidth(),loginBackground.getIconHeight());
//             Container cp = this.getContentPane();
//             cp.setLayout(new BorderLayout());
//             JPanel panel =(JPanel) cp;
//             panel.setOpaque(false);
//             this.getLayeredPane().add(lGL, Integer.MIN_VALUE);
//             setSize(loginBackground.getIconWidth(),loginBackground.getIconHeight());
//             setLocationRelativeTo(null);
    
//             this.setTitle("Level");
//             this.setLayout(null);
//     //        this.setSize(width, height);
    
//             JButton level1Btn = FrameUtil.createButton(this, "Level1", new Point(80, 520), 60, 60);
//             JButton level2Btn = FrameUtil.createButton(this, "Level2", new Point(190, 460), 60, 60);
//             JButton level3Btn = FrameUtil.createButton(this, "Level1", new Point(280, 410), 60, 60);
//             JButton level4Btn = FrameUtil.createButton(this, "Level1", new Point(370, 380), 60, 60);
//             JButton level5Btn = FrameUtil.createButton(this, "Level1", new Point(440, 280), 60, 60);
//             JButton level11Btn = FrameUtil.createButton(this, "Level1", new Point(155, 310), 60, 60);
//             JButton level22Btn = FrameUtil.createButton(this, "Level1", new Point(245, 290), 60, 60);
//             JButton level33Btn = FrameUtil.createButton(this, "Level1", new Point(350, 240), 60, 60);
//             JButton level44Btn = FrameUtil.createButton(this, "Level1", new Point(400, 170), 60, 60);
//             JButton level55Btn = FrameUtil.createButton(this, "Level1", new Point(450, 90), 60, 60);
//             level1Btn.setContentAreaFilled(false);
//             level2Btn.setContentAreaFilled(false);
//             level3Btn.setContentAreaFilled(false);
//             level4Btn.setContentAreaFilled(false);
//             level5Btn.setContentAreaFilled(false);
//             level11Btn.setContentAreaFilled(false);
//             level22Btn.setContentAreaFilled(false);
//             level33Btn.setContentAreaFilled(false);
//             level44Btn.setContentAreaFilled(false);
//             level55Btn.setContentAreaFilled(false);
    
//             level1Btn.addActionListener(l->{
//                 MapMatrix mapMatrix = new MapMatrix(new int[][]{
//                         {1, 1, 1, 1, 1, 1},
//                         {1, 0, 0, 0, 0, 1},
//                         {1, 0, 20, 12, 0, 1},
//                         {1, 0, 10, 2, 0, 1},
//                         {1, 1, 1, 1, 1, 1},
//                 });
//                 GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
//                 this.setVisible(false);
//                 gameFrame.setVisible(true);
//             });
    
//             level2Btn.addActionListener(l->{
//                 MapMatrix mapMatrix = new MapMatrix(new int[][]{
//                         {1, 1, 1, 1, 1, 0},
//                         {1, 20, 0, 0, 1, 1},
//                         {1, 0, 0, 2, 0, 1},
//                         {1, 0, 10, 10, 2, 1},
//                         {1, 1, 0, 1, 1, 1},
//                         {0, 1, 1, 1, 0, 0},
//                 });
//                 GameFrame gameFrame = new GameFrame(600, 450, mapMatrix);
//                 this.setVisible(false);
//                 gameFrame.setVisible(true);
//             });
    
//             //todo: complete all level.
    
//             this.setLocationRelativeTo(null);
//             this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         }
}