package autosolver;

import model.MapComponents;

/**
 * the class represents a node of the bfs tree
 */
public class MapStateNode{
    final int depth;
    final MapComponents[][] map;
    final int father;
    final int posx,posy;

    public MapStateNode(MapComponents[][] map, int depth, int owner, int posx, int posy){
        this.map=map;
        this.depth=depth;
        this.father=owner;
        this.posx=posx;
        this.posy=posy;
    }

    public MapComponents[][] getMap() {
        return map;
    }

    public int getDepth() {
        return depth;
    }

    public int getFather() {
        return father;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
}
