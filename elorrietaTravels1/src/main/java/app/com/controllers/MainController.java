package main.java.app.com.controllers;

import main.java.app.com.ui.panels.LoginPanel;
import main.java.app.com.ui.panels.WelcomePanel;

public class MainController {

	private static WelcomePanel welcomePanel;
	private static LoginPanel loginPanel;
	
    public MainController() {
        if (welcomePanel == null) {
            welcomePanel = new WelcomePanel();
        }
        if (loginPanel == null) {
            loginPanel = new LoginPanel();
        }
    }
    
    public WelcomePanel getWelcomePanel() {
        return welcomePanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
	
	public void hideAllPanels() {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(false);
	}
}
