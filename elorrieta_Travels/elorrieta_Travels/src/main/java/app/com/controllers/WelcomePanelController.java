package main.java.app.com.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.ui.panels.WelcomePanel;

/**
 * Controlador del panel de bienvenida
 * 
 * Gestiona las interacciones del usuario en el panel de bienvenida,
 * redirigiendo al usuario al panel de login al hacer clic en el fondo
 */
public class WelcomePanelController {

	/**
	 * Constructor que inicializa el controlador del panel WelcomePanel.
	 */
	public WelcomePanelController() {

		WelcomePanel welcomePanel = MainController.getInstance().getWelcomePanel();

		welcomePanel.getBackgroundLabel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleWelcomePanelClick();
			}
		});

	}

	/**
	 * Solo muestra el panel de login y ocultar los demas
	 */
	private void handleWelcomePanelClick() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getLoginPanel().setVisible(true);
	}

}
