package main.java.app.com.controllers;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.ActividadDAO;
import main.java.app.com.database.dao.AerolineaDAO;
import main.java.app.com.database.dao.AeropuertoDAO;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.dao.AlojamientoDAO;
import main.java.app.com.database.dao.PlanViajeDAO;
import main.java.app.com.database.dao.ViajeDAO;
import main.java.app.com.database.dao.VueloDAO;
import main.java.app.com.database.models.Actividad;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.database.models.Alojamiento;
import main.java.app.com.database.models.PlanViaje;
import main.java.app.com.database.models.Viaje;
import main.java.app.com.services.Service;
import main.java.app.com.textFile.TextFileManager;
import main.java.app.com.ui.panels.TripsAndEventsPanel;

public class TripsAndEventsPanelController {
	private TripsAndEventsPanel tripsAndEventsPanel = MainController.getInstance().getTripsAndEventsPanel();

	private AgenciaDAO agenciaDAO = new AgenciaDAO();
	private ViajeDAO viajeDAO = new ViajeDAO();
	private PlanViajeDAO planViajeDAO = new PlanViajeDAO();
	private AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
	private ActividadDAO actividadDAO = new ActividadDAO();
	private AerolineaDAO aerolineaDAO = new AerolineaDAO();

	
	private TextFileManager textFileManager = new TextFileManager();
	private Service service = new Service();

	private String idAgencia = null;
	private String idViaje = null;

	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	private ArrayList<String> rowTripIds = new ArrayList<String>();
	private ArrayList<String> rowEventIds = new ArrayList<String>();

