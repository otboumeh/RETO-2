package main.java.app.com.ui.panels.newEventsSubpanels;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

/**
 * La clase de subpanel de vuelos para el panel NewEventoPanel.
 * 
 * @author Grupo_01
 */
public class FlightPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] airport = { "Bilbao(BIO)", "Madrid(MAD)" };
	private String[] roundTripOrOneWayOptions = { "Ida", "Ida-Vuelta" };
	private String[] airlines = { "Qatar", "Iberia" };

	private Calendar calendar = Calendar.getInstance();

	private JLabel trajectoryLabel = new JLabel("Trayecto");
	private JLabel originLabel = new JLabel("Aeropuerto Origen");
	private JLabel destinatoinLabel = new JLabel("Aeropuerto Destino");
	private JLabel dateLabel = new JLabel("Fecha Ida");
	private JLabel codeLabel = new JLabel("Código Vuelo");
	private JLabel airlineLabel = new JLabel("Aerolinea");
	private JLabel priceLabel = new JLabel("Precio");
	private JLabel timeLabel = new JLabel("Horario Salida");
	private JLabel durationLabel = new JLabel("Duracion");

	private CustomComboBox trajectory = new CustomComboBox(roundTripOrOneWayOptions);
	private CustomComboBox origin = new CustomComboBox(airport);
	private CustomComboBox destination = new CustomComboBox(airport);
	private JDateChooser dateChooserIda = new JDateChooser();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private JTextField code = new JTextField();
	private CustomComboBox airline = new CustomComboBox(airlines);;
	private JTextField price = new JTextField();

	private SpinnerDateModel modelTimeIda = new SpinnerDateModel();
	private JSpinner leavingTime = new JSpinner(modelTimeIda);
	private JSpinner.DateEditor editorDeparture = new JSpinner.DateEditor(leavingTime, "HH:mm:ss");

	private SpinnerDateModel modelDurationIda = new SpinnerDateModel();
	private JSpinner duration = new JSpinner(modelDurationIda);
	private JSpinner.DateEditor editorDuration = new JSpinner.DateEditor(duration, "HH:mm:ss");

	private CustomUsualButton searchButton = new CustomUsualButton("Buscar Vuelo");
	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");

	private JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Constructor del panel de vuelos.
	 * 
	 * Configura los aspectos visuales de los elementos de este panel.
	 */
	public FlightPanel() {
		setLayout(null);
		setBounds(0, 0, 550, 550);
		setOpaque(false);

		layeredPane.setBounds(0, 0, 550, 550);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		int centerX = 20;
		int startY = 10;
		int labelWidth = 200;
		int labelHeight = 40;
		int verticalSpacing = 10;

		trajectoryLabel.setBounds(centerX, startY, labelWidth, labelHeight);
		trajectoryLabel.setForeground(Color.BLACK);
		trajectoryLabel.setFont(new Font("Arial", Font.BOLD, 20));

		originLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		originLabel.setForeground(Color.BLACK);
		originLabel.setFont(new Font("Arial", Font.BOLD, 20));

		destinatoinLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		destinatoinLabel.setForeground(Color.BLACK);
		destinatoinLabel.setFont(new Font("Arial", Font.BOLD, 20));

		dateLabel.setBounds(centerX, startY + 3 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 20));

		codeLabel.setBounds(centerX, startY + 4 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		codeLabel.setForeground(Color.BLACK);
		codeLabel.setFont(new Font("Arial", Font.BOLD, 20));

		airlineLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		airlineLabel.setForeground(Color.BLACK);
		airlineLabel.setFont(new Font("Arial", Font.BOLD, 20));

		priceLabel.setBounds(centerX, startY + 6 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(new Font("Arial", Font.BOLD, 20));

		timeLabel.setBounds(centerX, startY + 7 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setFont(new Font("Arial", Font.BOLD, 20));

		durationLabel.setBounds(centerX, startY + 8 * (labelHeight + verticalSpacing), 300, labelHeight);
		durationLabel.setForeground(Color.BLACK);
		durationLabel.setFont(new Font("Arial", Font.BOLD, 20));

		trajectory.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		origin.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
		destination.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		dateChooserIda.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		dateChooserIda.setDateFormatString(dateFormat.toPattern());
		dateChooserIda.setMinSelectableDate(new java.util.Date());

		code.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300, labelHeight);
		airline.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300, labelHeight);
		price.setBounds(centerX + labelWidth + 10, startY + 6 * (labelHeight + verticalSpacing), 300, labelHeight);
		leavingTime.setBounds(centerX + labelWidth + 10, startY + 7 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		leavingTime.setEditor(editorDeparture);
		leavingTime.setValue(calendar.getTime());

		duration.setBounds(centerX + labelWidth + 10, startY + 8 * (labelHeight + verticalSpacing), 300, labelHeight);
		duration.setEditor(editorDuration);
		duration.setValue(calendar.getTime());

		saveButton.setBounds(20, 470, saveButton.getWidth(), saveButton.getHeight());
		searchButton.setBounds(370, 470, searchButton.getWidth(), searchButton.getHeight());

		layeredPane.add(airlineLabel, Integer.valueOf(1));
		layeredPane.add(airline, Integer.valueOf(1));
		layeredPane.add(codeLabel, Integer.valueOf(1));
		layeredPane.add(code, Integer.valueOf(1));
		layeredPane.add(destinatoinLabel, Integer.valueOf(1));
		layeredPane.add(destination, Integer.valueOf(1));
		layeredPane.add(originLabel, Integer.valueOf(1));
		layeredPane.add(origin, Integer.valueOf(1));
		layeredPane.add(trajectoryLabel, Integer.valueOf(1));
		layeredPane.add(trajectory, Integer.valueOf(1));
		layeredPane.add(dateChooserIda, Integer.valueOf(1));
		layeredPane.add(dateLabel, Integer.valueOf(1));
		layeredPane.add(durationLabel, Integer.valueOf(1));
		layeredPane.add(duration, Integer.valueOf(1));
		layeredPane.add(priceLabel, Integer.valueOf(1));
		layeredPane.add(price, Integer.valueOf(1));
		layeredPane.add(timeLabel, Integer.valueOf(1));
		layeredPane.add(leavingTime, Integer.valueOf(1));
		layeredPane.add(saveButton, Integer.valueOf(1));
		layeredPane.add(searchButton, Integer.valueOf(1));
		add(layeredPane);
		setVisible(true);
	}

	/**
	 * Obtiene el botón de guardar.
	 *
	 * @return Retorna un `CustomUsualButton` que permite guardar.
	 */
	public CustomUsualButton getSaveButton() {
		return saveButton;
	}

	/**
	 * Obtiene el botón de búsqueda.
	 *
	 * @return Retorna un `CustomUsualButton` que permite realizar una búsqueda.
	 */
	public CustomUsualButton getSearchButton() {
		return searchButton;
	}

	/**
	 * Obtiene el campo de duración del vuelo.
	 *
	 * @return `JSpinner` que permite seleccionar la duración del vuelo.
	 */
	public JSpinner getDuration() {
		return duration;
	}

	/**
	 * Obtiene el campo de hora de salida.
	 *
	 * @return `JSpinner` que permite seleccionar la hora de salida del vuelo.
	 */
	public JSpinner getLeavingTime() {
		return leavingTime;
	}

	/**
	 * Obtiene el campo de precio.
	 *
	 * @return `JTextField` donde se introduce el precio del vuelo
	 */
	public JTextField getPrice() {
		return price;
	}

	/**
	 * Obtiene la aerolínea seleccionada
	 *
	 * @return `CustomComboBox` con la lista de aerolíneas disponibles
	 */
	public CustomComboBox getAirline() {
		return airline;
	}

	/**
	 * Obtiene el tipo de trayecto (ida o ida y vuelta).
	 *
	 * @return `CustomComboBox` que indica si el vuelo es solo de ida o ida y
	 *         vuelta.
	 */
	public CustomComboBox getTrajectory() {
		return trajectory;
	}

	/**
	 * Obtiene el aeropuerto de origen seleccionado.
	 *
	 * @return `CustomComboBox` con la lista de aeropuertos de origen disponibles.
	 */
	public CustomComboBox getOrigin() {
		return origin;
	}

	/**
	 * Obtiene el aeropuerto de destino seleccionado.
	 *
	 * @return `CustomComboBox` con la lista de aeropuertos de destino disponibles.
	 */
	public CustomComboBox getDestination() {
		return destination;
	}

	/**
	 * Obtiene el campo de selección de fecha de inicio.
	 *
	 * @return `JDateChooser` que permite elegir la fecha de salida del vuelo.
	 */
	public JDateChooser getStartDateField() {
		return dateChooserIda;
	}

	/**
	 * Obtiene el código del vuelo.
	 *
	 * @return `JTextField` donde se introduce el código del vuelo.
	 */
	public JTextField getCode() {
		return code;
	}
}
