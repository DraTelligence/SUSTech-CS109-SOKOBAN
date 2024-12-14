// package view.game;
//
// import javax.swing.JLabel;
// import javax.swing.JLayeredPane;
// import javax.swing.JPanel;
//
// import map.MapUtilis;
//
// import java.awt.GridLayout;
// import model.Direction;
//
// public class MapPanel extends ListenerPanel {
//     private MapComponent[][] map;
//     private MapUtilis controller;
//     private JLabel stepLabel;
//     private int steps;
//     private final int GRID_SIZE = 50;
//
//     private Player hero;
//
//     public MapPanel() {
//         JLayeredPane container;
//
//         JPanel base= new JPanel(new GridLayout());
//         JPanel active= new JPanel(new GridLayout());
//     }
//
//     @Override
//     public void doMoveRight() {
//         System.out.println("Click VK_RIGHT");
//         if (controller.doMove(hero.getRow(), hero.getCol(), Direction.RIGHT)) {
//             this.afterMove();
//         }
//     }
//
//     @Override
//     public void doMoveLeft() {
//         System.out.println("Click VK_LEFT");
//         if (controller.doMove(hero.getRow(), hero.getCol(), Direction.LEFT)) {
//             this.afterMove();
//         }
//     }
//
//     @Override
//     public void doMoveUp() {
//         System.out.println("Click VK_Up");
//         if (controller.doMove(hero.getRow(), hero.getCol(), Direction.UP)) {
//             this.afterMove();
//         }
//     }
//
//     @Override
//     public void doMoveDown() {
//         System.out.println("Click VK_DOWN");
//         if (controller.doMove(hero.getRow(), hero.getCol(), Direction.DOWN)) {
//             this.afterMove();
//         }
//     }
//
//     public void afterMove() {
//         this.steps++;
//         this.stepLabel.setText(String.format("Step: %d", this.steps));
//     }
//
//     public void setStepLabel(JLabel stepLabel) {
//         this.stepLabel = stepLabel;
//     }
//
//     public void setController(MapUtilis controller) {
//         this.controller = controller;
//     }
//
//     public GridComponent getGridComponent(int row, int col) {
//         return grids[row][col];
//     }
// }
