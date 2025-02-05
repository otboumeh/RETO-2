package main.java.app.com.controllers;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AeropuertoDAO;
import main.java.app.com.database.models.Aeropuerto;
import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.panels.NewEventPanel;

public class NewEventPanelController {
	
    NewEventPanel newEventPanel = MainController.getInstance().getNewEventPanel();

    public NewEventPanelController() {
    	

    	newEventPanel.getBackButton().addActionListener(e -> backButton());
    	
    	CustomComboBox eventTypesCombo = newEventPanel.getEventTypesInput();
    	eventTypesCombo.addActionListener(e -> {
    	    String selectedItem = (String) eventTypesCombo.getSelectedItem();
    	    eventTypesCombo(selectedItem);
    	});
    	
    	CustomComboBox roundTripCombo =  newEventPanel.getFlightPanel().getTrajectory();
    	roundTripCombo.addActionListener(e -> {
    	    String selectedItem = (String) roundTripCombo.getSelectedItem();
    	    roundTripCombo(selectedItem);
    	});
    	
    	CustomComboBox originAirportsCombo = newEventPanel.getFlightPanel().getOrigin();
    	CustomComboBox DestinationAirportsCombo = newEventPanel.getFlightPanel().getDestination();

    	String[] newAirportsData = airportsGeneratorBD(); 
    	originAirportsCombo.setModel(new DefaultComboBoxModel<>(newAirportsData));
    	DestinationAirportsCombo.setModel(new DefaultComboBoxModel<>(newAirportsData));
    	
    }
   
    private void backButton() {
        MainController.getInstance().hideAllPanels();
        MainController.getInstance().getTripsAndEventsPanel().setVisible(true);
    }
    
    private void hideAllSubPanels() {
        MainController.getInstance().getNewEventPanel().getActivityPanel().setVisible(false);
        MainController.getInstance().getNewEventPanel().getFlightPanel().setVisible(false);
        MainController.getInstance().getNewEventPanel().getReturnFlightPanel().setVisible(false);
        MainController.getInstance().getNewEventPanel().getHotelPanel().setVisible(false);
    }
    
    private void eventTypesCombo(String selected) {
    	switch (selected) {
    	case "Vuelo":
    		hideAllSubPanels();
            MainController.getInstance().getNewEventPanel().getFlightPanel().setVisible(true);
    		break;
    	case "Hotel":
    		hideAllSubPanels();
            MainController.getInstance().getNewEventPanel().getHotelPanel().setVisible(true);
    		break;
    	case "Actividad":
    		hideAllSubPanels();
            MainController.getInstance().getNewEventPanel().getActivityPanel().setVisible(true);
    		break;
    	case "Elige una opción":
    		hideAllSubPanels();
    	}
    }

    private void roundTripCombo(String selected) {
    	switch (selected) {
    	case "Ida":
            MainController.getInstance().getNewEventPanel().getFlightPanel().setVisible(true);
            MainController.getInstance().getNewEventPanel().getReturnFlightPanel().setVisible(false);
    		break;
    	case "Ida-Vuelta":
            MainController.getInstance().getNewEventPanel().getFlightPanel().setVisible(true);
            MainController.getInstance().getNewEventPanel().getReturnFlightPanel().setVisible(true);
            break;
    	}
    }
    
    private String[] airportsGeneratorBD() {
    	String[] ret;
    	
    	AeropuertoDAO airportDAO = new AeropuertoDAO();
    	ArrayList<Aeropuerto> airports = airportDAO.getAllAirports();
    	ret = new String[airports.size()];
    	
    	for(Aeropuerto airport : airports) {
    		ret[airports.indexOf(airport)] = airport.getIdAeropuerto() + " - " + airport.getCiudad() + "";
    	}
    	
    	return ret;
    }

}
