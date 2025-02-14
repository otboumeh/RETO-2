package main.java.app.com.controllers;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.services.Service;
import main.java.app.com.ui.panels.NewProfilePanel;

/**
 * La clase controlador del la funcionalidad del panel (NewProfilePanel).
 * 
 * Gestiona las validaciones de los inputs de entrada y la interaccion con la bbdd
 */
public class NewProfilePanelController {
	private NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private Service service = new Service();

	/**
	 * Constructor que inicializa el controlador del panel NewProfilePanel.
	 * 
     * Maneja los `DocumentListener` para la validación al hacer cambios en los campos
     * de contraseña, color y logo, y agrega `ActionListener` para los botones de cancelar y guardar.
     */
	public NewProfilePanelController() {

		newProfilePanel.getAgencyColorInput().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				colorInputBackground();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				colorInputBackground();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				colorInputBackground();
			}
		});

		newProfilePanel.getLogoInput().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				logoEvaluator();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				logoEvaluator();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				logoEvaluator();
			}
		});

		newProfilePanel.getAgencyPasswordInput().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				passwordEvaluator();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				passwordEvaluator();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				passwordEvaluator();
			}
		});

		newProfilePanel.getCancelButton().addActionListener(e -> toLoginPanelButton());
		newProfilePanel.getSaveButton().addActionListener(e -> newProfileDataEvaluator());
	}

	/**
	 * Cambia la vista al panel de login
	 */
	private void toLoginPanelButton() {

		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getLoginPanel().setVisible(true);
		newProfilePanel.getAgencyNameInput().setText("");
		newProfilePanel.getAgencyColorInput().setText("");
		newProfilePanel.getNumEmployeesInput().setSelectedIndex(0);
		newProfilePanel.getAgencyTypesInput().setSelectedIndex(0);
		newProfilePanel.getLogoInput().setText("");
	}

	/**
	 * Evalua si la contraseña contien al menos una letra mayuscula, un numero y un simbolo
	 * 
	 * @return Retorna ´true´ si la contraseña es valida, ´false en caso contrario
	 */
	private boolean passwordEvaluator() {
		boolean ret = false;
		String inputPass = newProfilePanel.getAgencyPasswordInput().getText();
		String upperRegex = ".*[A-Z].*";
		String symbolRegex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/`~].*";
		String numberRegex = ".*[0-9].*";

		if (!inputPass.matches(upperRegex)) {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		} else if (!inputPass.matches(symbolRegex)) {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		} else if (!inputPass.matches(numberRegex)) {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		} else {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.BLACK);
			ret = true;
		}
		return ret;
	}

	/**
	 * Cambia el fondo del campo de color segun el valor ingresado Si el color es
	 * valido, el fondo cambia al color especificado; si no, se pone rojo
	 */
	private void colorInputBackground() {
		String inputColor = newProfilePanel.getAgencyColorInput().getText().trim();

		if (service.colorCodeEvaluator(inputColor)) {
			newProfilePanel.getAgencyColorInput().setBackground(Color.decode(inputColor));
			newProfilePanel.getAgencyColorInput().setForeground(service.getComplementaryColor(inputColor));
		} else {
			newProfilePanel.getAgencyColorInput().setBackground(Color.WHITE);
			newProfilePanel.getAgencyColorInput().setForeground(Color.RED);

		}
	}

	/**
	 * Evalua si el numero de empleados seleccionado es valido
	 * 
	 * @return  Retorna ´true´ si el numero de empleados es valido, ´false en caso contrario
	 */
	private boolean numEmployeesEvaluator() {
		boolean ret = false;
		if (newProfilePanel.getNumEmployeesInput().getSelectedIndex() != 0) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Evalua si el tipo de agencia seleccionado es valido
	 * 
	 * @return  Retorna ´true´ si el tipo de agencia es valido, ´false´ en caso contrario
	 */
	private boolean agencyTypeEvaluator() {
		boolean ret = false;
		if (newProfilePanel.getAgencyTypesInput().getSelectedIndex() != 0) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Valida la URL del logo ingresado
	 * 
	 * @return  Retorna ´true´ si la URL del logo es valida, ´false´ en caso contrario.
	 */
	private void logoEvaluator() {
		String inputLogo = newProfilePanel.getLogoInput().getText().trim();

		if (service.urlCodeEvaluator(inputLogo)) {
			newProfilePanel.getLogoInput().setForeground(Color.BLACK);
		} else {
			newProfilePanel.getLogoInput().setForeground(Color.RED);
		}
	}

	/**
	 * Obtiene el Id del ultimo registro de agencia
	 * 
	 * @return Retorna el Id del ultimo registro de agencia en la bbdd
	 */
	private String getIdLastAgency() {
		String ret = null;
		ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
		ret = agencias.get(agencias.size() - 1).getIdAgencia();
		return ret;
	}

	/**
	 * Valida y guarda los datos del nuevo perfil de agencia
	 * 
	 * Si los datos son validos, se crea una nueva agencia y se guarda en la base de datos
	 */
	private void newProfileDataEvaluator() {
		String idAgencia = service.incrementString(getIdLastAgency());
		String inputName = newProfilePanel.getAgencyNameInput().getText();
		String inputPass = newProfilePanel.getAgencyPasswordInput().getText();
		String inputTipo = (String) newProfilePanel.getAgencyTypesInput().getSelectedItem();
		String inputNumEmp = (String) newProfilePanel.getNumEmployeesInput().getSelectedItem();
		String inputColor = newProfilePanel.getAgencyColorInput().getText();
		String inputLogo = newProfilePanel.getLogoInput().getText();

		Agencia newAgencia = new Agencia();
		newAgencia.setIdAgencia(idAgencia);
		newAgencia.setNomAgencia(inputName);
		newAgencia.setPass(inputPass);
		newAgencia.setTipoAgencia(inputTipo);
		newAgencia.setNumEmp(inputNumEmp);
		newAgencia.setColorAgencia(inputColor);
		newAgencia.setLogo(inputLogo);

		if (!passwordEvaluator()) {
			JOptionPane.showMessageDialog(null, "La contraseña debe contener MAYUSCULAS, Symbolos y Numeros",
					"Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
		} else if (!service.colorCodeEvaluator(inputColor) || !numEmployeesEvaluator() || !agencyTypeEvaluator()
				|| !service.urlCodeEvaluator(inputLogo)) {
			JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados no son correctos.", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {
			agenciaDAO.addAgencyToDB(newAgencia);
			toLoginPanelButton();
		}
	}

}
