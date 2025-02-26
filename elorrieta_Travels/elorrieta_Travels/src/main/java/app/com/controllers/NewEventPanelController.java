package main.java.app.com.controllers;

import java.awt.Desktop;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.ActividadDAO;
import main.java.app.com.database.dao.AerolineaDAO;
import main.java.app.com.database.dao.AeropuertoDAO;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.dao.AlojamientoDAO;
import main.java.app.com.database.dao.PlanViajeDAO;
import main.java.app.com.database.dao.VueloDAO;
import main.java.app.com.database.models.Actividad;
import main.java.app.com.database.models.Aerolinea;
import main.java.app.com.database.models.Aeropuerto;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.database.models.Alojamiento;
import main.java.app.com.database.models.PlanViaje;
import main.java.app.com.database.models.Vuelo;
import main.java.app.com.services.Service;
import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;
import main.java.app.com.ui.panels.NewEventPanel;

/**
 * La clase ontrolador del la funcionalidad del panel (NewEventPanel).
 * 
 * - Manejar la selección de tipos de eventos. 
 * - Conectar el panel con la base de datos para registrar vuelos, hoteles y actividades. 
 * - Validar los campos de entrada. 
 * - Limpiar los campos de entrada. 
 * - Realizar búsquedas en línea de vuelos y hoteles. 
 * - levar al usuario al panel siguente o anterior.
 * 
 * @author Grupo_01
 */
public class NewEventPanelController {

	private NewEventPanel newEventPanel = MainController.getInstance().getNewEventPanel();
	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private VueloDAO vueloDAO = new VueloDAO();
	private AerolineaDAO aerolineaDAO = new AerolineaDAO();
	private PlanViajeDAO planViajeDAO = new PlanViajeDAO();
	private AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
	private ActividadDAO actividadDAO = new ActividadDAO();

	private String idViaje = null;
	private String idEvento = null;

	private Service service = new Service();

	private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	///////// ida
	private String selectedEventName = null;
	private String selectedEventType = null;
	private String selectedFlightTrajectoryIda = null;
	private String selectedFlightOriginIda = null;
	private String selectedFlightDestIda = null;
	private String selectedFlightDateIda = null;
	private String selectedFligtCodeIda = null;
	private String selectedAirlineIda = null;
	private String selectedPriceIda = null;
	private String selectedFlightTimeIda = null;
	private String selectedFlightDurationIda = null;

	////////// vuelta
	private String selectedDateRtn = null;
	private String selectedFlightIdRtn = null;
	private String selectedAirlineRtn = null;
	private String selectedPriceRtn = null;
	private String selectedTimeRtn = null;
	private String selectedDurationRtn = null;

	///////// hotel
	private String selectedHotelName = null;
	private String selectedCityHtl = null;
	private String selectedPriceHtl = null;
	private String selectedRoomTypesHtl = null;
	private String selectedCheckInHtl = null;
	private String selectedCheckOutHtl = null;

	//////// actividad
	private String SelectedDescAct = null;
	private String SelectedDateAct = null;
	private String SelectedPriceAct = null;

