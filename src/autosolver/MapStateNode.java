package autosolver;

import map.Map;
import model.MapComponents;

/**
 * the class represents a node of the bfs tree
 */
public class MapStateNode {
    final int depth;
    final Map map;
    final int father;

    public MapStateNode(Map map, int depth, int owner) {
        this.map = map;
        this.depth = depth;
        this.father = owner;
    }

    public Map getMap() {
        return this.map;
    }

    public int getDepth() {
        return depth;
    }

    public int getFather() {
        return father;
}
