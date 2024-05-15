package de.sommer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{

    JMenuBar menuBar;
    
    public MainFrame() {
        super("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        

        menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        gameMenu.add(new JMenuItem("New Game")); // TODO - add functionality!
        gameMenu.add(new JMenuItem("Save")); // TODO - add functionality!
        gameMenu.add(new JMenuItem("Restore"));// TODO - add functionality!
        
        menuBar.add(gameMenu);

        this.setJMenuBar(menuBar);
        this.add(new Chessboard());
        this.setVisible(true);
    }
}
