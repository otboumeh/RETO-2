package main.java.app.com.controllers;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.ActividadDAO;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.dao.AlojamientoDAO;
import main.java.app.com.database.dao.PlanViajeDAO;
import main.java.app.com.database.dao.ViajeDAO;
import main.java.app.com.database.models.Actividad;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.database.models.Alojamiento;
import main.java.app.com.database.models.PlanViaje;
import main.java.app.com.database.models.Viaje;
import main.java.app.com.ui.panels.TripsAndEventsPanel;

public class TripsAndEventsPanelController {
	TripsAndEventsPanel tripsAndEventsPanel = MainController.getInstance().getTripsAndEventsPanel();

	AgenciaDAO agenciaDAO = new AgenciaDAO();
	ViajeDAO viajeDAO = new ViajeDAO();
	PlanViajeDAO planViajeDAO = new PlanViajeDAO();
	AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
	ActividadDAO actividadDAO = new ActividadDAO();
	
	String idAgencia = null;
	String idViaje = null;

	ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	ArrayList<String> rowTripIds = new ArrayList<String>();
	ArrayList<String> rowEventIds = new ArrayList<String>();

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

				changeImage(tripsAndEventsPanel.getLogoLabel(), agencia.getLogo());
				int tripsColNum = 6;

				showTrips();

				for (int i = 0; i < tripsColNum; i++) {
					tripsAndEventsPanel.getTripsTable().getColumnModel().getColumn(i).setPreferredWidth(131);
				}

				int eventsColNum = 4;
				for (int i = 0; i < eventsColNum; i++) {
					tripsAndEventsPanel.getEventsTable().getColumnModel().getColumn(i).setPreferredWidth(196);
				}

				//////////////////// show events of a table
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
		});

		tripsAndEventsPanel.getNewEventButton().addActionListener(e -> newEventButton());
		tripsAndEventsPanel.getNewTripButton().addActionListener(e -> newTripButton());
		tripsAndEventsPanel.getSignOutButton().addActionListener(e -> signOutButton());
		tripsAndEventsPanel.getTripDeleteButton().addActionListener(e -> deleteTripButton());
		tripsAndEventsPanel.getEventDeleteButton().addActionListener(e -> deleteEventButton());
	}


	private ImageIcon resizeImageToLabel(JLabel label, Image image) {
		Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(resizedImage);
		return imageIcon;
	}

	private void changeImage(JLabel label, String imageUrl) {
		try {
			URL url = new URL(imageUrl);

			Image logo = ImageIO.read(url);

			ImageIcon logoIcon = resizeImageToLabel(label, logo);

			label.setIcon(logoIcon);

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
		}
	}

	private void showTrips() {
		tripsAndEventsPanel.getTripsTableModel().setRowCount(0);

		viajes = viajeDAO.getTripsByAgency(idAgencia);
		rowTripIds.clear();
		if(null!= viajes) {
			for (Viaje viaje : viajes) {
				String[] newRow = { viaje.getNomViaje(), viaje.getTipoViaje(), String.valueOf(viaje.getNumDias()),
						String.valueOf(viaje.getFechInicio()), String.valueOf(viaje.getFechFin()),
						viaje.getPais() };
				tripsAndEventsPanel.getTripsTableModel().addRow(newRow);
				rowTripIds.add(viaje.getIdViaje());
			}
		}
	}
	
	private void showEventsByTrip(String idViaje) {
		PlanViajeDAO planViajeDAO = new PlanViajeDAO();
		AlojamientoDAO alojamientoDAO = new AlojamientoDAO();
		ActividadDAO actividadDAO = new ActividadDAO();

		tripsAndEventsPanel.getEventsTableModel().setRowCount(0);
		rowEventIds.clear();

		ArrayList<PlanViaje> planViajes = planViajeDAO.getPlanViajeByTrip(idViaje);
		if(null!= planViajes) {
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
		if(null!= alojamientos) {
			for (Alojamiento alojamiento : alojamientos) {
				String[] newRow = { alojamiento.getNomEvento(), alojamiento.getTipoEvento(),
						String.valueOf(alojamiento.getFechaEnt()), String.valueOf(alojamiento.getPrecio()) + " €" };
				tripsAndEventsPanel.getEventsTableModel().addRow(newRow);
				rowEventIds.add(alojamiento.getIdEvento());
			}
		}	

		ArrayList<Actividad> actividades = actividadDAO.getActividadByTrip(idViaje);
		if(null!= actividades) {
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
