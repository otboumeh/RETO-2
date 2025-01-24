package main.java.app.com.ui;

import javax.swing.JFrame;

import main.java.app.com.controllers.MainController;
import main.java.app.com.controllers.WelcomePanelController;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = 1L;

	public MainFrame() {
    	 setTitle("My Application");
         setSize(1200, 800); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setLayout(null);
         
         MainController mainController = new MainController();

         add(mainController.getWelcomePanel());
         add(mainController.getLoginPanel());
         
         new WelcomePanelController(mainController);	
         ///initial panel setup
         mainController.hideAllPanels();
         mainController.getWelcomePanel().setVisible(true);
         
         
         setResizable(false);
         setVisible(true);
    }

}
