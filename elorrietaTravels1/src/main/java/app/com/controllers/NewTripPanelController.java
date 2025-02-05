package main.java.app.com.controllers;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.ui.panels.NewTripPanel;

public class NewTripPanelController {
	
	public NewTripPanelController() {

		NewTripPanel newTripPanel = MainController.getInstance().getNewTripPanel();

		newTripPanel.getBackButton().addActionListener(e -> backButton());
	}
	
    private void backButton() {
        MainController.getInstance().getNewEventPanel().setVisible(false);
        MainController.getInstance().getTripsAndEventsPanel().setVisible(true);
    }
}
