package map;

import java.util.Arrays;
import model.Direction;
import model.MapComponents;

// TODO:支持callback方法，主动告知计算完毕

@SuppressWarnings("FieldMayBeFinal")
public class Map {
    private MapComponents[][] map;
    private int posX, posY;
    static final int PRIME_FOR_HASHCODE = 31;

    public Map(MapComponents[][] map, int posx, int posy) {
        this.map = map;
        this.posX = posx;
        this.posY = posy;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = PRIME_FOR_HASHCODE * result + Arrays.deepHashCode(map);
        result = PRIME_FOR_HASHCODE * result + posX;
        result = PRIME_FOR_HASHCODE * result + posY;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Map other = (Map) obj;

        return Arrays.deepEquals(map, other.map) || posX != other.posX || posY != other.posY;
    }

    public MapComponents get(int offX, int offY) {
        return this.map[this.posY + offY][this.posX + offX];
    }

    public MapComponents get(Direction direction) {
        return this.map[this.posY + direction.getY()][this.posX + direction.getX()];
    }

    public MapComponents[][] getMapComponentsMatrix() {
        return map;
    }

    public int getWidth() {
        return this.map[0].length;
    }

    public int getHeight() {
        return this.map.length;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if(j==this.posX&&i==this.posY){
                    sb.append("$").append(" ");
                }else{
                    sb.append(this.map[i][j].ordinal()).append(" ");
                }
            }
            sb.append("\n");
        }

        sb.append("player currently at (").append(this.posX).append(",").append(this.posY).append(")\n");

        return sb.toString();
    }
}
