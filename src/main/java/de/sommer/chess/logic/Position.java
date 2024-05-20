package de.sommer.chess.logic;

public class Position {
    private int row;
    private int column;

    /**
     * Constructor for Position
     * @param row Row of the position
     * @param column Column of the position
     */
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    // Getters

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }
}
