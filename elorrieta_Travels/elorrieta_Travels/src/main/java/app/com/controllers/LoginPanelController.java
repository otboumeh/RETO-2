package main.java.app.com.controllers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.ui.panels.LoginPanel;

/**
 * La clase controlador del la funcionalidad del panel (LoginPanel).
 * 
 * - Manejar la funcionalidad de todos los botones del panel. 
 * - Validar las credenciales con los datos de la base de datos. 
 * - llevar al usuario al siguente pantalla.
 * 
 * @author Grupo_01
 */
public class LoginPanelController {

	/**
	 * Constructor que inicializa el controlador del panel LoginPanel.
	 */
	public LoginPanelController() {

		LoginPanel loginPanel = MainController.getInstance().getLoginPanel();

		loginPanel.getNewProfileButton().addActionListener(e -> toNewProfilePageButton());
		loginPanel.getLoginButton().addActionListener(e -> loginButton());
	}

	/**
	 * Este metodo oculta todos los paneles y muestra el panel NewProfilePanel y
	 * borra los datos ingresados el los campos del login (usuario y contraseña).
	 */
	private void toNewProfilePageButton() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getNewProfilePanel().setVisible(true);
		MainController.getInstance().getLoginPanel().getUsernameInput().setText("");
		MainController.getInstance().getLoginPanel().getPasswordInput().setText("");
	}

	/**
	 * Este metodo obtiene las credenciales ingresadas y los con los de agencias
	 * existentes en la bbdd si counciden muestra el siguiente panel
	 */

	private void loginButton() {
		LoginPanel loginPanel = MainController.getInstance().getLoginPanel();

		AgenciaDAO agenciaDAO = new AgenciaDAO();
		ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();

		String inputUser = loginPanel.getUsernameInput().getText();
		String inputPass = loginPanel.getPasswordInput().getText();

		boolean loggedIn = false;

		for (Agencia agencia : agencias) {
			if (agencia.getNomAgencia().equalsIgnoreCase(inputUser.trim()) && agencia.getPass().equals(inputPass)) {
				MainController.getInstance().hideAllPanels();
				MainController.getInstance().getTripsAndEventsPanel().setVisible(true);

				MainController.getInstance().getTripsAndEventsPanel().setUser(agencia.getNomAgencia());
				MainController.getInstance().getTripsAndEventsPanel().setUserId(agencia.getIdAgencia());
				MainController.getInstance().getNewEventPanel().setUserId(agencia.getIdAgencia());
				MainController.getInstance().getNewTripPanel().setUserId(agencia.getIdAgencia());

				loggedIn = true;
				MainController.getInstance().getLoginPanel().getUsernameInput().setText("");
				MainController.getInstance().getLoginPanel().getPasswordInput().setText("");
				break;
			}
		}

		if (!loggedIn) {
			JOptionPane.showMessageDialog(null, "Usuario o Password Incorrecto!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
			MainController.getInstance().getLoginPanel().getUsernameInput().setText("");
			MainController.getInstance().getLoginPanel().getPasswordInput().setText("");
		}
	}

}
