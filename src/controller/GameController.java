package controller;

import model.MapComponents;

/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 */

public class GameController {
    public static boolean checkMove(MapComponents[][] currMap, int posx, int posy, int shiftX, int shiftY){
        int x=posx+shiftX, y=posy+shiftY;
        boolean flag=false;

        if(currMap[x][y]==MapComponents.SPACE||currMap[x][y]==MapComponents.TARGET){
            flag=true;
        }else if(currMap[x][y]==MapComponents.BOX||currMap[x][y]==MapComponents.BOX_ON_TARGET){
            if(currMap[x+shiftX][y+shiftY]==MapComponents.SPACE||currMap[x+shiftX][y+shiftY]==MapComponents.TARGET){
                flag=true;
            }
        }

        return flag;
    }

    public static MapComponents[][] doMove(MapComponents[][] currMap, int posx, int posy, int shiftX, int shiftY){
        MapComponents[][] ans= currMap;
        int x=posx+shiftX,y=posy+shiftY;

        if(currMap[x][y]==MapComponents.BOX){
            ans[x][y]=MapComponents.SPACE;
            if(currMap[x+shiftX][y+shiftY]==MapComponents.SPACE){
                ans[x+shiftX][y+shiftY]=MapComponents.BOX;
            }else{
                ans[x+shiftX][y+shiftY]=MapComponents.BOX_ON_TARGET;
            }
        }else if(currMap[x][y]==MapComponents.BOX_ON_TARGET){
            ans[x][y]=MapComponents.TARGET;
            if(currMap[x+shiftX][y+shiftY]==MapComponents.SPACE){
                ans[x+shiftX][y+shiftY]=MapComponents.BOX;
            }else{
                ans[x+shiftX][y+shiftY]=MapComponents.BOX_ON_TARGET;
            }
        }

        return ans;
    }
}
