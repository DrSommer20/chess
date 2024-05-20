package de.sommer.chess.logic;

import java.util.ArrayList;
import java.util.List;

import de.sommer.chess.pieces.King;
import de.sommer.chess.pieces.Piece;
import de.sommer.chess.pieces.PieceColor;

public class ChessGame {
    private boolean whiteTurn;
    private ChessBoard board;
    private Piece selectedPiece;

    public ChessGame(){
        this.board = new ChessBoard();
        whiteTurn = true;
    }

    public boolean makeMove(Position start, Position end){
        Piece piece = board.getPiece(start);
        if(piece == null || piece.getColor() == (whiteTurn ? PieceColor.WHITE : PieceColor.BLACK)) return false;
        if(piece.isValidMove(end, board.getBoard())){
            board.movePiece(start, end);
            whiteTurn = !whiteTurn;
            return true;
        }
        return false;
    }

    public boolean isInCheck(PieceColor kingColor){
        Position kingPosition = findKingPosition(kingColor);
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[0].length; j++){
                Piece piece = board.getPiece(new Position(i, j));
                if(piece != null && piece.getColor() != kingColor && piece.isValidMove(kingPosition, board.getBoard())) return true;
            }
        }
        return false;

    }

    private Position findKingPosition(PieceColor kingColor) {
        for(int i = 0; i < board.getBoard().length; i++){
            for(int j = 0; j < board.getBoard()[0].length; j++){
                Piece piece = board.getPiece(new Position(i, j));
                if(piece != null && piece.getColor() == kingColor && piece.getClass() == King.class) return new Position(i, j);
            }
        }
        throw new RuntimeException("King not found");
    }

    public boolean isCheckmate(PieceColor kingColor){
        if(!isInCheck(kingColor)) return false;
        Position kingPosition = findKingPosition(kingColor);
        King king = (King)board.getPiece(kingPosition);

        for(int rowDiff = -1; rowDiff <= 1; rowDiff++){
            for(int colDiff = -1; colDiff <= 1; colDiff++){
                if(rowDiff == 0 && colDiff == 0) continue;
                    Position newPosition = new Position(kingPosition.getRow() + rowDiff, kingPosition.getColumn() + colDiff);
                    if(king.isValidMove(newPosition,  board.getBoard())) return false;
            }
        }
        return true;
    }

    public boolean isValidPosition(Position pos){
        return (0 <= pos.getRow() && pos.getRow() <= board.getBoard().length) && (0 <= pos.getColumn() && pos.getColumn() <= board.getBoard()[0].length);
    }

    public boolean isInCheckAfterMove(PieceColor kingColor, Position fromPosition, Position toPosition){
        Piece tempPiece = board.getPiece(toPosition);
        
        board.setPiece(toPosition, board.getPiece(fromPosition));
        board.setPiece(fromPosition, null);
        
        boolean isInCheck = isInCheck(kingColor);

        board.setPiece(fromPosition, board.getPiece(toPosition));
        board.setPiece(toPosition, tempPiece);

        return isInCheck;
    }

    public List<Position> getValidMoves(Position pos){
        Piece piece = board.getPiece(pos);
        List<Position> validMoves = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Position newPos = new Position(i, j);
                if(piece.isValidMove(newPos, board.getBoard()) && !isInCheckAfterMove(piece.getColor(), pos, newPos)){
                    validMoves.add(newPos);
                }
            }
        }
        return validMoves;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean squareClicked(Position position) {
        if(selectedPiece == null){
            selectedPiece = board.getPiece(position);
            return selectedPiece != null;
        }
        else{
            boolean makeMove = makeMove(selectedPiece.getPosition(), position);
            selectedPiece = null;
            return makeMove;
        }
    }

    public boolean isPieceSelected(){
        return selectedPiece != null;
    }

    public PieceColor getTurn(){
        return whiteTurn ? PieceColor.WHITE : PieceColor.BLACK;
    }

    public void resetGame() {
        this.board = new ChessBoard();
        whiteTurn = true;
    }
}
