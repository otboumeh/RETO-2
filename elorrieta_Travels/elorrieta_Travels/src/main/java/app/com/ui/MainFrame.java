package main.java.app.com.ui;

import javax.swing.JFrame;

import main.java.app.com.controllers.LoginPanelController;
import main.java.app.com.controllers.NewEventPanelController;
import main.java.app.com.controllers.NewProfilePanelController;
import main.java.app.com.controllers.NewTripPanelController;
import main.java.app.com.controllers.TripsAndEventsPanelController;
import main.java.app.com.controllers.WelcomePanelController;
import main.java.app.com.controllers.mainController.MainController;

/**
 * La clase de la ventana principal de la aplicación, donde se administran todos
 * los paneles
 * 
 * @author Groupo_01
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * El constructor que inicializa la ventana principal Configura todos los
	 * aspectos visuales de la ventana .
	 */
	public MainFrame() {
		setTitle("My Application");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		add(MainController.getInstance().getWelcomePanel());
		add(MainController.getInstance().getLoginPanel());
		add(MainController.getInstance().getNewProfilePanel());
		add(MainController.getInstance().getNuevoViajePanel());
		add(MainController.getInstance().getTripsAndEventsPanel());
		add(MainController.getInstance().getNewEventPanel());
		add(MainController.getInstance().getNewTripPanel());

		new WelcomePanelController();
		new LoginPanelController();
		new NewProfilePanelController();
		new TripsAndEventsPanelController();
		new NewEventPanelController();
		new NewTripPanelController();

		/// initial panel setup
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getWelcomePanel().setVisible(true);

		setResizable(false);
		setVisible(true);
	}

}
