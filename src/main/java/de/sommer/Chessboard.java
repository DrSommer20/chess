package de.sommer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Chessboard extends JPanel{

    private JButton[][] fields = new JButton[8][8];
    private static final String COLS = "ABCDEFGH";
    private Image[][] chessPieceImages = new Image[2][6];
    public static final int QUEEN = 0, KING = 1, ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };


    public Chessboard() {
        super(new GridLayout(0, 9));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        setupImages();
        
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < fields.length; ii++) {
            for (int jj = 0; jj < fields[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        //) {
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(new Color(75, 100, 138));
                } else {
                    b.setBackground(new Color(208, 223, 244));
                }
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

        setupNewGame();

    }

    private void setupImages() {
        try {
            URI uri = new URI("https://i.stack.imgur.com/memI0.png");
            URL url = uri.toURL();

            BufferedImage bi = ImageIO.read(url);
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

    private void setupNewGame() {
        for(int i = 0; i < STARTING_ROW.length; i++) {
            fields[i][0].setIcon(new ImageIcon(
                    chessPieceImages[0][STARTING_ROW[i]]));
            fields[i][1].setIcon(new ImageIcon(
                    chessPieceImages[0][PAWN]));
            fields[i][6].setIcon(new ImageIcon(
                    chessPieceImages[1][PAWN]));
            fields[i][7].setIcon(new ImageIcon(
                    chessPieceImages[1][STARTING_ROW[i]]));
        }
    }





}
