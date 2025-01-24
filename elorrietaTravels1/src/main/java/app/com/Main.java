package main.java.app.com;

import main.java.app.com.ui.MainFrame;

public class Main {

	public static void main(String[] args) {
	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	new MainFrame();
            }
        });
    }
	
}
