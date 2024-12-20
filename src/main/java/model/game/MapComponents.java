package model.game;

/**
 * a enum class represents different kinds of components of map.
 * 
 * @author DraTelligence
 */
public enum MapComponents {
    SPACE, TARGET, BOX, BOX_ON_TARGET, WALL, VOID;

    static public MapComponents valueOf(final int code) {
        return switch (code) {
            case 0 -> MapComponents.SPACE;
            case 1 -> MapComponents.TARGET;
            case 2 -> MapComponents.BOX;
            case 3 -> MapComponents.BOX_ON_TARGET;
            case 4 -> MapComponents.WALL;
            case 5 -> MapComponents.VOID;
            default -> null;
        };
    }

    public static boolean isStandable(MapComponents item) {
        return (item == SPACE) || (item == TARGET);
    }

    public static boolean isPushable(MapComponents item) {
        return (item == BOX) || (item == BOX_ON_TARGET);
    }
}