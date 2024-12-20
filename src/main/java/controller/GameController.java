package controller;

import javax.swing.JPanel;

import model.Direction;
import view.panels.GameMainPanel;
import model.game.*;

/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 * You can design several methods about the game logic in this class.
 */
public class GameController {
    private static GameController instance;

    private final GameMainPanel view;
    private final Map model;

    private GameController() {
        this.view = new GameMainPanel();
        this.model = new Map();
    }

    public static synchronized GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void handleCommand(String command) {}

    public JPanel getView() {
        return view;
    }

    public void restartGame() {
        System.out.println("Do restart game here");
    }

    public boolean doMove(int row, int col, Direction direction) {
        GridComponent currentGrid = view.getGridComponent(row, col);
        //target row can column.
        int tRow = row + direction.getRow();
        int tCol = col + direction.getCol();
        GridComponent targetGrid = view.getGridComponent(tRow, tCol);
        int[][] map = model.getMatrix();
        if (map[tRow][tCol] == 0 || map[tRow][tCol] == 2) {
            //update hero in MapMatrix
            model.getMatrix()[row][col] -= 20;
            model.getMatrix()[tRow][tCol] += 20;
            //Update hero in GamePanel
            Hero h = currentGrid.removeHeroFromGrid();
            targetGrid.setHeroInGrid(h);
            //Update the row and column attribute in hero
            h.setRow(tRow);
            h.setCol(tCol);
            return true;
        }
        return false;
    }

    //todo: add other methods such as loadGame, saveGame...

}

