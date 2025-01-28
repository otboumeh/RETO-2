package main.java.app.com.controllers;

import main.java.app.com.ui.panels.EventPanel;
import main.java.app.com.ui.panels.LoginPanel;
import main.java.app.com.ui.panels.NewProfilePanel;
import main.java.app.com.ui.panels.NuevoViajePanel;
import main.java.app.com.ui.panels.WelcomePanel;

public class MainController {

	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private NewProfilePanel newProfilePanel; 
	private NuevoViajePanel nuevoViajePanel;
	private EventPanel eventPanel;
	
    public MainController() {
        if (welcomePanel == null) {
            welcomePanel = new WelcomePanel();
        }
        if (loginPanel == null) {
            loginPanel = new LoginPanel();
        }
        if (newProfilePanel == null) {
        	newProfilePanel = new NewProfilePanel();
        }
        if (nuevoViajePanel == null) {
        	nuevoViajePanel = new NuevoViajePanel();
        }
        if (eventPanel == null) {
        	eventPanel = new EventPanel();
        }
    }
    
    public WelcomePanel getWelcomePanel() {
        return welcomePanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }
    
    public NewProfilePanel getNewProfilePanel() {
        return newProfilePanel;
    }
    
    public NuevoViajePanel getNuevoViajePanel() {
        return nuevoViajePanel;
    }  
    
    public EventPanel getEventPanel() {
        return eventPanel;
    }
    
	public void hideAllPanels() {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(false);
		newProfilePanel.setVisible(false);
	}
}
