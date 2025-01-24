package main.java.app.com.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.app.com.ui.panels.WelcomePanel;

public class WelcomePanelController {
	
	private final MainController mainController;
	
	public WelcomePanelController(MainController mainController){
		this.mainController = mainController;
		
        WelcomePanel welcomePanel = mainController.getWelcomePanel();

		welcomePanel.getBackgroundLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleWelcomePanelClick();
            }
        });
			
	}
	
	private void handleWelcomePanelClick() {
		mainController.hideAllPanels();
		mainController.getLoginPanel().setVisible(true);
	}

}
