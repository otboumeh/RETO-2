package main.java.app.com.controllers.mainController;

import main.java.app.com.ui.panels.LoginPanel;
import main.java.app.com.ui.panels.NewEventPanel;
import main.java.app.com.ui.panels.NewProfilePanel;
import main.java.app.com.ui.panels.NewTripPanel;
import main.java.app.com.ui.panels.TripsAndEventsPanel;
import main.java.app.com.ui.panels.WelcomePanel;
import main.java.app.com.ui.panels.newEventsSubpanels.ActivityPanel;

public class MainController {

	private static MainController instance = null;

	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private NewProfilePanel newProfilePanel;
	private NewTripPanel nuevoViajePanel;
	private ActivityPanel activityPanel;
	private TripsAndEventsPanel tripsAndEventsPanel;
	private NewEventPanel newEventPanel;
	private NewTripPanel newTripPanel;

	private MainController() {
		welcomePanel = new WelcomePanel();
		loginPanel = new LoginPanel();
		newProfilePanel = new NewProfilePanel();
		nuevoViajePanel = new NewTripPanel();
		activityPanel = new ActivityPanel();
		tripsAndEventsPanel = new TripsAndEventsPanel(); 
		newEventPanel = new NewEventPanel();
		newTripPanel = new NewTripPanel();
	}

	public static MainController getInstance() {
		if (null == instance)
			instance = new MainController();
		return instance;
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

	public NewTripPanel getNuevoViajePanel() {
		return nuevoViajePanel;
	}

	public ActivityPanel getEventPanel() {
		return activityPanel;
	}

	public TripsAndEventsPanel getTripsAndEventsPanel() {
		return tripsAndEventsPanel;
	}
	
	public NewEventPanel getNewEventPanel() {
		return newEventPanel;
	}
	
	public NewTripPanel getNewTripPanel() {
		return newTripPanel;
	}
	
	
//////////////// metodos generales ////////////
	
	public void hideAllPanels() {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(false);
		newProfilePanel.setVisible(false);
		nuevoViajePanel.setVisible(false);
		activityPanel.setVisible(false);
		tripsAndEventsPanel.setVisible(false);
		
		newEventPanel.setVisible(false);
		newEventPanel.getFlightPanel().setVisible(false);
		newEventPanel.getHotelPanel().setVisible(false);
		newEventPanel.getReturnFlightPanel().setVisible(false);
		newEventPanel.getActivityPanel().setVisible(false);
		
		newTripPanel.setVisible(false);

	}
}
