package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class Queen extends Piece {

    public Queen(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //Bishop coding
        int rowChange = Math.abs(newPosition.getRow() - this.getPosition().getRow());
        int columnChange = Math.abs(newPosition.getColumn() - this.getPosition().getColumn());

        if(rowChange == 0 && columnChange  == 0) return false;
        if(rowChange == columnChange){
            int rowDirection = newPosition.getRow() > this.getPosition().getRow() ? 1 : -1;
            int columnDirection = newPosition.getColumn() > this.getPosition().getColumn() ? 1 : -1;
            int row = this.getPosition().getRow();
            int column = this.getPosition().getColumn();

            for(int i = 1; i < rowChange; i++){
                row = row + rowDirection;
                column = column + columnDirection;
                if(board[row][column] != null){
                    return false;
                }
            }
            if(board[newPosition.getRow()][newPosition.getColumn()] == null || board[newPosition.getRow()][newPosition.getColumn()].color != this.getColor()) return true;
        }
        
        //Rook coding

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
            
            for(int column = rowStart; column < rowEnd; column++){
                if(board[getPosition().getRow()][column] != null){
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
        return QUEEN;
    }
    
}
