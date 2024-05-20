package de.sommer.chess.logic;

import de.sommer.chess.pieces.Bishop;
import de.sommer.chess.pieces.King;
import de.sommer.chess.pieces.Knight;
import de.sommer.chess.pieces.Pawn;
import de.sommer.chess.pieces.Piece;
import de.sommer.chess.pieces.PieceColor;
import de.sommer.chess.pieces.Queen;
import de.sommer.chess.pieces.Rook;

public class ChessBoard{
    private Piece[][] board;
    
    public ChessBoard(){
        board = new Piece[8][8];
        setupBoard();
    }

    public void movePiece(Position start, Position end){
        if(board[start.getRow()][start.getColumn()] != null || board[start.getRow()][start.getColumn()].isValidMove(end, board)){
            board[end.getRow()][end.getColumn()] = board[start.getRow()][start.getColumn()];
            board[end.getRow()][end.getColumn()].setPosition(end);
            board[start.getRow()][start.getColumn()] = null;
        }
    }

    public Piece getPiece(Position pos){
        return board[pos.getRow()][pos.getColumn()];
    }

    public void setPiece(Position to, Piece piece){
        board[to.getRow()][to.getColumn()] = piece;
    }

    public Piece[][] getBoard(){
        return board;
    }

    private void setupBoard(){
        //White pieces
        board[0][0] = new Rook(PieceColor.WHITE, new Position(0, 0));
        board[0][1] = new Knight(PieceColor.WHITE, new Position(0, 1));
        board[0][2] = new Bishop(PieceColor.WHITE, new Position(0, 2));
        board[0][3] = new Queen(PieceColor.WHITE, new Position(0, 3));
        board[0][4] = new King(PieceColor.WHITE, new Position(0, 4));
        board[0][5] = new Bishop(PieceColor.WHITE, new Position(0, 5));
        board[0][6] = new Knight(PieceColor.WHITE, new Position(0, 6));
        board[0][7] = new Rook(PieceColor.WHITE, new Position(0, 7));
        for(int i = 0; i < 8; i++){
            board[1][i] = new Pawn(PieceColor.WHITE, new Position(1, i));
        }

        //Black pieces
        board[7][0] = new Rook(PieceColor.BLACK, new Position(7, 0));
        board[7][1] = new Knight(PieceColor.BLACK, new Position(7, 1));
        board[7][2] = new Bishop(PieceColor.BLACK, new Position(7, 2));
        board[7][3] = new Queen(PieceColor.BLACK, new Position(7, 3));
        board[7][4] = new King(PieceColor.BLACK, new Position(7, 4));
        board[7][5] = new Bishop(PieceColor.BLACK, new Position(7, 5));
        board[7][6] = new Knight(PieceColor.BLACK, new Position(7, 6));
        board[7][7] = new Rook(PieceColor.BLACK, new Position(7, 7));
        for(int i = 0; i < 8; i++){
            board[6][i] = new Pawn(PieceColor.BLACK, new Position(6, i));
        }
    }
}