package de.sommer;

import javax.swing.border.Border;

public class Coordinate {
    private char file;
    private int rank;

    /**
     * Constructor for Coordinate
     * @param file Describes the column
     * @param rank Describes the row
     */
    public Coordinate(char file, int rank) {
        this.file = Character.toLowerCase(file);
        this.rank = rank;
    }
    
    /**
     * Constructor for Coordinate
     * @param c The coordinate to copy
     */
    public Coordinate(Coordinate c) {
        this.file = c.file;
        this.rank = c.rank;
    }

    // Getters and Setters

    public char getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    // Methods

    /**
     * Returns the coordinate that is the result of adding the given coordinate to this coordinate
     * @param c The coordinate to add
     * @return boolean Whether the coordinate is in the board
     */
    public static boolean inBoard(Coordinate c) {
        return c.getFile() >= BOARD.FIRST_RANK.getRankVal() && c.getFile() <= BOARD.LAST_RANK.getRankVal() && c.getRank() >= BOARD.FIRST_FILE.getFileVal() && c.getRank() <= BOARD.LAST_FILE.getFileVal();   
    }

    // Overriding toString, hashCode and equals

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Coordinate)) {
            return false;
        }

        Coordinate c = (Coordinate) obj;
        return c.getFile() == this.getFile() && c.getRank() == this.getRank();
    }

    @Override
    public String toString() {
        return file + rank + "";
    }

    @Override
    public int hashCode() {
        return file + rank;
    }

}
