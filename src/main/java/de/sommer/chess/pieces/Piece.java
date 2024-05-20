package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public abstract class Piece {
    protected Position position;
    protected PieceColor color;
    public static final int QUEEN = 1, KING = 0, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;

    public Piece(PieceColor color, Position position) {
        this.color = color;
        this.position = position;
    }

    public PieceColor getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean isValidMove(Position newPosition, Piece[][] board);

    public abstract int getTypeInt();

}
