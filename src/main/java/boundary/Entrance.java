package boundary;

import com.jtattoo.plaf.mint.MintLookAndFeel;

import javax.swing.*;

public class Entrance {
    public static void main(String args[]){
        Entrance entrance = new Entrance();
        entrance.initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(new MintLookAndFeel());

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        InitPage initPage = new InitPage();
    }

}
