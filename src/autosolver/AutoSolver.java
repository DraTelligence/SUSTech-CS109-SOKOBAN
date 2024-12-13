package autosolver;

import exceptions.AnswerNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import map.Map;
import map.MapUtilis;
import model.Direction;
import model.MapComponents;

@SuppressWarnings("FieldMayBeFinal")
public class AutoSolver {
    private ArrayList<MapStateNode> bfsList;
    private Map currMap;

    public AutoSolver(Map map) {
        this.bfsList = new ArrayList<>(64);

        bfsList.add(new MapStateNode(map, 0, -1));
    }

    public ArrayList<MapComponents[][]> solve() throws AnswerNotFoundException {
        MapStateNode currNode;
        int currDepth;
        int cnt = 0;

        while (bfsList.get(cnt) != null) {
            currNode = bfsList.get(cnt);
            currMap = currNode.getMap();
            currDepth = currNode.getDepth();
            HashSet<Integer> visited = new HashSet<>();
            Map newMap;

            // check if victory has been reached
            if (MapUtilis.checkVictory(currMap)) {
                int totSteps = bfsList.get(cnt).getDepth() + 1;

                ArrayList<MapComponents[][]> ansList = new ArrayList<>(totSteps);

                for (int next = cnt; next != 0; next = bfsList.get(next).getFather()) {
                    ansList.set(bfsList.get(next).getDepth(), bfsList.get(next).getMap().getMapComponentsMatrix());
                }

                return ansList;
            }

            // add new nodes to the queue
            // values() may use too much storage
            // up
            if (MapUtilis.checkMove(currMap, Direction.UP)) {
                newMap = MapUtilis.doMove(currMap, Direction.UP);
                if (visited.add(newMap.hashCode())) {
                    bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                }
            }
            // down
            if (MapUtilis.checkMove(currMap, Direction.DOWN)) {
                newMap = MapUtilis.doMove(currMap, Direction.DOWN);
                if (visited.add(newMap.hashCode())) {
                    bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                }
            }
            // left
            if (MapUtilis.checkMove(currMap, Direction.LEFT)) {
                newMap = MapUtilis.doMove(currMap, Direction.LEFT);
                if (visited.add(newMap.hashCode())) {
                    bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                }
            }
            // right
            if (MapUtilis.checkMove(currMap, Direction.RIGHT)) {
                newMap = MapUtilis.doMove(currMap, Direction.RIGHT);
                if (visited.add(newMap.hashCode())) {
                    bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                }
            }

            cnt++;
        }

        throw new AnswerNotFoundException();
    }
}
