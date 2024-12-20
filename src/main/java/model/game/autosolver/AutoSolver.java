package model.game.autosolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Callable;

import javax.swing.SwingWorker;

import exceptions.AnswerNotFoundException;
import model.game.Direction;
import model.game.Map;
import model.game.MapComponents;

@SuppressWarnings("FieldMayBeFinal")
public class AutoSolver extends SwingWorker<ArrayList<Direction>, Void> {
    final static private Direction[] DIRECTIONS = { Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT };
    private ArrayList<MapStateNode> bfsList;
    private Map currMap;

    public AutoSolver(Map map) {
        this.bfsList = new ArrayList<>(64);
        bfsList.add(new MapStateNode(map, 0, -1));
    }

    public void solve() throws AnswerNotFoundException {
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
            if (Map.checkVictory(currMap)) {
                int totSteps = bfsList.get(cnt).getDepth() + 1;

                ArrayList<MapComponents[][]> ansList = new ArrayList<>(totSteps);

                for (int next = cnt; next != 0; next = bfsList.get(next).getFather()) {
                    ansList.set(bfsList.get(next).getDepth(), bfsList.get(next).getMap().getMapComponentsMatrix());
                }

                return;
            }

            // add new nodes to the queue
            for (Direction dir : DIRECTIONS) {
                if (Map.checkMove(currMap, dir)) {
                    newMap = Map.doMove(currMap, dir);
                    if (visited.add(newMap.hashCode())) {
                        bfsList.add(new MapStateNode(newMap, currDepth, cnt));
                    }
                }
            }

            cnt++;
        }

        throw new AnswerNotFoundException();
    }
    
    @Override
    protected ArrayList<Direction> doInBackground() throws Exception {
        try{
            solve();
        } catch (AnswerNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
