package main.java.app.com.ui.panels.newEventsSubpanels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class FlightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel nameLabel = new JLabel("Trayecto");
	private JLabel typeLabel = new JLabel("Aeropuerto Origen");
	private JLabel startLabel = new JLabel("Aeropuerto Destino");
	private JLabel endLabel = new JLabel("Fecha Ida");
	private JLabel daysLabel = new JLabel("Código Vuelo");
	private JLabel descriptionLabel = new JLabel("Precio");
	private JLabel servicesLabel = new JLabel("Horario Salida");
	private JLabel durationLabel = new JLabel("Duracion");

	private JLayeredPane layeredPane = new JLayeredPane();
	String[] airport = { "Bilbao(BIO)", "Madrid(MAD)", "...", "...", "..." };
	String[] roundTripOrOneWayOptions = { "Ida", "Ida-Vuelta" };

	CustomComboBox trajectory = new CustomComboBox(roundTripOrOneWayOptions);
	CustomComboBox origin = new CustomComboBox(airport);
	CustomComboBox destination = new CustomComboBox(airport);
	private JDateChooser dateChooserIda = new JDateChooser();

	JTextField code = new JTextField();
	JTextField aeroline = new JTextField();;
	JTextArea price = new JTextArea();
	JTextArea leavingTime = new JTextArea();
	JTextArea duration = new JTextArea();
	private CustomUsualButton searchButton = new CustomUsualButton("Buscar Vuelo");
	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");

	public FlightPanel() {
		setLayout(null);
		setBounds(0, 0, 550, 550);
		setOpaque(false);

		layeredPane.setBounds(0, 0, 550, 550);

		int centerX = 20;
		int startY = 10;
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

		descriptionLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));

		servicesLabel.setBounds(centerX, startY + 6 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		servicesLabel.setForeground(Color.BLACK);
		servicesLabel.setFont(new Font("Arial", Font.BOLD, 20));

		destination.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		aeroline.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300, labelHeight);
		code.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300, labelHeight);
		dateChooserIda.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		origin.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
		trajectory.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		leavingTime.setBounds(centerX + labelWidth + 10, startY + 6 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		duration.setBounds(centerX + labelWidth + 10, startY + 7 * (labelHeight + verticalSpacing), 300, labelHeight);

		saveButton.setBounds(20, 420, saveButton.getWidth(), saveButton.getHeight());
		searchButton.setBounds(220, 420, searchButton.getWidth(), searchButton.getHeight());
		durationLabel.setBounds(centerX, startY + 7 * (labelHeight + verticalSpacing), 300, labelHeight);
		durationLabel.setForeground(Color.BLACK);
		durationLabel.setFont(new Font("Arial", Font.BOLD, 20));

		layeredPane.add(aeroline, Integer.valueOf(1));
		layeredPane.add(code, Integer.valueOf(1));
		layeredPane.add(destination, Integer.valueOf(1));
		layeredPane.add(origin, Integer.valueOf(1));
		layeredPane.add(trajectory, Integer.valueOf(1));
		layeredPane.add(dateChooserIda, Integer.valueOf(1));
		layeredPane.add(nameLabel, Integer.valueOf(1));
		layeredPane.add(typeLabel, Integer.valueOf(1));
		layeredPane.add(startLabel, Integer.valueOf(1));
		layeredPane.add(endLabel, Integer.valueOf(1));
		layeredPane.add(daysLabel, Integer.valueOf(1));
		layeredPane.add(descriptionLabel, Integer.valueOf(1));
		layeredPane.add(servicesLabel, Integer.valueOf(1));
		layeredPane.add(saveButton, Integer.valueOf(1));
		layeredPane.add(searchButton, Integer.valueOf(1));
		layeredPane.add(durationLabel, Integer.valueOf(1));
		layeredPane.add(duration, Integer.valueOf(1));
		layeredPane.add(price, Integer.valueOf(1));
		layeredPane.add(leavingTime, Integer.valueOf(1));
		add(layeredPane);
		setVisible(true);
	}

	public CustomUsualButton getSaveButton() {
		return saveButton;
	}

	public CustomUsualButton getSearchButton() {
		return searchButton;
	}

	public JTextArea getDuration() {
		return duration;
	}

	public JTextArea getLeavingTime() {
		return leavingTime;
	}

	public JTextArea getPrice() {
		return price;
	}

	public JTextField getAeroline() {
		return aeroline;
	}

	public CustomComboBox getTrajectory() {
		return trajectory;
	}

	public CustomComboBox getOrigin() {
		return origin;
	}

	public CustomComboBox getDestination() {
		return destination;
	}

	public JDateChooser getStartDateField() {
		return dateChooserIda;
	}

	public JTextField getCode() {
		return code;
	}
}
