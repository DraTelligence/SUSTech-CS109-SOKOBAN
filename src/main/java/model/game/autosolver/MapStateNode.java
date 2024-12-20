package model.game.autosolver;

import model.game.Map;

/**
* the class represents a node of the bfs tree
*/
public class MapStateNode {
   final int depth;
   final Map map;
   final int father;

   public MapStateNode(Map map, int initDepth, int fatherIndex) {
       this.map = map;
       this.depth = initDepth;
       this.father = fatherIndex;
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
}
