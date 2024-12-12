package autosolver;

import controller.GameController;
import exceptions.AnswerNotFoundException;
import java.util.ArrayList;
import model.MapComponents;

@SuppressWarnings("FieldMayBeFinal")
public class AutoSolver {
    private ArrayList<MapStateNode> bfsList;
    private MapComponents[][] currMap;
    private int width;
    private int height, cnt, posx, posy;

    public AutoSolver(MapComponents[][] map, int playerPosX, int playerPosY) {
        this.bfsList = new ArrayList<>(64);

        this.height = map.length;
        this.width = map[0].length;
        this.cnt = 0;
        this.posx = playerPosX;
        this.posy = playerPosY;
        bfsList.add(new MapStateNode(map, 0, -1, this.posx, this.posy));
    }

    public ArrayList<MapComponents[][]> solve() throws AnswerNotFoundException {
        MapStateNode currNode;
        int currDepth;

        while (!bfsList.isEmpty()) {
            currNode = bfsList.get(cnt);
            currMap = currNode.getMap();
            currDepth = currNode.getDepth();
            posx = currNode.getPosx();
            posy = currNode.getPosy();

            // check if the currMap is true
            if (check()) {
                int totSteps = (int) bfsList.get(cnt).getDepth();
                ArrayList<MapComponents[][]> ansList = new ArrayList<>(totSteps + 1);

                for (int next = cnt; next != 0; next = bfsList.get(next).getFather()) {
                    ansList.set(bfsList.get(next).getDepth(), bfsList.get(next).getMap());
                }

                return ansList;
            }

            // add new nodes to the queue
            // up
            if (GameController.checkMove(currMap, posx, posy, 0, 1)) {
                bfsList.add(new MapStateNode(GameController.doMove(currMap, posx, posy, 0, 1), currDepth, cnt, posx,
                        posy + 1));
            }
            // down
            if (GameController.checkMove(currMap, posx, posy, 0, -1)) {
                bfsList.add(new MapStateNode(GameController.doMove(currMap, posx, posy, 0, -1), currDepth, cnt, posx,
                        posy - 1));
            }
            // left
            if (GameController.checkMove(currMap, posx, posy, 1, 0)) {
                bfsList.add(new MapStateNode(GameController.doMove(currMap, posx, posy, 1, 1), currDepth, cnt, posx + 1,
                        posy));
            }
            // right
            if (GameController.checkMove(currMap, posx, posy, -1, 0)) {
                bfsList.add(
                        new MapStateNode(GameController.doMove(currMap, posx, posy, -1, 0), currDepth, cnt, posx - 1,
                                posy));
            }

            cnt++;
        }

        throw new AnswerNotFoundException();
    }

    private boolean check() {
        boolean flag = true;

        // ignore the walls surrounding
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (currMap[i][j] == MapComponents.BOX) {
                    flag = false;
                }
            }
        }

        return flag;
    }
}
