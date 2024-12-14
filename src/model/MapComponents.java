package model;


/**
 * a enum class represents different kinds of components of map.
 *
 * @author DraTelligence
 */
public enum MapComponents {
    SPACE, WALL, TARGET, BOX, PLAYER, BOX_ON_TARGET;

    static public MapComponents valueOf(final int code) {
        return switch (code) {
            case 0 -> MapComponents.SPACE;
            case 1 -> MapComponents.WALL;
            case 2 -> MapComponents.TARGET;
            case 3 -> MapComponents.BOX;
            case 4 -> MapComponents.PLAYER;
            case 5 -> MapComponents.BOX_ON_TARGET;
            default -> null;
        };
    }
}
