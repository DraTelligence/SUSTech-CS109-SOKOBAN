package autosolver;

import map.MapUtilis;
import exceptions.AnswerNotFoundException;
import java.util.ArrayList;
import model.MapComponents;
import map.Map;

@SuppressWarnings("FieldMayBeFinal")
public class AutoSolver {
    private ArrayList<MapStateNode> bfsList;
    private Map currMap;
    private int cnt;

    public AutoSolver(Map map) {
        this.bfsList = new ArrayList<>(64);

        bfsList.add(new MapStateNode(map, 0, -1));
    }

    public ArrayList<MapComponents[][]> solve() throws AnswerNotFoundException {
        MapStateNode currNode;
        int currDepth;

        while (bfsList.get(cnt)!=null) {
            currNode = bfsList.get(cnt);
            currMap = currNode.getMap();
            currDepth = currNode.getDepth();

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
            if (MapUtilis.checkMove(currMap, posx, posy, 0, 1)) {
                bfsList.add(new MapStateNode(MapUtilis.doMove(currMap, posx, posy, 0, 1), currDepth, cnt, posx,
                        posy + 1));
            }
            // down
            if (MapUtilis.checkMove(currMap, posx, posy, 0, -1)) {
                bfsList.add(new MapStateNode(MapUtilis.doMove(currMap, posx, posy, 0, -1), currDepth, cnt, posx,
                        posy - 1));
            }
            // left
            if (MapUtilis.checkMove(currMap, posx, posy, 1, 0)) {
                bfsList.add(new MapStateNode(MapUtilis.doMove(currMap, posx, posy, 1, 1), currDepth, cnt, posx + 1,
                        posy));
            }
            // right
            if (MapUtilis.checkMove(currMap, posx, posy, -1, 0)) {
                bfsList.add(
                        new MapStateNode(MapUtilis.doMove(currMap, posx, posy, -1, 0), currDepth, cnt, posx - 1,
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
