package main.java.app.com;

import main.java.app.com.ui.MainFrame;

/**
 * La clase de entrada principal de la aplicación inicia todos lo que tiene la
 * main frame en esta clase.
 */
public class Main {

    /**
     * Método principal de la aplicación.
     *
     * @param args 
     */
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}

}
