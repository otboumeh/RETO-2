package main.java.app.com.controllers;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.dao.PaisDAO;
import main.java.app.com.database.dao.ViajeDAO;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.database.models.Pais;
import main.java.app.com.database.models.Viaje;
import main.java.app.com.services.Service;
import main.java.app.com.ui.panels.NewTripPanel;

/**
 * La clase controlador del la funcionalidad del panel (NewTripPanel).
 *
 * Maneja las validaciones de los campos, interacciones con la bbdd y la
 * creacion de un viaje nuevo.
 */
public class NewTripPanelController {

	private NewTripPanel newTripPanel = MainController.getInstance().getNewTripPanel();
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private ViajeDAO viajeDAO = new ViajeDAO();
	private Service service = new Service();
	private String idAgencia = null;

	private String selectedTripName = null;
	private String selectedTripType = null;
	private String selectedStartDate = null;
	private String selectedEndDate = null;
	private String selectedTripDuration = null;
	private String selectedCountry = null;
	private String selectedDescription = null;
	private String selectedSNI = null;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Constructor que inicializa el controlador del panel NewTripPanel.
	 */
	public NewTripPanelController() {

		newTripPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				String userId = newTripPanel.getUserId();
				Agencia agencia = new Agencia();
				ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
				for (Agencia agency : agencias) {
					if (agency.getIdAgencia().equalsIgnoreCase(userId)) {
						agencia = agency;
						break;
					}
				}
				service.changeImage(newTripPanel.getLogoLabel(), agencia.getLogo());
			}
		});
		JDateChooser startDate = newTripPanel.getStartDateField();
		JDateChooser endDate = newTripPanel.getEndDateField();
		JTextField tripDurationField = newTripPanel.getDaysField();

		startDate.addPropertyChangeListener("date", dateChanger(startDate, endDate, tripDurationField));
		endDate.addPropertyChangeListener("date", dateChanger(startDate, endDate, tripDurationField));

		String[] newAirportsData = countryGeneratorBD();
		newTripPanel.getCountryComboBox().setModel(new DefaultComboBoxModel<>(newAirportsData));

		newTripPanel.getSavebutton().addActionListener(e -> saveButton());
		newTripPanel.getBackButton().addActionListener(e -> backButton());
	}

	/**
	 * Detecta cambios en las fechas de inicio y fin del viaje, y actualiza la
	 * duracion del viaje en el campo correspondiente.
	 *
	 * @param startDate         Campo de fecha de inicio
	 * @param endDate           Campo de fecha de fin
	 * @param tripDurationField Campo para la duracion del viaje.
	 * @return Retorna un´PropertyChangeListener´ configurado.
	 */
	private PropertyChangeListener dateChanger(JDateChooser startDate, JDateChooser endDate,
			JTextField tripDurationField) {
		PropertyChangeListener ret = null;

		ret = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				updateDateDifference(startDate, endDate, tripDurationField);
			}
		};
		return ret;
	}

	/**
	 * Calcula y muestra la diferencia en días entre las fechas de inicio y fin
	 *
	 * @param chooser1    Campo de la fecha de inicio
	 * @param chooser2    Campo de la fecha de fin
	 * @param resultField Campo de duración en dias
	 */
	private void updateDateDifference(JDateChooser chooser1, JDateChooser chooser2, JTextField resultField) {
		java.util.Date date1 = chooser1.getDate();
		java.util.Date date2 = chooser2.getDate();

		if (date1 != null && date2 != null) {
			long diffInMillies = date2.getTime() - date1.getTime();
			long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			resultField.setText(String.valueOf(diffInDays));
		} else {
			resultField.setText("0");
		}
	}

	/**
	 * Genera un array de paises de la bbdd para poblar el combo de paises
	 *
	 * @return Retorna array de nombres de paises.
	 */
	private String[] countryGeneratorBD() {
		String[] ret;

		PaisDAO paisDAO = new PaisDAO();
		ArrayList<Pais> countries = paisDAO.getAllCountries();
		ret = new String[countries.size() + 1];
		ret[0] = "Elige una opcion";
		for (Pais country : countries) {
			ret[countries.indexOf(country) + 1] = country.getNomPais() + "";
		}
		return ret;
	}

	/**
	 * Limpia los campos del panel de creacion de viaje.
	 */
	private void clearNewTripPanel() {
		newTripPanel.getNameField().setText("");
		newTripPanel.getTypeField().setSelectedIndex(0);
		;
		newTripPanel.getStartDateField().setDate(null);
		newTripPanel.getEndDateField().setDate(null);
		newTripPanel.getDaysField().setText("");
		newTripPanel.getCountryComboBox().setSelectedIndex(0);
		newTripPanel.getDescriptionArea().setText("");
		newTripPanel.getServicesArea().setText("");
	}

	/**
	 * Maneja el click en el boton de guardar. Valida la informacion ingresada y, si
	 * es valida, guarda el nuevo viaje en la bbdd
	 */
	private void saveButton() {
		if (evaluateNewTrip()) {
			JOptionPane.showMessageDialog(null, "Viaje añadido Correctamente.");
			clearNewTripPanel();
		}
	}

	/**
	 * Evalua si los datos ingresados para un nuevo viaje son validos
	 *
	 * @return Retorna ´true´ si los datos son validos, ´false en cas contrario
	 */
	private boolean evaluateNewTrip() {
		boolean ret = false;

		selectedTripName = newTripPanel.getNameField().getText();
		selectedTripType = newTripPanel.getTypeField().getSelectedItemText();

		java.util.Date startDate = (java.util.Date) newTripPanel.getStartDateField().getDate();
		java.util.Date endDate = (java.util.Date) newTripPanel.getEndDateField().getDate();

		selectedTripDuration = newTripPanel.getDaysField().getText();
		selectedCountry = newTripPanel.getCountryComboBox().getSelectedItemText();
		selectedDescription = newTripPanel.getDescriptionArea().getText();
		selectedSNI = newTripPanel.getServicesArea().getText();

		if (selectedTripName.isEmpty() || selectedTripType.equalsIgnoreCase("Elige una opcion") || startDate == null
				|| endDate == null || selectedTripDuration.isEmpty()
				|| selectedCountry.equalsIgnoreCase("Elige una opcion") || selectedDescription.isEmpty()
				|| selectedSNI.isEmpty()) {

			JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {

			java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
			selectedStartDate = dateFormat.format(sqlStartDate);

			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
			selectedEndDate = dateFormat.format(sqlEndDate);

			if (!service.isDate(selectedStartDate)) {
				JOptionPane.showMessageDialog(null, "Fecha Inicio Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (endDate.before(startDate)) {
				JOptionPane.showMessageDialog(null,
						"La fecha del fin de viaje no puede ser antes de la fecha del inicio.", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isDate(selectedEndDate)) {
				JOptionPane.showMessageDialog(null, "Numero de días Incorrecto, debe ser numerico", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isNumber(selectedTripDuration)) {
				JOptionPane.showMessageDialog(null, "Fecha Vuelta no puede ser Antes de Ida", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String idViaje = service.incrementString(getIdLastViaje());
				idAgencia = newTripPanel.getUserId();
				Viaje viaje = createNewTrip(idViaje, selectedTripName, selectedTripType, sqlStartDate, sqlEndDate,
						Integer.valueOf(selectedTripDuration), selectedCountry, selectedDescription, selectedSNI,
						idAgencia);
				viajeDAO.addViajeToDB(viaje);

				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Crea un nuevo objeto ´Viaje´ con los datos ingresados.
	 *
	 * @param idViaje Id del viaje
	 * @param nomViaje Nombre del viaje
	 * @param tipoViaje Tipo de viaje
	 * @param fechInicio Fecha de inicio del viaje
	 * @param fechFin Fecha de fin del viaje
	 * @param numDias Numero de dias del viaje
	 * @param paisDestino Pais de destino
	 * @param desc Descripcion del viaje
	 * @param sni Servicios no incluidos
	 * @param idAgencia Id de la agencia
	 * @return Retorna el objeto ´Viaje´ creado
	 */
	private Viaje createNewTrip(String idViaje, String nomViaje, String tipoViaje, Date fechInicio, Date fechFin,
			int numDias, String paisDestino, String desc, String sni, String idAgencia) {
		Viaje ret = new Viaje();
		ret.setIdViaje(idViaje);
		ret.setNomViaje(nomViaje);
		ret.setTipoViaje(tipoViaje);
		ret.setFechInicio(fechInicio);
		ret.setFechFin(fechFin);
		ret.setNumDias(numDias);
		ret.setPais(paisDestino);
		ret.setDescripcion(desc);
		ret.setServiciosnoIncl(sni);
		ret.setIdAgencia(idAgencia);
		return ret;
	}

	/**
	 * Obtiene el Id del ultimo viaje registrado en la bbdd
	 *
	 * @return Retorna el ID del ultimo viaje.
	 */
	private String getIdLastViaje() {
		String ret = null;
		ArrayList<Viaje> viajes = viajeDAO.getAllViajes();
		ret = viajes.get(viajes.size() - 1).getIdViaje();
		return ret;
	}

	/**
	 * Maneja el evento clic en el boton de volver Cambia la vista a la pantalla
	 * de viajes y eventos
	 */
	private void backButton() {
		MainController.getInstance().getNewEventPanel().setVisible(false);
		MainController.getInstance().getTripsAndEventsPanel().setVisible(true);
	}

}
