package main.java.app.com.controllers.mainController;

import main.java.app.com.ui.panels.LoginPanel;
import main.java.app.com.ui.panels.NewEventPanel;
import main.java.app.com.ui.panels.NewProfilePanel;
import main.java.app.com.ui.panels.NewTripPanel;
import main.java.app.com.ui.panels.TripsAndEventsPanel;
import main.java.app.com.ui.panels.WelcomePanel;

/**
 * Esta clase se encarga de la gestión de los paneles de la aplicacion,
 * asegurando que solo exista una única instancia de cada panel.
 * 
 * @author Grupo_01
 */
public class MainController {

	private static MainController instance = null;

	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private NewProfilePanel newProfilePanel;
	private NewTripPanel nuevoViajePanel;
	private TripsAndEventsPanel tripsAndEventsPanel;
	private NewEventPanel newEventPanel;
	private NewTripPanel newTripPanel;

	/**
	 * Constructor privado para el uso del patrón Singleton. Inicializa todos los
	 * paneles de la aplicación.
	 */
	private MainController() {
		welcomePanel = new WelcomePanel();
		loginPanel = new LoginPanel();
		newProfilePanel = new NewProfilePanel();
		nuevoViajePanel = new NewTripPanel();
		tripsAndEventsPanel = new TripsAndEventsPanel();
		newEventPanel = new NewEventPanel();
		newTripPanel = new NewTripPanel();

	}

	/**
	 * Obtiene la instancia única del controlador.
	 * 
	 * @return Retorna una instancia única de MainController.
	 */
	public static MainController getInstance() {
		if (null == instance)
			instance = new MainController();
		return instance;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de WelcomePanel.
	 */
	public WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de LoginPanel.
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de NewProfilePanel.
	 */
	public NewProfilePanel getNewProfilePanel() {
		return newProfilePanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de NewTripPanel.
	 */
	public NewTripPanel getNuevoViajePanel() {
		return nuevoViajePanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de TripsAndEventsPanel.
	 */
	public TripsAndEventsPanel getTripsAndEventsPanel() {
		return tripsAndEventsPanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de NewEventPanel.
	 */
	public NewEventPanel getNewEventPanel() {
		return newEventPanel;
	}

	/**
	 * Obtiene el panel de bienvenida.
	 * 
	 * @return Retorna instancia de NewTripPanel.
	 */
	public NewTripPanel getNewTripPanel() {
		return newTripPanel;
	}

//////////////// metodos generales ////////////

	/**
	 * Oculta todos los paneles de la aplicación.
	 */
	public void hideAllPanels() {
		welcomePanel.setVisible(false);
		loginPanel.setVisible(false);
		newProfilePanel.setVisible(false);
		nuevoViajePanel.setVisible(false);
		tripsAndEventsPanel.setVisible(false);

		newEventPanel.setVisible(false);
		newEventPanel.getActivityPanel().setVisible(false);
		newEventPanel.getFlightPanel().setVisible(false);
		newEventPanel.getHotelPanel().setVisible(false);
		newEventPanel.getReturnFlightPanel().setVisible(false);

		newTripPanel.setVisible(false);

	}

	/**
	 * Oculta todos los subpaneles del panel NewEventPanel.
	 */
	public void hideAllSubPanels() {
		newEventPanel.getActivityPanel().setVisible(false);
		newEventPanel.getFlightPanel().setVisible(false);
		newEventPanel.getReturnFlightPanel().setVisible(false);
		newEventPanel.getHotelPanel().setVisible(false);
	}
}
