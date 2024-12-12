package model;

/**
 * a enum class represents different kinds of components of map.
 * 
 * @author DraTelligence
 */
public enum MapComponents {
    SPACE, WALL, TARGET, BOX, BOX_ON_TARGET;

    static public MapComponents valueOf(final int code) {
        return switch (code) {
            case 0 -> MapComponents.SPACE;
            case 1 -> MapComponents.TARGET;
            case 2 -> MapComponents.BOX;
            case 3 -> MapComponents.BOX_ON_TARGET;
            case 4 -> MapComponents.WALL;
            default -> null;
        };
    }
}