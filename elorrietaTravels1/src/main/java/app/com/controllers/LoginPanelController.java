package main.java.app.com.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.app.com.ui.panels.LoginPanel;

public class LoginPanelController {

	private final MainController mainController;
	
	public LoginPanelController(MainController mainController){
		this.mainController = mainController;
		
        LoginPanel loginPanel = mainController.getLoginPanel();

        loginPanel.getNewProfileButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toNewProfilePageButton();
            }
        });			
	}
	
	private void toNewProfilePageButton() {
		mainController.hideAllPanels();
		mainController.getNewProfilePanel().setVisible(true);
	}
}
