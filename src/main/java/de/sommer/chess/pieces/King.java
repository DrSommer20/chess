package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class King extends Piece{

    public King(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowChange = Math.abs(this.getPosition().getRow() - newPosition.getRow());
        int columnChange = Math.abs(this.getPosition().getColumn() - newPosition.getColumn());
        if((rowChange == 1 && columnChange == 0 )||(rowChange == 0 && columnChange == 1)||(rowChange == 1 && columnChange == 1)){
            if(board[newPosition.getRow()][newPosition.getColumn()] == null || board[newPosition.getRow()][newPosition.getColumn()].getColor() != this.getColor()) return true;
        }
        return false;
    }
    
    @Override
    public int getTypeInt() {
        return KING;
    }
}
