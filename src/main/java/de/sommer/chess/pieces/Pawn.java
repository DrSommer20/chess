package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class Pawn extends Piece{

    public Pawn(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int forwardDirection = this.getColor() == PieceColor.WHITE ? 1 : -1;
        int rowChange = (newPosition.getRow() - this.getPosition().getRow()) * forwardDirection;
        int columnChange = (newPosition.getColumn() - this.getPosition().getColumn()) * forwardDirection;

        //Simple forward move
        if(columnChange == 0 && rowChange == 1){
            return board[newPosition.getRow()][newPosition.getColumn()] == null;
        }

        //First move
        boolean isFirstMove = (this.color == PieceColor.WHITE && position.getRow() == 1) || (this.color == PieceColor.BLACK && position.getRow() == 6);
        if(isFirstMove && columnChange == 0 && rowChange == 2){
            return board[newPosition.getRow()][newPosition.getColumn()] == null;
        }

        //Capture move
        if(Math.abs(columnChange) == 1 && rowChange == 1 && board[newPosition.getRow()][newPosition.getColumn()] != null && board[newPosition.getRow()][newPosition.getColumn()].getColor() != this.getColor()){
            return true;            
        }

        //Default
        return false;
    }

    @Override
    public int getTypeInt() {
        return PAWN;
    }
    
}
