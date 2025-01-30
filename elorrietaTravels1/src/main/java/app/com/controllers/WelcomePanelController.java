package main.java.app.com.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.ui.panels.WelcomePanel;

public class WelcomePanelController {
	
	
	public WelcomePanelController(){
		
        WelcomePanel welcomePanel = MainController.getInstance().getWelcomePanel();

		welcomePanel.getBackgroundLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleWelcomePanelClick();
            }
        });
			
	}
	
	private void handleWelcomePanelClick() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getLoginPanel().setVisible(true);
	}

}
