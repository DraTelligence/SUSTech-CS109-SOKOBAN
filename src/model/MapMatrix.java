package model;

/**
 * This class is to record the map of one game. For example:
 * matrix =
 * {1, 1, 1, 1, 1, 1},
 * {1, 0, 0, 0, 0, 1},
 * {1, 0, 4, 5, 0, 1},
 * {1, 0, 3, 2, 0, 1},
 * {1, 1, 1, 1, 1, 1}
 * The Unit digit number cannot be changed during one game.
 * 0 represents the free space
 * 1 represents the wall
 * 2 represents the target location
 * 3 represents the box
 * 4 represents the charactor
 * 5 represents the box on the taget
 * The Then digit number can be changed during one game.
 * Ten digit 1 represents the box
 * Ten digit 2 represents the hero/player
 * So that 12 represents a box on the target location and 22 represents the player on the target location.
 */
public class MapMatrix {
    int width,height;

    MapComponents[][] matrix;

    public MapMatrix(int[][] inputMatrix) {
        this.width=inputMatrix.length;
        this.height=inputMatrix[0].length;

        this.matrix=new MapComponents[this.width][this.height];

        for(int i=0;i<this.width;i++){
            for(int j=0;j<this.height;j++){
                this.matrix[i][j]=MapComponents.valueOf(inputMatrix[i][j]);
            }
        }

    }

    public int getWidth() {
        return this.matrix[0].length;
    }

    public int getHeight() {
        return this.matrix.length;
    }

    public int getId(int row, int col) {
        return matrix[row][col];
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
