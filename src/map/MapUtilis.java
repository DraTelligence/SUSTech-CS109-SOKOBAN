//package map;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.Scanner;
//import model.Direction;
//import model.MapComponents;
//
///**
// * It is a tool class to deal with map.
// */
//
//public class MapUtilis {
//    /**
//     * This method check if the move can be done.
//     *
//     * @param map
//     * @param direction
//     * @return
//     */
//    public static boolean checkMove(Map map, Direction direction) {
//        boolean flag = false;
//
//        if (MapComponents.isStandable(map.get(direction))) {
//            flag = true;
//        } else if (MapComponents.isPushable(map.get(direction))) {
//            if (MapComponents.isStandable(map.get(direction.getX() * 2, direction.getY() * 2))) {
//                flag = true;
//            }
//        }
//
//        return flag;
//    }
//
//    /**
//     * This warning should only be called when the move could be done!</BR>
//     * Complete the move and return the Map after the move.
//     * @param currMap
//     * @param direction
//     * @return the {@code map} after the move done.
//     */
//    public static Map doMove(Map currMap, Direction direction) {
//        int newX=currMap.getPosX()+direction.getX();
//        int newY=currMap.getPosY()+direction.getY();
//
//        if (MapComponents.isPushable(currMap.get(direction))){
//            System.out.println("Let's push it!");
//
//            // set the mapComponents
//            MapComponents[][] newMap =currMap.getMapComponentsMatrix();
//
//            // push the crate
//            if(currMap.get(direction.getX()*2, direction.getY()*2)==MapComponents.SPACE){
//                // space
//                newMap[newY+direction.getY()][newX+direction.getX()]=MapComponents.BOX;
//            }else{
//                // target
//                newMap[newY+direction.getY()][newX+direction.getX()]=MapComponents.BOX_ON_TARGET;
//            }
//
//            //reset the ground
//            if(currMap.get(direction)==MapComponents.BOX){
//                // space
//                newMap[newY][newX]=MapComponents.SPACE;
//            }else{
//                // target
//                newMap[newY][newX]=MapComponents.TARGET;
//            }
//
//            return new Map(newMap,newX,newY);
//        }else{
//            return new Map(currMap.getMapComponentsMatrix(),newX,newY);
//        }
//    }
//
//    /**
//     * This function is to check if the map has arrived the victory state
//     *
//     * @param map the map to be checked
//     * @return {@code true} if the player has won
//     */
//    static public boolean checkVictory(Map map) {
//        boolean flag = true;
//
//        for (int y = 1; y < map.getMapComponentsMatrix().length - 1; y++) {
//            for (int x = 1; x < map.getMapComponentsMatrix()[0].length - 1; x++) {
//                if (map.getMapComponentsMatrix()[y][x] == MapComponents.BOX) {
//                    flag = false;
//                }
//            }
//        }
//
//        return flag;
//    }
//
//    /**
//     * This function is to check if the map has arrived the victory state
//     *
//     * @param map the array described the map
//     * @return {@code true} if the player has won
//     */
//    static public boolean checkVictory(MapComponents[][] map) {
//        boolean flag = true;
//
//        for (int i = 1; i < map.length - 1; i++) {
//            for (int j = 1; j < map[0].length - 1; j++) {
//                if (map[i][j] == MapComponents.BOX) {
//                    flag = false;
//                }
//            }
//        }
//
//        return flag;
//    }
//
//    /**
//     * This method return a {@code Map} read from data file
//     * @param levelNum
//     * @return
//     */
//    @SuppressWarnings("ConvertToTryWithResources")
//    static public Map getMap(int levelNum) {
//        String dir = "data\\maps\\";
//        String fileName = "level" + levelNum;
//        int width, height, posx, posy;
//        MapComponents[][] map;
//        Map result;
//
//        try {
//            InputStream inp = new FileInputStream(dir + fileName);
//            Scanner sc = new Scanner(inp);
//
//            // read the size of the map
//            height = sc.nextInt();
//            width = sc.nextInt();
//
//            // read the map
//            map = new MapComponents[height][width];
//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//                    map[i][j] = MapComponents.valueOf(sc.nextInt());
//                }
//            }
//
//            // read the initial pos of the player
//            posy = sc.nextInt();
//            posx = sc.nextInt();
//
//            result = new Map(map, posx, posy);
//
//            sc.close();
//
//            return result;
//        } catch (FileNotFoundException e) {
//            System.out.print(e.getMessage());
//            System.exit(-1);
//        }
//
//        return null;
//    }
//}