	public TripsAndEventsPanelController() {
		tripsAndEventsPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				String userId = tripsAndEventsPanel.getUserId();
				String user = tripsAndEventsPanel.getUser();
				Agencia agencia = new Agencia();
				ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
				for (Agencia agency : agencias) {
					if (agency.getIdAgencia().equalsIgnoreCase(userId)) {
						agencia = agency;
						idAgencia = agencia.getIdAgencia();
						break;
					}
				}
				String colorMarca = agencia.getColorAgencia();
				tripsAndEventsPanel.getWelcomeTxt().setText("Welcome Back " + user + "!");
				tripsAndEventsPanel.getWelcomeTxt().setForeground(Color.decode(colorMarca));
				tripsAndEventsPanel.getPanelTitle().setForeground(Color.decode(colorMarca));

				service.changeImage(tripsAndEventsPanel.getLogoLabel(), agencia.getLogo());
				int tripsColNum = 6;

				showTrips();

				for (int i = 0; i < tripsColNum; i++) {
					tripsAndEventsPanel.getTripsTable().getColumnModel().getColumn(i).setPreferredWidth(131);
				}

				int eventsColNum = 4;
				for (int i = 0; i < eventsColNum; i++) {
					tripsAndEventsPanel.getEventsTable().getColumnModel().getColumn(i).setPreferredWidth(196);
				}

				showEvents();
			}
		});

		tripsAndEventsPanel.getNewEventButton().addActionListener(e -> newEventButton());
		tripsAndEventsPanel.getNewTripButton().addActionListener(e -> newTripButton());
		tripsAndEventsPanel.getSignOutButton().addActionListener(e -> signOutButton());
		tripsAndEventsPanel.getTripDeleteButton().addActionListener(e -> deleteTripButton());
		tripsAndEventsPanel.getEventDeleteButton().addActionListener(e -> deleteEventButton());
		tripsAndEventsPanel.getGenerateOfferButton().addActionListener(e -> generateOfferButton());
	}

	private void generateOfferButton() {
		String text = ofertaTxtGenerator();
		textFileManager.sobreescribirFichero(text);
		textFileManager.openFile();
	}

	private String ofertaTxtGenerator() {
		String ret = "";
		viajes = viajeDAO.getTripsByAgency(idAgencia);
		if (null != viajes) {
			for (Viaje viaje : viajes) {
				String titleViaje = "\n" + "------------------->> " + viaje.getNomViaje() + " <<-------------------"
						+ "\n" + "\n";
				String descViaje = "Descripción: " + "\n" + "          " + "Tipo de Viaje:      " + viaje.getTipoViaje()
						+ "\n" + "          " + "Fecha Inicio:       " + String.valueOf(viaje.getFechInicio()) + "\n"
						+ "          " + "Fecha Fin:          " + String.valueOf(viaje.getFechFin()) + "\n"
						+ "          " + "Numero de Días:     " + String.valueOf(viaje.getNumDias()) + "\n"
						+ "          " + "País Destino:       " + viaje.getPais() + "\n" + "          "
						+ "Descripción:        " + viaje.getDescripcion() + "\n" + "          " + "Servicios no Incl.: "
						+ viaje.getDescripcion() + "\n" + "\n" + "Eventos: " + "\n";
				String eventsList = eventsTextGenerator(viaje.getIdViaje());
				if (eventsList != "") {
					descViaje += eventsList;
				}else{
					descViaje += "***No hay ningún evento en este viaje***";
				}
				String seperator = "\n" + "-------------------------------------------------------------------------"
						+ "\n";

				ret += titleViaje + descViaje + seperator;
			}
		}

		return ret;
	}

	private String eventsTextGenerator(String tripId) {
		String ret = "";

		ArrayList<PlanViaje> planViajes = planViajeDAO.getPlanViajeByTrip(tripId);
		if (null != planViajes) {
			for (PlanViaje planViaje : planViajes) {
				String eventTitle = ">>>>> " + planViaje.getNomEvento() + "\n";
				String descEvento = "    " + "Descripción: " + "\n" +
									"                " + "Tipo de Evento:   " + planViaje.getTipoEvento() + "\n" +
									"                " + "Trayecto     :    " + planViaje.getTrayecto() + "\n" +
									"                " + "Fecha Ida:        " + String.valueOf(planViaje.getIda().getFechaIda()) + "\n" +
									"                " + "Aerolínea Ida:    " + aerolineaDAO.getAirlineByCod(planViaje.getIda().getAerolinea()).getNameAirline() + "\n";
				if(planViaje.getTrayecto().equalsIgnoreCase("Ida-Vuelta")) {
					descEvento +=    "                " + "Fecha Vuelta:    " + String.valueOf(planViaje.getVuelta().getFechaIda()) + "\n" +
									"                " + "Aerolínea Vuelta: " + aerolineaDAO.getAirlineByCod(planViaje.getVuelta().getAerolinea()).getNameAirline()  + "\n" +
									"                " + "Precio:           " + String.valueOf(planViaje.getIda().getPrecio() + planViaje.getVuelta().getPrecio()) + "\n"; 
				}else {
					descEvento += 	"                " + "Precio:           " + String.valueOf(planViaje.getIda().getPrecio()) + "\n";
				}
				
				ret += eventTitle + descEvento;
			}
		}

		ArrayList<Alojamiento> alojamientos = alojamientoDAO.getAlojamientoByTrip(tripId);
		if (null != alojamientos) {
			for (Alojamiento alojamiento : alojamientos) {
				String eventTitle = ">>>>> " + alojamiento.getNomEvento() + "\n";
				String descEvento = "    " + "Descripción: " + "\n" +
									"                " + "Tipo de Evento:     " + alojamiento.getTipoEvento() + "\n" +
									"                " + "Nombre del Hotel:   " + alojamiento.getNomHotel() + "\n" +
									"                " + "Tipo de Dormitorio: " + alojamiento.getTipoHab() + "\n" +
									"                " + "Ciudad:             " + alojamiento.getCiudad() + "\n" +
									"                " + "Fecha de Entrada:   " + String.valueOf(alojamiento.getFechaEnt()) + "\n" +
									"                " + "Fecha de Salida:    " + String.valueOf(alojamiento.getFechaSal()) + "\n" +
									"                " + "Precio:             " + String.valueOf(alojamiento.getPrecio()) + "\n";
				ret += eventTitle + descEvento;
			}
		}

		ArrayList<Actividad> actividades = actividadDAO.getActividadByTrip(tripId);
		if (null != actividades) {
			for (Actividad actividad : actividades) {
				String eventTitle = ">>>>> " + actividad.getNomEvento() + "\n";
				String descEvento = "    " + "Descripción: " + "\n" +
									"                " + "Tipo de Evento:   " + actividad.getTipoEvento() + "\n" +
									"                " + "Descripción:      " + actividad.getDescripcion() + "\n" +
									"                " + "Fecha:             " + String.valueOf(actividad.getFecha()) + "\n" +
									"                " + "Precio:           " + String.valueOf(actividad.getPrecio()) + "\n";
				ret += eventTitle + descEvento;
			}
		}
		
		return ret;
	}

	private void showTrips() {
		tripsAndEventsPanel.getTripsTableModel().setRowCount(0);

		viajes = viajeDAO.getTripsByAgency(idAgencia);
		rowTripIds.clear();
		if (null != viajes) {
			for (Viaje viaje : viajes) {
				String[] newRow = { viaje.getNomViaje(), viaje.getTipoViaje(), String.valueOf(viaje.getNumDias()),
						String.valueOf(viaje.getFechInicio()), String.valueOf(viaje.getFechFin()), viaje.getPais() };
				tripsAndEventsPanel.getTripsTableModel().addRow(newRow);
				rowTripIds.add(viaje.getIdViaje());
			}
		}
	}

	private void showEvents() {
		tripsAndEventsPanel.getTripsTable().setDefaultEditor(Object.class, null);
		tripsAndEventsPanel.getTripsTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tripsAndEventsPanel.getTripsTable().rowAtPoint(e.getPoint());
				if (row >= 0) {
					idViaje = rowTripIds.get(row);
					showEventsByTrip(idViaje);
				}
			}
		});
	}

	private void showEventsByTrip(String idViaje) {
		MainController.getInstance().getNewEventPanel().setIdViaje(idViaje);
		tripsAndEventsPanel.getEventsTableModel().setRowCount(0);
		rowEventIds.clear();

		ArrayList<PlanViaje> planViajes = planViajeDAO.getPlanViajeByTrip(idViaje);
		if (null != planViajes) {
			for (PlanViaje planViaje : planViajes) {
				String[] newRow = { planViaje.getNomEvento(), planViaje.getTipoEvento(),
						String.valueOf(planViaje.getIda().getFechaIda()), String
								.valueOf(planViaje.getIda().getPrecio()
										+ ((planViaje.getVuelta() != null) ? planViaje.getVuelta().getPrecio() : 0))
								+ " €" };
				tripsAndEventsPanel.getEventsTableModel().addRow(newRow);
				rowEventIds.add(planViaje.getIdEvento());
			}
		}

		ArrayList<Alojamiento> alojamientos = alojamientoDAO.getAlojamientoByTrip(idViaje);
		if (null != alojamientos) {
			for (Alojamiento alojamiento : alojamientos) {
				String[] newRow = { alojamiento.getNomEvento(), alojamiento.getTipoEvento(),
						String.valueOf(alojamiento.getFechaEnt()), String.valueOf(alojamiento.getPrecio()) + " €" };
				tripsAndEventsPanel.getEventsTableModel().addRow(newRow);
				rowEventIds.add(alojamiento.getIdEvento());
			}
		}

		ArrayList<Actividad> actividades = actividadDAO.getActividadByTrip(idViaje);
		if (null != actividades) {
			for (Actividad actividad : actividades) {
				String[] newRow = { actividad.getNomEvento(), actividad.getTipoEvento(),
						String.valueOf(actividad.getFecha()), String.valueOf(actividad.getPrecio()) + " €" };
				tripsAndEventsPanel.getEventsTableModel().addRow(newRow);
				rowEventIds.add(actividad.getIdEvento());
			}
		}
	}

	private void newEventButton() {
		int selectedRow = tripsAndEventsPanel.getTripsTable().getSelectedRow();
		if (selectedRow != -1) {
			MainController.getInstance().hideAllPanels();
			MainController.getInstance().getNewEventPanel().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Hay que elegir una viaje.");
		}
	}

	private void newTripButton() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getNewTripPanel().setVisible(true);
	}

	private void signOutButton() {
		MainController.getInstance().hideAllPanels();
		MainController.getInstance().getWelcomePanel().setVisible(true);
		tripsAndEventsPanel.getTripsTableModel().setRowCount(0);
		tripsAndEventsPanel.getEventsTableModel().setRowCount(0);
	}

	private void deleteTripButton() {
		int selectedRow = tripsAndEventsPanel.getTripsTable().getSelectedRow();
		if (selectedRow != -1) {
			idViaje = rowTripIds.get(selectedRow);
			viajeDAO.deleteTripById(idViaje);
			showTrips();
			showEventsByTrip(idViaje);
			JOptionPane.showMessageDialog(null, "Eliminado Correctamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Hay que elegir una viaje.");
		}
	}

	private void deleteEventButton() {
		int selectedRow = tripsAndEventsPanel.getEventsTable().getSelectedRow();
		if (selectedRow != -1) {
			String idEvento = rowEventIds.get(selectedRow);
			alojamientoDAO.deleteAlojamientoById(idEvento);
			planViajeDAO.deletePlanViajeById(idEvento);
			actividadDAO.deleteActividadById(idEvento);
			showEventsByTrip(idViaje);
			JOptionPane.showMessageDialog(null, "Eliminado Correctamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Hay que elegir un evento.");
		}
	}

}
