package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomBackButton;
import main.java.app.com.ui.panels.newEventsSubpanels.ActivityPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.FlightPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.HotelPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.ReturnFlightPanel;

public class NewEventPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String[] eventTypes = { "Elige una opción", "Vuelo", "Hotel", "Actividad" };

	private FlightPanel flightPanel = new FlightPanel();
	private ReturnFlightPanel returnFlightPanel = new ReturnFlightPanel();
	private HotelPanel hotelPanel = new HotelPanel();
	private ActivityPanel activityPanel = new ActivityPanel();

	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);

	private JLabel eventNameLabel = new JLabel("Nombre de evento");
	private JLabel eventTypesLabel = new JLabel("Tipo de evento");

	private JTextField eventNameInput = new JTextField();
	private CustomComboBox eventTypesInput = new CustomComboBox(eventTypes);
	private CustomBackButton backButton = new CustomBackButton("←");
	private JLayeredPane layeredPane = new JLayeredPane();

	public NewEventPanel() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		backgroundLabel.setBounds(0, 0, 1200, 800);

		eventNameLabel.setBounds(40, 90, 250, 40);
		eventNameLabel.setForeground(Color.BLACK);
		eventNameLabel.setFont(new Font("Arial", Font.BOLD, 20));

		eventTypesLabel.setBounds(40, 140, 250, 40);
		eventTypesLabel.setForeground(Color.BLACK);
		eventTypesLabel.setFont(new Font("Arial", Font.BOLD, 20));

		eventNameInput.setBounds(251, 90, 300, 40);
		eventTypesInput.setBounds(251, 140, 300, 40);
		
		activityPanel.setBounds(20, 180, flightPanel.getWidth(), activityPanel.getHeight());
		hotelPanel.setBounds(20, 180, hotelPanel.getWidth(), hotelPanel.getHeight());
		flightPanel.setBounds(20, 180, flightPanel.getWidth(), flightPanel.getHeight());
		returnFlightPanel.setBounds(600, 280, returnFlightPanel.getWidth(), returnFlightPanel.getHeight());

		backButton.setBounds(30, 30, 50, 30);

		layeredPane.setBounds(0, 0, 1200, 800);

		layeredPane.add(backgroundLabel, Integer.valueOf(0));
		layeredPane.add(eventNameLabel, Integer.valueOf(1));
		layeredPane.add(eventTypesLabel, Integer.valueOf(1));
		layeredPane.add(eventNameInput, Integer.valueOf(1));
		layeredPane.add(eventTypesInput, Integer.valueOf(1));
		layeredPane.add(flightPanel, Integer.valueOf(1));
		layeredPane.add(returnFlightPanel, Integer.valueOf(1));
		layeredPane.add(hotelPanel, Integer.valueOf(1));
		layeredPane.add(activityPanel, Integer.valueOf(1));
		layeredPane.add(backButton, Integer.valueOf(2));

		add(layeredPane);
		setVisible(true);
	}

	public CustomBackButton getBackButton() {
		return backButton;
	}

	public FlightPanel getFlightPanel() {
		return flightPanel;
	}

	public ReturnFlightPanel getReturnFlightPanel() {
		return returnFlightPanel;
	}

	public HotelPanel getHotelPanel() {
		return hotelPanel;
	}

	public ActivityPanel getActivityPanel() {
		return activityPanel;
	}

	public JTextField getEventNameInput() {
		return eventNameInput;
	}

	public CustomComboBox getEventTypesInput() {
		return eventTypesInput;
	}

}
