package autosolver;

import exceptions.AnswerNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Callable;
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

    public ArrayList<MapComponents[][]> solve(Callable<ArrayList<MapComponents[][]>> callback) throws AnswerNotFoundException {
        final Direction[] DIRECTIONS= {Direction.UP,Direction.DOWN,Direction.LEFT,Direction.RIGHT};
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
            for(Direction dir: DIRECTIONS){
                if (MapUtilis.checkMove(currMap, dir)) {
                    newMap = MapUtilis.doMove(currMap, dir);
                    if (visited.add(newMap.hashCode())) {
                        bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                    }
                }
            }

            cnt++;
        }

        throw new AnswerNotFoundException();
    }
}
