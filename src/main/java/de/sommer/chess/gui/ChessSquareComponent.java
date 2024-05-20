package de.sommer.chess.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import de.sommer.chess.pieces.PieceColor;

public class ChessSquareComponent extends JButton {
    public static final int BLACK = 0;
    public static final int WHITE = 1;
    private int row;
    private int column;

    static Image[][] chessPieceImages = new Image[2][6];

    static{
        try {
            BufferedImage bi = ImageIO.read(ChessSquareComponent.class.getResource("/memI0.png")); //ImageIO.read(getClass().getResource("/pieces/memIO.png"));
            for (int ii = 0; ii < 2; ii++) {
                for (int jj = 0; jj < 6; jj++) {
                    chessPieceImages[ii][jj] = bi.getSubimage(
                            jj * 64, ii * 64, 64, 64);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }

    public ChessSquareComponent(int row, int column){
        this.row = row;
        this.column = column;
        initButton();
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    private void initButton(){
        setPreferredSize(new Dimension(64, 64));
        
        setMargin(new Insets(0, 0, 0, 0));
        ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        setIcon(icon);
        if ((column % 2 == 1 && row % 2 == 1) || (column % 2 == 0 && row % 2 == 0)) {
            setBackground(new Color(75, 100, 138));
        } else {
            setBackground(new Color(208, 223, 244));
        }
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setPiece(int piece, PieceColor pieceColor){
        setIcon(new ImageIcon(chessPieceImages[pieceColor.ordinal()][piece]));
    }

    public void removePiece(){
        setIcon(null);
    }

    public void highlight() {
        setBackground(new Color(255, 255, 0));
    }

    public void removeHighlight(){
        if ((column % 2 == 1 && row % 2 == 1) || (column % 2 == 0 && row % 2 == 0)) {
            setBackground(new Color(75, 100, 138));
        } else {
            setBackground(new Color(208, 223, 244));
        }
    }

    
}
