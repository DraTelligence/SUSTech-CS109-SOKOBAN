package map;

import model.MapComponents;

@SuppressWarnings("FieldMayBeFinal")
public class Map {
    private MapComponents[][] map;
    private int width,height;
    private int posX,posY;

    public Map(int width, int height, MapComponents[][] map,int posx,int posy){
        this.width=width;
        this.height=height;
        this.map=map;
        this.posX=posx;
        this.posY=posy;
    }

    public MapComponents[][] getMap() {
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
