package de.sommer.chess.gui;

import javax.swing.JFrame;

public class FrameMain {
    private JFrame frame;

    public FrameMain(){
        frame = new JFrame("Chess");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChessBoardGUI());        
        frame.setVisible(true);


       }

}
