package de.sommer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

import javax.swing.ImageIcon;

public abstract class Piece {
    
    private ID name;
    private Coordinate position;
    private Coordinate oldPosition;
    private Color color;
    private HashSet<Coordinate> possibleMoves;
    public int dimension = BOARD.LAST_RANK.getRankVal();
    public int single = BOARD.FIRST_RANK.getRankVal();
    private boolean hasMoved = false;

    public Piece(ID name, Coordinate position, Color color) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(position, "Position cannot be null");
        Objects.requireNonNull(color, "Color cannot be null");

        this.name = name;
        this.oldPosition = position;
        this.color = color;
        this.possibleMoves = new HashSet<Coordinate>();
    }

    // Getters and Setters

    public ID getName() {
        return name;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Coordinate getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(Coordinate oldPosition) {
        this.oldPosition = oldPosition;
    }

    public Color getColor() {
        return color;
    }

    public HashSet<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(HashSet<Coordinate> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    // Methods


    //Overwriting toString, hashCode and equals

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Piece)) {
            return false;
        }

        Piece p = (Piece) obj;
        return p.getName() == this.getName() && p.getOldPosition().equals(this.getOldPosition()) && p.getColor() == this.getColor();
    }

    /**
     * Return all positions that the piece can move to without considering other pieces and checks
     */
    public abstract ArrayList<Coordinate> getValidMoves();

    /**
     * Returns ImageIcon for the piece
     */
    public abstract ImageIcon getImage();

    /**
     * Returns a copy of the piece
     */
    public abstract Piece copy();



}
