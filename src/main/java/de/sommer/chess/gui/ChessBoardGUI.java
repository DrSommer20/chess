package de.sommer.chess.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.sommer.chess.logic.ChessBoard;
import de.sommer.chess.logic.ChessGame;
import de.sommer.chess.logic.Position;
import de.sommer.chess.pieces.Piece;
import de.sommer.chess.pieces.PieceColor;

public class ChessBoardGUI extends JPanel{

    private ChessSquareComponent[][] fields = new ChessSquareComponent[8][8];
    private static final String COLS = "ABCDEFGH";
    private ChessGame game;


    public ChessBoardGUI() {
        super(new GridLayout(0, 9));
        game = new ChessGame();
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        for (int ii = 0; ii < fields.length; ii++) {
            for (int jj = 0; jj < fields[ii].length; jj++) {
                ChessSquareComponent b = new ChessSquareComponent(ii, jj);
                b.addActionListener(e -> squareClicked(b.getRow(), b.getColumn()));
                fields[jj][ii] = b;
            }
        }
        /*
         * fill the chess board
         */
        this.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            this.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        this.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        this.add(fields[jj][ii]);
                }
            }
        }
        refreshBoard();
    }

    private void refreshBoard() {
        ChessBoard board = game.getBoard();
        for (int ii = 0; ii < fields.length; ii++) {
            for (int jj = 0; jj < fields[ii].length; jj++) {
                Piece piece = board.getPiece(new Position(ii, jj));
                if(piece != null){
                    fields[jj][ii].setPiece(piece.getTypeInt(), piece.getColor());
                }   
                else{
                    fields[jj][ii].removePiece();
                }
            }
        }
    }

    private void squareClicked(int row, int column) {
        removeHighlights();
        if(game.squareClicked(new Position(row, column))){
            refreshBoard();
            checkGameOver();
            checkGameState();
        }
        if(game.isPieceSelected()){
            highlightValidMoves(new Position(row, column));
        }
        refreshBoard();
    }

    private void checkGameOver() {
        if(game.isCheckmate(game.getTurn())){
            int response = JOptionPane.showConfirmDialog(null, "Checkmate! " + game.getTurn() + " loses! Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                resetGame();
            } else {
                System.exit(0);
            }
        }
    }

    private void resetGame() {
        game.resetGame();
    }

    private void checkGameState() {
        
        PieceColor currentPlayer = game.getTurn();
        boolean inCheck = game.isInCheck(currentPlayer);
    
        if (inCheck) {
            JOptionPane.showMessageDialog(this, currentPlayer + " is in check!");
        }
        
    }

    private void highlightValidMoves(Position pos){
        if(game.getTurn() != game.getBoard().getPiece(pos).getColor()){
            for(Position p : game.getValidMoves(pos)){
                fields[p.getColumn()][p.getRow()].highlight();
            }
        }
    }

    private void removeHighlights(){
        for (int ii = 0; ii < fields.length; ii++) {
            for (int jj = 0; jj < fields[ii].length; jj++) {
                fields[jj][ii].removeHighlight();
            }
        }
    }
}
