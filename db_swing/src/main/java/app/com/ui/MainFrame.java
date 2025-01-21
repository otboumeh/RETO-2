package main.java.app.com.ui;

import javax.swing.JFrame;

import main.java.app.com.ui.panels.LoginPanel;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = 1L;

	public MainFrame() {
    	 setTitle("My Application");
         setSize(1200, 800); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setLayout(null);
         
         
         LoginPanel loginPanel = new LoginPanel();        
         add(loginPanel);
         
         setResizable(false);
         setVisible(true);
    }

}
