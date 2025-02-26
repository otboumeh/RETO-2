package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomBackButton;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

/**
 * La clase de Panel del panel NewTrip
 * 
 * @author Grupo_01
 */
public class NewTripPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] countries = { "España", "Francia", "Italia", "Alemania", "Reino Unido" };
	private String[] tripTypes = { "Elige una opcion", "Parejas", "Mayores", "Grupos",
			"Grandes viajes (destinos exoticos + vuelo + alojamiento)", "Escapada" };

	private String userId = null;

	private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg/1920px-Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg";
	private Image logo;
	private ImageIcon logoIcon = new ImageIcon();
	private JLabel logoLabel = new JLabel();

	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel nameLabel = new JLabel("Nombre de viaje");
	private JLabel typeLabel = new JLabel("Tipo de viaje");
	private JLabel startLabel = new JLabel("Inicio de viaje");
	private JLabel endLabel = new JLabel("Fin de viaje");
	private JLabel daysLabel = new JLabel("Duracion en Dias");
	private JLabel countryLabel = new JLabel("Pais");
	private JLabel descriptionLabel = new JLabel("Descripcion");
	private JLabel servicesLabel = new JLabel("Servicios no incl");

	private JTextField nameField = new JTextField();
	private CustomComboBox typeField = new CustomComboBox(tripTypes);
	private JDateChooser startDateField = new JDateChooser();
	private JDateChooser endDateField = new JDateChooser();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private JTextField daysField = new JTextField();

	private CustomComboBox countryComboBox = new CustomComboBox(countries);

	private JTextArea descriptionArea = new JTextArea();
	private JScrollPane descriptionScroll = new JScrollPane(descriptionArea);

	private JTextArea servicesArea = new JTextArea();
	private JScrollPane servicesScroll = new JScrollPane(servicesArea);

	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");
	private CustomBackButton backButton = new CustomBackButton("←");

	private JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Constructor del panel con los componentes
	 */
	public NewTripPanel() {
		setLayout(null);
		setBounds(0, 0, 1200, 800);

		backgroundLabel.setBounds(0, 0, 1200, 800);
		layeredPane.setBounds(0, 0, 1200, 800);

		try {
			URL url = new URL(imageUrl);
			logo = ImageIO.read(url);
			logoIcon = new ImageIcon(logo);
			logoLabel.setIcon(logoIcon);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
		}

		logoLabel.setBounds(1050, 0, 150, 150);

		int centerX = 50;
		int startY = 200;
		int labelWidth = 200;
		int labelHeight = 40;
		int verticalSpacing = 10;

		nameLabel.setBounds(centerX, startY, labelWidth, labelHeight);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

		typeLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		typeLabel.setForeground(Color.BLACK);
		typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

		startLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		startLabel.setForeground(Color.BLACK);
		startLabel.setFont(new Font("Arial", Font.BOLD, 20));

		endLabel.setBounds(centerX, startY + 3 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		endLabel.setForeground(Color.BLACK);
		endLabel.setFont(new Font("Arial", Font.BOLD, 20));

		daysLabel.setBounds(centerX, startY + 4 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		daysLabel.setForeground(Color.BLACK);
		daysLabel.setFont(new Font("Arial", Font.BOLD, 20));

		countryLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		countryLabel.setForeground(Color.BLACK);
		countryLabel.setFont(new Font("Arial", Font.BOLD, 20));

		descriptionLabel.setBounds(centerX + 560, startY, labelWidth, labelHeight);
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));

		servicesLabel.setBounds(centerX + 560, startY + 3 * (labelHeight + verticalSpacing), 300, labelHeight);
		servicesLabel.setForeground(Color.BLACK);
		servicesLabel.setFont(new Font("Arial", Font.BOLD, 20));

		nameField.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		typeField.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
		startDateField.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		startDateField.setDateFormatString(dateFormat.toPattern());
		startDateField.setMinSelectableDate(new java.util.Date());

		endDateField.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		endDateField.setDateFormatString(dateFormat.toPattern());
		endDateField.setMinSelectableDate(new java.util.Date());

		daysField.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300, labelHeight);
		daysField.setEditable(false);

		countryComboBox.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		descriptionScroll.setBounds(centerX + labelWidth + 570, startY, 300, 140);
		servicesScroll.setBounds(centerX + labelWidth + 570, startY + 3 * (labelHeight + verticalSpacing), 300, 140);

		backButton.setBounds(30, 30, 50, 30);

		saveButton.setBounds(525, 550, saveButton.getWidth(), saveButton.getHeight());

		layeredPane.add(logoLabel, Integer.valueOf(0));
		layeredPane.add(backgroundLabel, Integer.valueOf(0));
		layeredPane.add(nameLabel, Integer.valueOf(1));
		layeredPane.add(typeLabel, Integer.valueOf(1));
		layeredPane.add(startLabel, Integer.valueOf(1));
		layeredPane.add(endLabel, Integer.valueOf(1));
		layeredPane.add(daysLabel, Integer.valueOf(1));
		layeredPane.add(countryLabel, Integer.valueOf(1));
		layeredPane.add(descriptionLabel, Integer.valueOf(1));
		layeredPane.add(servicesLabel, Integer.valueOf(1));

		layeredPane.add(countryComboBox, Integer.valueOf(1));
		layeredPane.add(daysField, Integer.valueOf(1));
		layeredPane.add(endDateField, Integer.valueOf(1));
		layeredPane.add(typeField, Integer.valueOf(1));
		layeredPane.add(nameField, Integer.valueOf(1));
		layeredPane.add(startDateField, Integer.valueOf(1));
		layeredPane.add(servicesScroll, Integer.valueOf(1));
		layeredPane.add(descriptionScroll, Integer.valueOf(1));

		layeredPane.add(saveButton, Integer.valueOf(1));
		layeredPane.add(backButton, Integer.valueOf(1));

		add(layeredPane);
		setVisible(true);
	}

	/**
	 * Obtiene el campo de nombre del viaje
	 * 
	 * @return Retorna el campo de texto con el nombre del viaje
	 */
	public JTextField getNameField() {
		return nameField;
	}

	/**
	 * Obtiene el campo de tipo de viaje
	 * 
	 * @return el campo desplegable con los tipos de viaje
	 */
	public CustomComboBox getTypeField() {
		return typeField;
	}

	/**
	 * Obtiene el campo de fecha de fin del viaje
	 * 
	 * @return Retorna el campo de fecha para seleccionar el fin del viaje
	 */
	public JDateChooser getEndDateField() {
		return endDateField;
	}

	/**
	 * Obtiene el campo de fecha de inicio del viaje
	 * 
	 * @return Retorna el campo de fecha para seleccionar el inicio del viaje
	 */
	public JDateChooser getStartDateField() {
		return startDateField;
	}

	/**
	 * Obtiene el campo de duracion del viaje en dias
	 * 
	 * @return Retorna el campo de texto con la duracion en dias
	 */
	public JTextField getDaysField() {
		return daysField;
	}

	/**
	 * Obtiene el campo desplegable para seleccionar el pais
	 * 
	 * @return Retorna el campo desplegable con los paises
	 */
	public CustomComboBox getCountryComboBox() {
		return countryComboBox;
	}

	/**
	 * Obtiene el area de texto de la descripcion
	 * 
	 * @return Retorna el area de texto con la descripcion del viaje
	 */
	public JTextArea getDescriptionArea() {
		return descriptionArea;
	}

	/**
	 * Obtiene el area de texto de los servicios no incluidos
	 * 
	 * @return Retorna el area de texto con los servicios no incluidos
	 */
	public JTextArea getServicesArea() {
		return servicesArea;
	}

	/**
	 * Obtiene el boton de guardar
	 * 
	 * @return Retorna el boton para guardar el viaje
	 */
	public CustomUsualButton getSavebutton() {
		return saveButton;
	}

	/**
	 * Obtiene el boton de volver
	 * 
	 * @return Retorna el boton para volver a la pantalla anterior
	 */
	public CustomBackButton getBackButton() {
		return backButton;
	}

	/**
	 * Obtiene el id del usuario que esta creando el viaje
	 * 
	 * @return Retorna el id del usuario
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Establece el id del usuario que esta creando el viaje
	 * 
	 * @param Retorna userId el id del usuario
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Obtiene la etiqueta del logo
	 * 
	 * @return Retorna la etiqueta del logo
	 */
	public JLabel getLogoLabel() {
		return logoLabel;
	}
}
