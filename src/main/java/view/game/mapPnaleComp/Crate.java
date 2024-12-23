package view.game.mapPnaleComp;

import java.awt.Image;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import model.game.Direction;

public class Crate extends JLabel {
    final private static int SIZE = 45;
    final private static int DELAY = 25;
    final private long crateNum;
    @SuppressWarnings("FieldMayBeFinal")
    private String state;
    private int currCol, currRow;
    private int preCol, preRow;
    private int totShift;
    private final Stack<Direction> motions;

    public Crate(int initCol, int initRow) {
        this.crateNum = (System.currentTimeMillis() % 4) + 1;
        this.setBounds(initCol * SIZE, initRow * SIZE, SIZE, SIZE);
        this.state = "";
        this.setCorrespondingIcon();
        currCol = initCol;
        currRow = initRow;
        motions = new Stack<>();

        this.setVisible(true);
    }

    private String getUrl() {
        StringBuilder sb = new StringBuilder();

        sb.append("icons\\Crates\\crates").append(crateNum);
        sb.append("\\crate").append(state).append(".png");

        return sb.toString();
    }

    private void setCorrespondingIcon() {
        ImageIcon icon = new ImageIcon(getUrl());
        icon.setImage(icon.getImage().getScaledInstance(SIZE, SIZE, Image.SCALE_DEFAULT));
        this.setIcon(icon);
    }

    // animation should last about 250 milsec
    @SuppressWarnings("unused")
    public void move(Direction dir) {
        if (dir == null) {
            motions.push(null);
            return;
        }

        motions.push(dir);

        totShift = 0;

        preCol=currCol;
        preRow=currRow;

        currRow += dir.getRow();
        currCol += dir.getCol();
        this.setLocation(preCol * SIZE, preRow * SIZE);

        Timer trigger = new Timer(DELAY, (var noUse) -> {
            totShift += 6;

            if (totShift <= 45) {
                this.setLocation(preCol * SIZE + totShift * dir.getCol(), preRow * SIZE + totShift * dir.getRow());
            } else if (totShift <= 100) {
                this.setLocation(currCol * SIZE, currRow * SIZE);
                this.totShift=101;
            }

            repaint();
        });
        Timer timer = new Timer(300, (var Nouse) -> {
            trigger.stop();
        });
        timer.setRepeats(false);

        trigger.start();
        timer.start();
    }

    @SuppressWarnings("unused")
    private void rewind(Direction dir) {
        totShift = 0;

        preCol=currCol;
        preRow=currRow;

        currRow -= dir.getRow();
        currCol -= dir.getCol();
        this.setLocation(preCol * SIZE, preRow * SIZE);

        Timer trigger = new Timer(DELAY, (var noUse) -> {
            totShift += 6;

            if (totShift <= 45) {
                this.setLocation(preCol * SIZE - totShift * dir.getCol(), preRow * SIZE - totShift * dir.getRow());
            } else if (totShift <= 100) {
                this.setLocation(currCol * SIZE, currRow * SIZE);
                this.totShift=101;
            }

            repaint();
        });
        Timer timer = new Timer(300, (var Nouse) -> {
            trigger.stop();
        });
        timer.setRepeats(false);

        trigger.start();
        timer.start();
    }

    public void rewind() {

        if (motions.peek() != null) {
            switch (motions.pop()) {
                case DOWN -> rewind(Direction.DOWN);
                case LEFT -> rewind(Direction.LEFT);
                case RIGHT -> rewind(Direction.RIGHT);
                case UP -> rewind(Direction.UP);
            }
        } else {
            motions.pop();
        }
    }

    public int getCurrCol() {
        return currCol;
    }

    public int getCurrRow() {
        return currRow;
    }
}
