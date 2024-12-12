package map;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import model.MapComponents;

/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 */

public class MapUtilis {
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

    public Map mapReader(int levelNum){
        String dir="data\\maps\\";
        String fileName= "level"+levelNum;
        int width,height,posx,posy;
        MapComponents[][] map;
        Map result=null;

        try(InputStream inp=new FileInputStream(dir+fileName)){
            // read the size of the map
            height=read(inp);
            width=read(inp);

            //read the map
            map=new MapComponents[height][width];
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    map[i][j]=MapComponents.valueOf(read(inp));
                }
            }

            // read the initial pos of the player
            posy=read(inp);
            posx=read(inp);

            result=new Map(width,height,map,posx,posy);
        }catch(Exception e){
            System.out.print(e.getMessage());
            System.exit(-1);
        }

        return result;
    }

    private int read(InputStream inp){
        int n=0,tmp=0;
        final int base= (int)'0';
        try {
            tmp=inp.read()-base;
            while(tmp>=0&&tmp<=9){
                n=tmp+(n<<1)+(n<<3);
                tmp=inp.read()-base;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        return n;
    }
}
