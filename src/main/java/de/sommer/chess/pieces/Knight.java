package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class Knight extends Piece{

    public Knight(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowChange = Math.abs(newPosition.getRow() - this.getPosition().getRow());
        int columnChange = Math.abs(newPosition.getColumn() - this.getPosition().getColumn());
        Piece targetPiece = board[newPosition.getRow()][newPosition.getColumn()];

        if(rowChange == 2 && columnChange == 1 || rowChange == 1 && columnChange == 2){
            if(targetPiece == null) return true;
            if(targetPiece.getColor() != this.getColor()) return true;
        }
        
        return false;
        
    }

    @Override
    public int getTypeInt() {
        return KNIGHT;
    }
    
}
