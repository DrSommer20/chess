package de.sommer.chess.pieces;

import de.sommer.chess.logic.Position;

public class Bishop extends Piece {
    public Bishop(PieceColor color, Position position) {
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
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
        return false;
    }

    @Override
    public int getTypeInt() {
        return BISHOP;
    }
}