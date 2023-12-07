package edu.project2.maze;

public enum CellType {
    WALL("⬜"),
    PASSAGE("⬛"),
    PATH("🟥");

    private final String draw;

    CellType(String draw) {
        this.draw = draw;
    }

    public String draw() {
        return draw;
    }

    public static CellType fromString(String input) {
        if (input.equalsIgnoreCase("⬜")) {
            return WALL;
        } else if (input.equalsIgnoreCase("⬛")) {
            return PASSAGE;
        } else if (input.equalsIgnoreCase("🟥")) {
            return PATH;
        }
        throw new IllegalArgumentException("Invalid CellType: " + input);
    }
}
