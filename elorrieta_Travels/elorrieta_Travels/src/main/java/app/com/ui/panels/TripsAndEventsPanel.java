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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import main.java.app.com.ui.customComponents.customButtons.CustomDeleteButton;
import main.java.app.com.ui.customComponents.customButtons.CustomSignOutButton;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

/**
 * La clase de Panel del panel TripsAndEvents
 * 
 * @author Grupo_01
 */
public class TripsAndEventsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] tripsCulumns = { "Viaje", "Tipo", "Días", "Fecha Inicio", "Fecha Fin", "País" };
	private String[] eventsCulumns = { "Nombre Evento", "Tipo", "Fecha", "Precio" };

	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);

	private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg/1920px-Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg";
	private Image logo;
	private ImageIcon logoIcon = new ImageIcon();
	private JLabel logoLabel = new JLabel();

	private JLabel panelTitle = new JLabel("Viajes y Eventos");
	private JLabel welcomeTxt = new JLabel("hello");

	private JPanel tripsListPanel = new JPanel();;
	private DefaultTableModel tripsTableModel = new DefaultTableModel(tripsCulumns, 0);

	private JTable tripsTable = new JTable(tripsTableModel);
	private JTableHeader tripsHeader = tripsTable.getTableHeader();
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	private JScrollPane tripsScrollPane = new JScrollPane(tripsTable);

	//////// tabla de eventos

	private JPanel eventsListPanel = new JPanel();;
	private DefaultTableModel eventsTableModel = new DefaultTableModel(eventsCulumns, 0);

	private JTable eventsTable = new JTable(eventsTableModel);
	private JTableHeader eventsHeader = eventsTable.getTableHeader();
	private JScrollPane eventsScrollPane = new JScrollPane(eventsTable);
	//////////////

	private CustomUsualButton generateOfferButton = new CustomUsualButton("Generar Oferta");
	private CustomUsualButton newTripButton = new CustomUsualButton("Nuevo Viaje");
	private CustomUsualButton newEventButton = new CustomUsualButton("Nuevo Evento");
	private CustomSignOutButton signOutButton = new CustomSignOutButton("Desconectar");
	private CustomDeleteButton tripDeleteButton = new CustomDeleteButton();
	private CustomDeleteButton eventDeleteButton = new CustomDeleteButton();

	private String user = null;
	private String userId = null;

	private JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Constructor del panel con los componentes
	 */
	public TripsAndEventsPanel() {

		setLayout(null);
		setBounds(0, 0, 1200, 800);

		backgroundLabel.setBounds(0, 0, 1200, 800);

		try {
			URL url = new URL(imageUrl);
			logo = ImageIO.read(url);
			logoIcon = new ImageIcon(logo);
			logoLabel.setIcon(logoIcon);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
		}
		logoLabel.setBounds(1000, 0, 200, 200);

		panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
		panelTitle.setForeground(Color.BLACK);
		panelTitle.setBounds(0, 50, 950, 150);
		panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.setVerticalAlignment(SwingConstants.CENTER);

		welcomeTxt.setBounds(0, 0, 950, 100);
		welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeTxt.setVerticalAlignment(SwingConstants.CENTER);
		welcomeTxt.setForeground(Color.BLACK);
		welcomeTxt.setText(user);
		welcomeTxt.setFont(new Font("Arial", Font.BOLD, 20));

		///////////////// viajes
		tripsListPanel.setLayout(null);
		tripsHeader.setFont(new Font("Arial", Font.BOLD, 12));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < tripsTable.getColumnCount(); i++) {
			tripsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		tripsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		tripsScrollPane.setBounds(1, 0, 789, 200);
		tripsListPanel.setBounds(100, 200, 790, 200);
		tripsListPanel.add(tripsScrollPane);

		////////////// eventos
		eventsListPanel.setLayout(null);
		eventsHeader.setFont(new Font("Arial", Font.BOLD, 12));
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < eventsTable.getColumnCount(); i++) {
			eventsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		eventsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		eventsScrollPane.setBounds(1, 0, 789, 200);
		eventsListPanel.setBounds(100, 420, 790, 200);
		eventsListPanel.add(eventsScrollPane);

		generateOfferButton.setBounds(690, 670, 200, generateOfferButton.getHeight());
		newTripButton.setBounds(1020, 220, 150, generateOfferButton.getHeight());
		newEventButton.setBounds(1020, 270, 150, generateOfferButton.getHeight());
		signOutButton.setBounds(100, 670, 200, generateOfferButton.getHeight());
		tripDeleteButton.setBounds(900, 200, 30, 30);
		eventDeleteButton.setBounds(900, 420, 30, 30);

		layeredPane.setBounds(0, 0, 1200, 800);

		layeredPane.add(backgroundLabel, Integer.valueOf(0));
		layeredPane.add(welcomeTxt, Integer.valueOf(1));
		layeredPane.add(panelTitle, Integer.valueOf(1));
		layeredPane.add(logoLabel, Integer.valueOf(1));
		layeredPane.add(tripsListPanel, Integer.valueOf(1));
		layeredPane.add(eventsListPanel, Integer.valueOf(1));
		layeredPane.add(generateOfferButton, Integer.valueOf(1));
		layeredPane.add(newTripButton, Integer.valueOf(1));
		layeredPane.add(newEventButton, Integer.valueOf(1));
		layeredPane.add(signOutButton, Integer.valueOf(1));
		layeredPane.add(tripDeleteButton, Integer.valueOf(2));
		layeredPane.add(eventDeleteButton, Integer.valueOf(2));

		add(layeredPane);
		setVisible(true);
	}

	/**
	 * Obtiene la tabla de viajes.
	 *
	 * @return Retorna un `JTable` que muestra la lista de viajes registrados.
	 */
	public JTable getTripsTable() {
		return tripsTable;
	}

	/**
	 * Obtiene la etiqueta donde se muestra el logo de la agencia.
	 *
	 * @return Retorna un `JLabel` donde se carga la imagen del logo.
	 */
	public JLabel getLogoLabel() {
		return logoLabel;
	}

	/**
	 * Obtiene el nombre del usuario actual.
	 *
	 * @return Retorna un `String` con el nombre del usuario actual.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Obtiene el nombre del usuario y actualiza el mensaje de bienvenida.
	 *
	 * @param user `String` con el nombre del usuario.
	 */
	public void setUser(String user) {
		this.user = user;
		welcomeTxt.setText("Hello, " + user);
		repaint();
		revalidate();
	}

	/**
	 * Obtiene el Id del usuario actual.
	 *
	 * @return Retorna un `String` que representa el ID del usuario.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Obtiene el Id del usuario.
	 *
	 * @param userId `String` que representa el ID del usuario.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Obtiene la etiqueta del mensaje de bienvenida.
	 *
	 * @return Retorna un `JLabel` con el texto de bienvenida para el usuario.
	 */
	public JLabel getWelcomeTxt() {
		return welcomeTxt;
	}

	/**
	 * Obtiene el título del panel.
	 *
	 * @return Retorna un `JLabel` con el título del panel actual.
	 */
	public JLabel getPanelTitle() {
		return panelTitle;
	}

	/**
	 * Obtiene el modelo de datos de la tabla de viajes.
	 *
	 * @return Retorna un `DefaultTableModel` que maneja los datos de los viajes.
	 */
	public DefaultTableModel getTripsTableModel() {
		return tripsTableModel;
	}

	/**
	 * Obtiene el modelo de datos de la tabla de eventos.
	 *
	 * @return Retorna un `DefaultTableModel` que maneja los datos de los eventos.
	 */
	public DefaultTableModel getEventsTableModel() {
		return eventsTableModel;
	}

	/**
	 * Obtiene la tabla de eventos.
	 *
	 * @return Retorna un `JTable` que muestra la lista de eventos registrados.
	 */
	public JTable getEventsTable() {
		return eventsTable;
	}

	/**
	 * Obtiene el botón para crear un nuevo viaje.
	 *
	 * @return Retorna un `CustomUsualButton` que permite crear un nuevo viaje.
	 */
	public CustomUsualButton getNewTripButton() {
		return newTripButton;
	}

	/**
	 * Obtiene el botón para crear un nuevo evento.
	 *
	 * @return Retorna un `CustomUsualButton` que permite crear un nuevo evento.
	 */
	public CustomUsualButton getNewEventButton() {
		return newEventButton;
	}

	/**
	 * Obtiene el botón de cerrar sesión.
	 *
	 * @return Retorna un `CustomSignOutButton` que permite cerrar sesión del
	 *         sistema.
	 */
	public CustomSignOutButton getSignOutButton() {
		return signOutButton;
	}

	/**
	 * Obtiene el botón para eliminar un viaje.
	 *
	 * @return Retorna un `CustomDeleteButton` que permite eliminar un viaje
	 *         seleccionado.
	 */
	public CustomDeleteButton getTripDeleteButton() {
		return tripDeleteButton;
	}

	/**
	 * Obtiene el botón para eliminar un evento.
	 *
	 * @return Retorna un `CustomDeleteButton` que permite eliminar un evento
	 *         seleccionado.
	 */
	public CustomDeleteButton getEventDeleteButton() {
		return eventDeleteButton;
	}

	/**
	 * Obtiene el botón para generar una oferta.
	 *
	 * @return Retorna un `CustomUsualButton` que permite generar una oferta para el
	 *         usuario.
	 */
	public CustomUsualButton getGenerateOfferButton() {
		return generateOfferButton;
	}

}
