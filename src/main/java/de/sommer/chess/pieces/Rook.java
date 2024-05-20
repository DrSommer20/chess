package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class Rook extends Piece{

    public Rook(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(this.getPosition().getRow() == newPosition.getRow()){
            int columnStart = Math.min(getPosition().getColumn(), newPosition.getColumn()) + 1;
            int columnEnd = Math.max(getPosition().getColumn(), newPosition.getColumn());
            
            for(int column = columnStart; column < columnEnd; column++){
                if(board[getPosition().getRow()][column] != null){
                    return false;
                }
            }
        }
        else if(this.getPosition().getColumn() == newPosition.getColumn()){
            int rowStart = Math.min(getPosition().getRow(), newPosition.getRow()) + 1;
            int rowEnd = Math.max(getPosition().getRow(), newPosition.getRow());
            
            for(int row = rowStart; row < rowEnd; row++){
                if(board[row][getPosition().getColumn()] != null){
                    return false;
                }
            }
        }
        else{
            return false;
        }

        if(board[newPosition.getRow()][newPosition.getColumn()] != null && board[newPosition.getRow()][newPosition.getColumn()].getColor() == this.getColor()){
            return false;
        }
        else{
            return true;
        }
    }    

    @Override
    public int getTypeInt() {
        return ROOK;
    }

}