	/**
	 * Constructor que inicializa el controlador del panel NewEvenPanel.
	 * 
	 * Agrega un `ComponentListener` que actualiza el logo de agencia al mostrar el
	 * panel y configura los `ActionListener` para gestionar la selección de eventos
	 * y la navegación.
	 */
	public NewEventPanelController() {

		newEventPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				String userId = newEventPanel.getUserId();
				Agencia agencia = new Agencia();
				ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
				for (Agencia agency : agencias) {
					if (agency.getIdAgencia().equalsIgnoreCase(userId)) {
						agencia = agency;
						break;
					}
				}
				service.changeImage(newEventPanel.getLogoLabel(), agencia.getLogo());
			}
		});

		newEventPanel.getBackButton().addActionListener(e -> backButton());

		CustomComboBox eventTypesCombo = newEventPanel.getEventTypesInput();
		eventTypesCombo.addActionListener(e -> {
			selectedEventType = (String) eventTypesCombo.getSelectedItem();
			eventTypesCombo(selectedEventType);
		});

		CustomComboBox roundTripCombo = newEventPanel.getFlightPanel().getTrajectory();
		roundTripCombo.addActionListener(e -> {
			selectedFlightTrajectoryIda = (String) roundTripCombo.getSelectedItem();
			roundTripCombo(selectedFlightTrajectoryIda);
		});

		CustomComboBox originAirportsCombo = newEventPanel.getFlightPanel().getOrigin();
		originAirportsCombo.addActionListener(e -> {
			selectedFlightOriginIda = (String) originAirportsCombo.getSelectedItem();
			roundTripCombo(selectedFlightOriginIda);
		});

		CustomComboBox destinationAirportsCombo = newEventPanel.getFlightPanel().getDestination();
		destinationAirportsCombo.addActionListener(e -> {
			selectedFlightDestIda = (String) destinationAirportsCombo.getSelectedItem();
			roundTripCombo(selectedFlightDestIda);
		});

		String[] newAirportsData = airportsGeneratorBD();
		originAirportsCombo.setModel(new DefaultComboBoxModel<>(newAirportsData));
		destinationAirportsCombo.setModel(new DefaultComboBoxModel<>(newAirportsData));

		CustomComboBox airlineIda = newEventPanel.getFlightPanel().getAirline();
		CustomComboBox airlineRtn = newEventPanel.getReturnFlightPanel().getReturnAirlineInput();
		String[] newAirlinesData = airlinesGeneratorBD();
		airlineIda.setModel(new DefaultComboBoxModel<>(newAirlinesData));
		airlineRtn.setModel(new DefaultComboBoxModel<>(newAirlinesData));

		service.limitField(newEventPanel.getFlightPanel().getCode(), 5);

		service.limitField(newEventPanel.getReturnFlightPanel().getFlightIdInput(), 5);

		CustomUsualButton flightSearchButton = newEventPanel.getFlightPanel().getSearchButton();
		flightSearchButton.addActionListener(e -> flightSearchOnline(selectedFlightOriginIda, selectedFlightDestIda));

		CustomUsualButton hotelSearchButton = newEventPanel.getHotelPanel().getSearchButton();
		hotelSearchButton.addActionListener(e -> hotelSearchOnline());

		CustomUsualButton flightSaveButton = newEventPanel.getFlightPanel().getSaveButton();
		flightSaveButton.addActionListener(e -> flightSaveButton());

		CustomUsualButton hotelSaveButton = newEventPanel.getHotelPanel().getSaveButton();
		hotelSaveButton.addActionListener(e -> hotelSaveButton());

		CustomUsualButton activitySaveButton = newEventPanel.getActivityPanel().getSaveButton();
		activitySaveButton.addActionListener(e -> activitySaveButton());
	}

	/**
	 * Este método oculta todos los paneles y muestra el de viajes y eventos
	 * (TripsAndEventsPanel) Limpia los inputs de entrada del panel de vuelos de ida
	 * y vuelta
	 */
	private void backButton() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getTripsAndEventsPanel().setVisible(true);
		clearFlightPanelInputs();
		clearReturnFlightPanelInputs();
	}

	/**
	 * Maneja la seleccion de un tipo de evento en un combo, depende de la opcion
	 * seleccionada muestra el panel correspondiente y oculta los demas
	 * 
	 * @param selected el tipo de evento seleccionado: "Vuelo", "Alojamiento",
	 *                 "Actividad" o "Elige una opción"
	 */
	private void eventTypesCombo(String selected) {
		switch (selected) {
		case "Vuelo":
			MainController.getInstance().hideAllSubPanels();
			newEventPanel.getFlightPanel().setVisible(true);
			newEventPanel.getFlightPanel().getTrajectory().setSelectedIndex(0);

			break;
		case "Alojamiento":
			MainController.getInstance().hideAllSubPanels();
			newEventPanel.getHotelPanel().setVisible(true);
			break;
		case "Actividad":
			MainController.getInstance().hideAllSubPanels();
			newEventPanel.getActivityPanel().setVisible(true);
			break;
		case "Elige una opción":
			MainController.getInstance().hideAllSubPanels();
		}
	}

	/**
	 * Maneja la seleccion del tipo de vuelo. dependiendo de la opcion seleccionada
	 * muestra u oculta el panel de vuelo de vuelta y habilita o deshabilita el
	 * campo de precio
	 * 
	 * @param selected el tipo de viaje elegido (ida o ida y vuelta)
	 */
	private void roundTripCombo(String selected) {
		switch (selected) {
		case "Ida":
			newEventPanel.getFlightPanel().setVisible(true);
			newEventPanel.getReturnFlightPanel().setVisible(false);

			newEventPanel.getFlightPanel().getPrice().setText("");
			newEventPanel.getFlightPanel().getPrice().setEnabled(true);
			break;
		case "Ida-Vuelta":
			newEventPanel.getFlightPanel().setVisible(true);
			newEventPanel.getReturnFlightPanel().setVisible(true);

			newEventPanel.getFlightPanel().getPrice().setText("");
			newEventPanel.getFlightPanel().getPrice().setEnabled(false);
			break;
		}
	}

	/**
	 * Genera un array de cadenas con los datos de aeropuertos desde la bbdd El
	 * array incluye la opcion "elige una opcion" y los aeropuertos en formato "id -
	 * ciudad"
	 * 
	 * @return retorna un array de cadenas de los aeropuertos disponibles
	 */
	private String[] airportsGeneratorBD() {
		String[] ret;

		AeropuertoDAO airportDAO = new AeropuertoDAO();
		ArrayList<Aeropuerto> airports = airportDAO.getAllAirports();
		ret = new String[airports.size() + 1];
		ret[0] = "Elige una opcion";
		for (Aeropuerto airport : airports) {
			ret[airports.indexOf(airport) + 1] = airport.getIdAeropuerto() + " - " + airport.getCiudad() + "";
		}

		return ret;
	}

	/**
	 * Genera un array de cadenas con los datos de aerolineas desde la bbdd El array
	 * incluye la opcion "elige una opcion" y el nombre de las aerolineas
	 * 
	 * @return retorna un array de cadenas con las aerolineas disponibles
	 */
	private String[] airlinesGeneratorBD() {
		String[] ret;

		AerolineaDAO aerolineaDAO = new AerolineaDAO();
		ArrayList<Aerolinea> airlines = aerolineaDAO.getAllAirlines();
		ret = new String[airlines.size() + 1];
		ret[0] = "Elige una opcion";
		for (Aerolinea airline : airlines) {
			ret[airlines.indexOf(airline) + 1] = airline.getNameAirline() + "";
		}

		return ret;
	}

	/**
	 * Realiza una busqueda de vuelos en linea entre un origen y un destino en
	 * Skyscanner Valida que ambos (origen y destino) antes de crear el enlace Si
	 * alguno de los campos es incorrecto, muestra un mensaje de error
	 * 
	 * @param origin      El aeropuerto de origin
	 * @param destination El aeropuerto de destino
	 */
	private void flightSearchOnline(String origin, String destination) {

		if (origin != null && origin != "Elige una opcion" && destination != null
				&& destination != "Elige una opcion") {
			try {
				String originIata = service.getIataCode(origin).toLowerCase();
				String destinationIata = service.getIataCode(destination).toLowerCase();

				String url = String.format(
						"https://www.skyscanner.es/transporte/vuelos/%s/%s/?adultsv2=1&cabinclass=economy&childrenv2=&inboundaltsenabled=false&outboundaltsenabled=false&preferdirects=false&ref=home",
						URLEncoder.encode(originIata, StandardCharsets.UTF_8),
						URLEncoder.encode(destinationIata, StandardCharsets.UTF_8));

				URI website = new URI(url);

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().browse(website);
				} else {
					System.out.println("Desktop is not supported on this platform.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Hay que elegir el origen y el destino.", "Datos Insuficietes",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Abre el sitio web de Booking en el navegador
	 */
	private void hotelSearchOnline() {
		try {
			URI website = new URI("https://www.booking.com");

			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();

				desktop.browse(website);
			} else {
				System.out.println("Desktop is not supported on this platform.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Maneja el boton de guardar vuelo, dependiendo de la opcion seleccionada (Ida
	 * o IdayVuelta) valida los datos correspondientes y muestra un mensaje
	 * indicando que el evento se ha añadido correctamente Luego, limpia los inputs
	 * para los paneles de vuelo y vuelo de vuelta
	 */
	private void flightSaveButton() {
		CustomComboBox roundTripCombo = newEventPanel.getFlightPanel().getTrajectory();
		if (roundTripCombo.getSelectedItemText().equalsIgnoreCase("Ida-Vuelta")) {
			if (evaluateIdaVuelta()) {
				JOptionPane.showMessageDialog(null, "Evento añadido Correctamente.");
				clearFlightPanelInputs();
				clearReturnFlightPanelInputs();
			}
		} else {
			if (evaluateIda(0)) {
				JOptionPane.showMessageDialog(null, "Evento añadido Correctamente.");
				clearFlightPanelInputs();
			}
		}
	}

	/**
	 * Evalua si los datos ingresados para un vuelo de ida son correctos. En caso de
	 * datos correctos añade el vuelo a la base de datos y en caso contrario,
	 * muestra mensajes de error
	 * 
	 * @param price El precio del vuelo de ida
	 * @return Retorna `true` si los datos son validos y el vuelo se ha guardado
	 *         correctamente; `false` en caso contrario
	 */

	private boolean evaluateIda(int price) {
		boolean ret = false;
		CustomComboBox roundTripCombo = newEventPanel.getFlightPanel().getTrajectory();

		selectedEventName = newEventPanel.getEventNameInput().getText();
		selectedFlightTrajectoryIda = newEventPanel.getFlightPanel().getTrajectory().getSelectedItemText();
		selectedFlightOriginIda = newEventPanel.getFlightPanel().getOrigin().getSelectedItemText();
		selectedFlightDestIda = newEventPanel.getFlightPanel().getDestination().getSelectedItemText();

		java.util.Date flightDateIda = (java.util.Date) newEventPanel.getFlightPanel().getStartDateField().getDate();

		selectedFligtCodeIda = newEventPanel.getFlightPanel().getCode().getText();
		selectedAirlineIda = newEventPanel.getFlightPanel().getAirline().getSelectedItemText();
		selectedPriceIda = newEventPanel.getFlightPanel().getPrice().getText();

		java.util.Date leavingTime = (java.util.Date) newEventPanel.getFlightPanel().getLeavingTime().getValue();

		java.util.Date durationIda = (java.util.Date) newEventPanel.getFlightPanel().getDuration().getValue();

		if (selectedEventName.isEmpty() || selectedFlightTrajectoryIda.equalsIgnoreCase("Elige una opcion")
				|| selectedFlightOriginIda.equalsIgnoreCase("Elige una opcion")
				|| selectedFlightDestIda.equalsIgnoreCase("Elige una opcion") || flightDateIda == null
				|| selectedFligtCodeIda.isEmpty() || selectedAirlineIda.equalsIgnoreCase("Elige una opcion")
				|| (roundTripCombo.getSelectedItemText().equalsIgnoreCase("Ida") && selectedPriceIda.isEmpty())
				|| leavingTime == null || durationIda == null) {

			JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {
			java.sql.Date sqlflightDateIda = new java.sql.Date(flightDateIda.getTime());
			selectedFlightDateIda = dateFormat.format(sqlflightDateIda);

			java.sql.Time sqlLeavingTime = new java.sql.Time(leavingTime.getTime());
			selectedFlightTimeIda = timeFormat.format(sqlLeavingTime);

			java.sql.Time sqlDuration = new java.sql.Time(durationIda.getTime());
			selectedFlightDurationIda = timeFormat.format(sqlDuration);

			if (!service.isDate(selectedFlightDateIda)) {
				JOptionPane.showMessageDialog(null, "Fecha Ida Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (isDuplicate(selectedFligtCodeIda)) {
				JOptionPane.showMessageDialog(null, "El Codigo de vuelo de ida es repetitivo", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (selectedFligtCodeIda.length() < 5) {
				JOptionPane.showMessageDialog(null, "El Codigo de vuelo una combinacion de 5 letras y numeros ",
						"Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
			} else if (roundTripCombo.getSelectedItemText().equalsIgnoreCase("Ida")
					&& !service.isNumber(selectedPriceIda)) {
				JOptionPane.showMessageDialog(null, "Precio Ida Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isTime(selectedFlightTimeIda)) {
				JOptionPane.showMessageDialog(null, "Horario Salida Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isTime(selectedFlightDurationIda)) {
				JOptionPane.showMessageDialog(null, "Dutacion Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else {
				selectedPriceIda = roundTripCombo.getSelectedItemText().equalsIgnoreCase("Ida-Vuelta")
						? String.valueOf(price)
						: selectedPriceIda;
				String idAirline = aerolineaDAO.getAirlineByName(selectedAirlineIda).getCodAirline();
				Vuelo vuelo = createNewFlight(selectedFligtCodeIda, sqlflightDateIda, idAirline, sqlLeavingTime,
						sqlDuration, service.getIataCode(selectedFlightOriginIda),
						service.getIataCode(selectedFlightDestIda), Integer.valueOf(selectedPriceIda));
				vueloDAO.addFlightToDB(vuelo);

				idViaje = newEventPanel.getIdViaje();
				idEvento = service.incrementString(getIdLastEvento());

				PlanViaje planViaje = createNewPlanViaje(idEvento, selectedEventName,
						newEventPanel.getEventTypesInput().getSelectedItemText(), selectedFlightTrajectoryIda, vuelo,
						null);
				planViajeDAO.addPlanViajeByIdViaje(planViaje, idViaje);
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Evalua si los datos de un vuelo de ida y vuelta son validos y los registra en
	 * la bbdd si cumplen con los requisitos.
	 * 
	 * @return Retorna true si el vuelo de vuelta es valido y se registra
	 *         correctamente; `false` en caso contrario
	 */
	private boolean evaluateIdaVuelta() {
		boolean ret = false;

		java.util.Date flightDateIda = (java.util.Date) newEventPanel.getFlightPanel().getStartDateField().getDate();

		selectedFlightOriginIda = newEventPanel.getFlightPanel().getOrigin().getSelectedItemText();
		selectedFlightDestIda = newEventPanel.getFlightPanel().getDestination().getSelectedItemText();
		selectedFligtCodeIda = newEventPanel.getFlightPanel().getCode().getText();

		/// vuelta
		java.util.Date dateRtn = (java.util.Date) newEventPanel.getReturnFlightPanel().getDateChooserReturn().getDate();

		selectedFlightIdRtn = newEventPanel.getReturnFlightPanel().getFlightIdInput().getText();
		selectedAirlineRtn = newEventPanel.getReturnFlightPanel().getReturnAirlineInput().getSelectedItemText();
		selectedPriceRtn = newEventPanel.getReturnFlightPanel().getTotalPriceInput().getText();

		java.util.Date timeRtn = (java.util.Date) newEventPanel.getReturnFlightPanel().getReturnTimeInput().getValue();

		java.util.Date durationRtn = (java.util.Date) newEventPanel.getReturnFlightPanel().getReturnDurationInput()
				.getValue();

		if (dateRtn == null || flightDateIda == null || selectedFlightIdRtn.equalsIgnoreCase("Elige una opcion")
				|| selectedAirlineRtn.equalsIgnoreCase("Elige una opcion") || selectedPriceRtn.isEmpty()
				|| timeRtn == null || durationRtn == null) {

			JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {

			java.sql.Date sqlDateRtn = new java.sql.Date(dateRtn.getTime());
			selectedDateRtn = dateFormat.format(sqlDateRtn);

			java.sql.Time sqlTimeRtn = new java.sql.Time(timeRtn.getTime());
			selectedTimeRtn = timeFormat.format(sqlDateRtn);

			java.sql.Time sqlDurationRtn = new java.sql.Time(durationRtn.getTime());
			selectedDurationRtn = timeFormat.format(sqlDurationRtn);

			if (!service.isDate(selectedDateRtn)) {
				JOptionPane.showMessageDialog(null, "Fecha Vuelta Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (flightDateIda.after(dateRtn)) {
				JOptionPane.showMessageDialog(null, "Fecha Vuelta no puede ser Antes de Ida", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isNumber(selectedPriceRtn)) {
				JOptionPane.showMessageDialog(null, "Precio Total Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (isDuplicate(selectedFlightIdRtn)) {
				JOptionPane.showMessageDialog(null, "El Codigo de vuelo de Vuelta es repetitivo", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (selectedFlightIdRtn.length() < 5) {
				JOptionPane.showMessageDialog(null, "El Codigo de vuelo una combinacion de 5 letras y numeros ",
						"Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
			} else if (selectedFlightIdRtn.equalsIgnoreCase(selectedFligtCodeIda)) {
				JOptionPane.showMessageDialog(null, "Los Codigos de Vuelos no pueden ser iguales", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isTime(selectedTimeRtn)) {
				JOptionPane.showMessageDialog(null, "Horario de Vuelta Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isTime(selectedDurationRtn)) {
				JOptionPane.showMessageDialog(null, "Dutacion de Vuelta Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int precioPorVuelo = Integer.valueOf(selectedPriceRtn) / 2;
				if (evaluateIda(precioPorVuelo)) {
					String idAirlineDest = aerolineaDAO.getAirlineByName(selectedAirlineRtn).getCodAirline();
					Vuelo vueloVuelta = createNewFlight(selectedFlightIdRtn, sqlDateRtn, idAirlineDest, sqlTimeRtn,
							sqlDurationRtn, service.getIataCode(selectedFlightDestIda),
							service.getIataCode(selectedFlightOriginIda), precioPorVuelo);
					vueloDAO.addFlightToDB(vueloVuelta);

					planViajeDAO.modifyReturnFlight(idEvento, selectedFlightIdRtn);

					ret = true;
				}
			}
		}
		return ret;
	}

	/**
	 * Verifica si un codigo de vuelo ya existe en la bbdd.
	 * 
	 * @param flightCode Codigo del vuelo
	 * @return Retorna ´true´ si el codigo de vuelo ya existe, ´false´ en caso
	 *         contrario
	 */
	private boolean isDuplicate(String flightCode) {
		boolean ret = false;
		ArrayList<Vuelo> vuelos = vueloDAO.getAllFlights();
		for (Vuelo vuelo : vuelos) {
			if (vuelo.getIdVuelo().equalsIgnoreCase(flightCode)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Limpia todos los inputs del panel de vuelo, restableciendo los valores por
	 * defecto
	 */
	private void clearFlightPanelInputs() {
		newEventPanel.getEventNameInput().setText("");

		newEventPanel.getFlightPanel().getOrigin().setSelectedIndex(0);
		newEventPanel.getFlightPanel().getDestination().setSelectedIndex(0);
		newEventPanel.getFlightPanel().getStartDateField().setDate(null);
		newEventPanel.getFlightPanel().getCode().setText("");
		newEventPanel.getFlightPanel().getAirline().setSelectedIndex(0);
		newEventPanel.getFlightPanel().getPrice().setText("");
		service.spinnerReseter(newEventPanel.getFlightPanel().getLeavingTime());
		service.spinnerReseter(newEventPanel.getFlightPanel().getDuration());
	}

	/**
	 * Limpia todos los inputs del panel de vuelo vuelta, restableciendo los valores
	 * por defecto
	 */
	private void clearReturnFlightPanelInputs() {
		newEventPanel.getReturnFlightPanel().getDateChooserReturn().setDate(null);
		newEventPanel.getReturnFlightPanel().getFlightIdInput().setText("");
		newEventPanel.getReturnFlightPanel().getReturnAirlineInput().setSelectedIndex(0);
		newEventPanel.getReturnFlightPanel().getTotalPriceInput().setText("");
		service.spinnerReseter(newEventPanel.getReturnFlightPanel().getReturnTimeInput());
		service.spinnerReseter(newEventPanel.getReturnFlightPanel().getReturnDurationInput());
	}

	/**
	 * Crea un nuevo objeto de tipo Vuelo con los datos proporcionados
	 * 
	 * @param idVuelo    Id del vuelo
	 * @param fechaIda   Fecha de salida del vuelo
	 * @param aerolinea  Codigo de la aerolinea del vuelo
	 * @param horarioSal Hora de salida del vuelo
	 * @param duracion   Duracion del vuelo
	 * @param aeroOrig   Codigo IATA del aeropuerto de origen
	 * @param aeroDest   Codigo IATA del aeropuerto de destino
	 * @param precio     Precio del vuelo
	 * 
	 * @return Retorna un objeto ´Vuelo´ con los valores asignados
	 */
	private Vuelo createNewFlight(String idVuelo, Date fechaIda, String aerolinea, Time horarioSal, Time duracion,
			String aeroOrig, String aeroDest, int precio) {
		Vuelo ret = new Vuelo();
		ret.setIdVuelo(idVuelo);
		ret.setFechaIda(fechaIda);
		ret.setAerolinea(aerolinea);
		ret.setHorarioSalida(horarioSal);
		ret.setDuracion(duracion);
		ret.setIdAeroOrigen(aeroOrig);
		ret.setIdAeroDestino(aeroDest);
		ret.setPrecio(precio);
		return ret;
	}

	/**
	 * Crea un nuevo objeto de tipo ´PlanViaje´ con los datos proporcionados
	 * 
	 * @param idEvento   Id unico del evento
	 * @param nomEvento  Nombre del evento
	 * @param tipoEvento Tipo de evento (ejemplo: Vuelo, alojamiento o actividad.)
	 * @param trayecto   Descripcion del trayecto del viaje
	 * @param ida        Objeto ´Vuelo´ de ida
	 * @param vuelta     Objeto ´Vuelo´ de vuelta
	 * @return Retorna un objeto ´PlanViaje´ con los valores asignados
	 */
	private PlanViaje createNewPlanViaje(String idEvento, String nomEvento, String tipoEvento, String trayecto,
			Vuelo ida, Vuelo vuelta) {
		PlanViaje ret = new PlanViaje();
		ret.setIdEvento(idEvento);
		ret.setNomEvento(nomEvento);
		ret.setTipoEvento(tipoEvento);
		ret.setTrayecto(trayecto);
		ret.setIda(ida);
		ret.setVuelta(vuelta);
		return ret;
	}

	/**
	 * Limpia todos los inputs del panel de hotel, restableciendo los valores por
	 * defecto
	 */
	private void clearHotelPanelInputs() {
		newEventPanel.getEventNameInput().setText("");

		newEventPanel.getHotelPanel().getHotelNameInput().setText("");
		newEventPanel.getHotelPanel().getRoomTypesInput().setSelectedIndex(0);
		newEventPanel.getHotelPanel().getCityInput().setText("");
		newEventPanel.getHotelPanel().getPriceInput().setText("");
		newEventPanel.getHotelPanel().getDateCheckIn().setDate(null);
		newEventPanel.getHotelPanel().getDateCheckOut().setDate(null);
	}

	/**
	 * Guarda la informacion del evento de hotel si pasa la evaluacion. Muestra un
	 * mensaje de éxito y limpia los inputs del panel de hotel
	 */
	private void hotelSaveButton() {
		if (hotelEvaluator()) {
			JOptionPane.showMessageDialog(null, "Evento añadido Correctamente.");
			clearHotelPanelInputs();
		}
	}

	/**
	 * Evalua la validez de los datos del evento de hotel y realiza el registro en
	 * la bbdd si son correctos
	 * 
	 * @return Retorna ´true´ si los datos son validos y se guardan correctamente;
	 *         ´false´ en caso contrario.
	 */
	private boolean hotelEvaluator() {
		boolean ret = false;
		selectedEventName = newEventPanel.getEventNameInput().getText();
		selectedEventType = newEventPanel.getEventTypesInput().getSelectedItemText();
		selectedHotelName = newEventPanel.getHotelPanel().getHotelNameInput().getText();
		selectedRoomTypesHtl = newEventPanel.getHotelPanel().getRoomTypesInput().getSelectedItemText();
		selectedCityHtl = newEventPanel.getHotelPanel().getCityInput().getText();
		selectedPriceHtl = newEventPanel.getHotelPanel().getPriceInput().getText();

		java.util.Date checkInDate = (java.util.Date) newEventPanel.getHotelPanel().getDateCheckIn().getDate();

		java.util.Date checkOutDate = (java.util.Date) newEventPanel.getHotelPanel().getDateCheckOut().getDate();

		if (selectedEventName.isEmpty() || selectedEventType.equalsIgnoreCase("Elige una opcion")
				|| selectedRoomTypesHtl.equals("Elige una opcion") || selectedCityHtl.isEmpty()
				|| selectedPriceHtl.isEmpty() || checkInDate == null || checkOutDate == null) {

			JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {

			java.sql.Date sqlCheckInDate = new java.sql.Date(checkInDate.getTime());
			selectedCheckInHtl = dateFormat.format(sqlCheckInDate);

			java.sql.Date sqlCheckOutDate = new java.sql.Date(checkOutDate.getTime());
			selectedCheckOutHtl = dateFormat.format(sqlCheckOutDate);

			if (!service.isDate(selectedCheckInHtl)) {
				JOptionPane.showMessageDialog(null, "Fecha de Entrada Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (sqlCheckOutDate.before(checkInDate)) {
				JOptionPane.showMessageDialog(null, "La Fecha de Salida no puede ser antes de la Fecha de Entrada",
						"Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
			} else if (!service.isDate(selectedCheckOutHtl)) {
				JOptionPane.showMessageDialog(null, "Fecha Salida Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isNumber(selectedPriceHtl)) {
				JOptionPane.showMessageDialog(null, "Precio Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else {
				idViaje = newEventPanel.getIdViaje();
				idEvento = service.incrementString(getIdLastEvento());

				Alojamiento alojamiento = createNewAlojamiento(idEvento, selectedEventName, selectedEventType,
						selectedHotelName, selectedRoomTypesHtl, selectedCityHtl, Integer.valueOf(selectedPriceHtl),
						sqlCheckInDate, sqlCheckOutDate);
				alojamientoDAO.addAlojamientoByIdViaje(alojamiento, idViaje);

				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Crea un nuevo objeto de tipo ´Alojamiento´ con los datos proporcionados
	 * 
	 * @param idEvento   Id del evento
	 * @param nomEvento  Nombre del evento
	 * @param tipoEvento Tipo de evento
	 * @param nomHotel   Nombre del hotel
	 * @param tipoHab    Tipo de habitacion del hotel
	 * @param ciudad     Ciudad donde se encuentra el hotel
	 * @param precio     Precio del alojamiento
	 * @param entrada    Fecha de entrada al alojamiento
	 * @param salida     Fecha de salida del alojamiento
	 * @return Retorna un objeto ´Alojamiento´ con los valores asignados
	 */
	private Alojamiento createNewAlojamiento(String idEvento, String nomEvento, String tipoEvento, String nomHotel,
			String tipoHab, String ciudad, int precio, Date entrada, Date salida) {
		Alojamiento ret = new Alojamiento();
		ret.setIdEvento(idEvento);
		ret.setNomEvento(nomEvento);
		ret.setTipoEvento(tipoEvento);
		ret.setNomHotel(nomHotel);
		ret.setTipoHab(tipoHab);
		ret.setCiudad(ciudad);
		ret.setPrecio(precio);
		ret.setFechaEnt(entrada);
		ret.setFechaSal(salida);
		return ret;
	}

	/**
	 * Limpia todos los inputs del panel actividad, restableciendo los valores por
	 * defecto
	 */
	private void clearActivityPanelInputs() {
		newEventPanel.getEventNameInput().setText("");

		newEventPanel.getActivityPanel().getDescriptionInput().setText("");
		newEventPanel.getActivityPanel().getDateInput().setDate(null);
		;
		newEventPanel.getActivityPanel().getPriceInput().setText("");
	}

	/**
	 * Guarda la informacion del evento de actividad si pasa la evaluacion. Muestra
	 * un mensaje de exito y limpia los inputs del panel de actividad
	 */
	private void activitySaveButton() {
		if (activityEvaluator()) {
			JOptionPane.showMessageDialog(null, "Evento añadido Correctamente.");
			clearActivityPanelInputs();
		}
	}

	/**
	 * Evalua la validez de los datos de actividad y realiza el registro en la bbdd
	 * si son correctos
	 * 
	 * @return Retorna ´true´ si los datos son validos y se guardan correctamente,
	 *         ´false´ en caso contrario.
	 */
	private boolean activityEvaluator() {
		boolean ret = false;
		selectedEventName = newEventPanel.getEventNameInput().getText();
		selectedEventType = newEventPanel.getEventTypesInput().getSelectedItemText();
		SelectedDescAct = newEventPanel.getActivityPanel().getDescriptionInput().getText();

		java.util.Date activityDate = (java.util.Date) newEventPanel.getActivityPanel().getDateInput().getDate();

		SelectedPriceAct = newEventPanel.getActivityPanel().getPriceInput().getText();

		if (selectedEventName.isEmpty() || selectedEventType.equalsIgnoreCase("Elige una opcion")
				|| SelectedDescAct.isEmpty() || activityDate == null || SelectedPriceAct.isEmpty()) {

			JOptionPane.showMessageDialog(null, "No se pueden dejar campos vacios!", "Datos Incorrectos",
					JOptionPane.ERROR_MESSAGE);
		} else {

			java.sql.Date sqlactivityDate = new java.sql.Date(activityDate.getTime());
			SelectedDateAct = dateFormat.format(sqlactivityDate);

			if (!service.isDate(SelectedDateAct)) {
				JOptionPane.showMessageDialog(null, "Fecha de Entrada Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else if (!service.isNumber(SelectedPriceAct)) {
				JOptionPane.showMessageDialog(null, "Precio Incorrecto", "Datos Incorrectos",
						JOptionPane.ERROR_MESSAGE);
			} else {
				idViaje = newEventPanel.getIdViaje();
				idEvento = service.incrementString(getIdLastEvento());

				Actividad actividad = createNewActividad(idEvento, selectedEventName, selectedEventType,
						SelectedDescAct, sqlactivityDate, Integer.valueOf(SelectedPriceAct));
				actividadDAO.addActividadByIdViaje(actividad, idViaje);
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Crea un nuevo objeto de tipo ´Actividad´ con los datos proporcionados
	 * 
	 * @param idEvento    Id único del evento
	 * @param nomEvento   Nombre del evento
	 * @param tipoEvento  Tipo de evento
	 * @param descripcion Descripcion de la actividad.
	 * @param fecha       Fecha en que se realiza la actividad.
	 * @param precio      Precio de la actividad.
	 * @return Retorna un objeto ´Actividad´ con los valores asignados.
	 */
	private Actividad createNewActividad(String idEvento, String nomEvento, String tipoEvento, String descripcion,
			Date fecha, int precio) {
		Actividad ret = new Actividad();
		ret.setIdEvento(idEvento);
		ret.setNomEvento(nomEvento);
		ret.setTipoEvento(tipoEvento);
		ret.setDescripcion(descripcion);
		ret.setFecha(fecha);
		ret.setPrecio(precio);
		return ret;
	}

	/**
	 * Obtiene el ultimo identificador de evento de los registros de PlanViaje,
	 * Alojamiento y Actividad
	 * 
	 * @return Retorna el Id del ultimo evento registrado en cualquiera de las tres
	 *         listas (PlanViaje, Alojamiento, Actividad) Si no hay registros,
	 *         retorna null.
	 */
	private String getIdLastEvento() {
		String ret = null;
		ArrayList<PlanViaje> planViajes = planViajeDAO.getAllPlanViajes();
		ArrayList<Alojamiento> alojamientos = alojamientoDAO.getAllAlojamientos();
		ArrayList<Actividad> actividades = actividadDAO.getAllActividades();

		String lastPlan = !planViajes.isEmpty() ? planViajes.get(planViajes.size() - 1).getIdEvento() : null;
		String lastHotel = !alojamientos.isEmpty() ? alojamientos.get(alojamientos.size() - 1).getIdEvento() : null;
		String lastAct = !actividades.isEmpty() ? actividades.get(actividades.size() - 1).getIdEvento() : null;

		ret = service.getMaxId(lastPlan, lastHotel, lastAct);
		return ret;
	}

}
