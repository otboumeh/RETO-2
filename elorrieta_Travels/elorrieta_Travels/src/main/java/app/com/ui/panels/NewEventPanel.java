package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomBackButton;
import main.java.app.com.ui.panels.newEventsSubpanels.ActivityPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.FlightPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.HotelPanel;
import main.java.app.com.ui.panels.newEventsSubpanels.ReturnFlightPanel;

/**
 * La clase de Panel del panel NewEvent
 * 
 * @author Grupo_01
 */
public class NewEventPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String[] eventTypes = { "Elige una opción", "Vuelo", "Alojamiento", "Actividad" };
	
	private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg/1920px-Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg";
	
	private Image logo;
	private ImageIcon logoIcon = new ImageIcon();
	private JLabel logoLabel = new JLabel();

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
	
	private String idViaje = null;
	private String userId = null;

	/**
	 * Constructor del panel con los componentes
	 */
	public NewEventPanel() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);
		
		try {
            URL url = new URL(imageUrl);
            logo = ImageIO.read(url);
            logoIcon = new ImageIcon(logo);
            logoLabel.setIcon(logoIcon);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
        }
		
    	logoLabel.setBounds(950, 0, 250, 250);
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
		layeredPane.add(logoLabel, Integer.valueOf(0));
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

	/**
	 * Obtiene el botón de retroceso.
	 * 
	 * @return `CustomBackButton` que permite regresar a la pantalla anterior.
	 */
	public CustomBackButton getBackButton() {
		return backButton;
	}

	/**
	 * Obtiene el panel de vuelos de ida.
	 * 
	 * @return `FlightPanel` que contiene la información del vuelo de ida.
	 */
	public FlightPanel getFlightPanel() {
		return flightPanel;
	}

	/**
	 * Obtiene el panel de vuelos de regreso.
	 * 
	 * @return `ReturnFlightPanel` que contiene la información del vuelo de regreso.
	 */
	public ReturnFlightPanel getReturnFlightPanel() {
		return returnFlightPanel;
	}

	/**
	 * Obtiene el panel de alojamiento.
	 * 
	 * @return `HotelPanel` que contiene la información del hotel.
	 */
	public HotelPanel getHotelPanel() {
		return hotelPanel;
	}

	/**
	 * Obtiene el panel de actividades.
	 * 
	 * @return `ActivityPanel` que contiene la información de la actividad seleccionada.
	 */
	public ActivityPanel getActivityPanel() {
		return activityPanel;
	}

	/**
	 * Obtiene el campo de entrada del nombre del evento.
	 * 
	 * @return `JTextField` donde se introduce el nombre del evento.
	 */
	public JTextField getEventNameInput() {
		return eventNameInput;
	}

	/**
	 * Obtiene el campo de selección del tipo de evento.
	 * 
	 * @return `CustomComboBox` que permite seleccionar el tipo de evento.
	 */
	public CustomComboBox getEventTypesInput() {
		return eventTypesInput;
	}
	/**
	 * Obtiene el identificador del usuario actual.
	 * 
	 * @return `String` que representa el ID del usuario.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Establece el identificador del usuario actual.
	 * 
	 * @param userId `String` que representa el ID del usuario.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Obtiene la etiqueta donde se muestra el logo de la agencia.
	 * 
	 * @return `JLabel` donde se carga la imagen del logo.
	 */
	public JLabel getLogoLabel() {
		return logoLabel;
	}

	/**
	 * Obtiene el identificador del viaje actual.
	 * 
	 * @return `String` que representa el ID del viaje.
	 */
	public String getIdViaje() {
		return idViaje;
	}

	/**
	 * Establece el identificador del viaje actual.
	 * 
	 * @param idViaje `String` que representa el ID del viaje.
	 */
	public void setIdViaje(String idViaje) {
		this.idViaje = idViaje;
	}
}
