package de.sommer.chess;

import javax.swing.UIManager;

import com.formdev.flatlaf.IntelliJTheme;

import de.sommer.chess.gui.FrameMain;



public class App 
{
    public static void main( String[] args )
    {
        IntelliJTheme.setup(App.class.getResourceAsStream("/Cobalt_2.theme.json"));
		UIManager.put( "Button.arc", 12 );
		UIManager.put( "Component.arc", 12 );
		UIManager.put( "ProgressBar.arc", 12);
		UIManager.put( "TextComponent.arc", 12 ); 
        new FrameMain();
        
    }
}