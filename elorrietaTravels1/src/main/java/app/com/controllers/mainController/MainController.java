package main.java.app.com.controllers.mainController;

import main.java.app.com.ui.panels.ActivityPanel;
import main.java.app.com.ui.panels.FlightPanel;
import main.java.app.com.ui.panels.LoginPanel;
import main.java.app.com.ui.panels.NewEvent;
import main.java.app.com.ui.panels.NewProfilePanel;
import main.java.app.com.ui.panels.NuevoViajePanel;
import main.java.app.com.ui.panels.TripsAndEventsPanel;
import main.java.app.com.ui.panels.WelcomePanel;

public class MainController {

	private static MainController instance = null;

	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private NewProfilePanel newProfilePanel;
	private NuevoViajePanel nuevoViajePanel;
	private ActivityPanel eventPanel;
	private TripsAndEventsPanel tripsAndEventsPanel;
	private NewEvent newEvent;
	private MainController() {
		welcomePanel = new WelcomePanel();
		loginPanel = new LoginPanel();
		newProfilePanel = new NewProfilePanel();
		nuevoViajePanel = new NuevoViajePanel();
		eventPanel = new ActivityPanel();
		tripsAndEventsPanel = new TripsAndEventsPanel();
		newEvent = new NewEvent();
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

	public NuevoViajePanel getNuevoViajePanel() {
		return nuevoViajePanel;
	}

	public ActivityPanel getEventPanel() {
		return eventPanel;
	}

	public TripsAndEventsPanel getTripsAndEventsPanel() {
		return tripsAndEventsPanel;
	}
	public NewEvent getNewEvent() {
		return newEvent;
	}
	
//////////////// metodos generales ////////////
	
	public void hideAllPanels() {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(false);
		newProfilePanel.setVisible(false);
		nuevoViajePanel.setVisible(false);
		eventPanel.setVisible(false);
		tripsAndEventsPanel.setVisible(false);
		newEvent.setVisible(false);
	}
}
