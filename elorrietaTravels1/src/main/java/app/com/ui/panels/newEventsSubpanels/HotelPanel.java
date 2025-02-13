package main.java.app.com.ui.panels.newEventsSubpanels;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class HotelPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] roomTypes = { "Elige una opción", "Doble", "Individual", "Uso doble e individual", "Individual",
			"Triple" };
	private JLabel hotelNameLabel = new JLabel("Nombre del hotel");
	private JLabel roomTypeLabel = new JLabel("Tipo de habitación");
	private JLabel cityLabel = new JLabel("Ciudad");
	private JLabel priceLabel = new JLabel("Precio");
	private JLabel checkInLabel = new JLabel("Fecha de entrada");
	private JLabel checkOutLabel = new JLabel("Fecha de salida");

	private JTextField hotelNameInput = new JTextField();
	private JTextField cityInput = new JTextField();
	private JTextField priceInput = new JTextField();
	private CustomComboBox roomTypesInput = new CustomComboBox(roomTypes);
	private JDateChooser dateCheckIn = new JDateChooser();
	private JDateChooser dateCheckOut = new JDateChooser();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private CustomUsualButton searchButton = new CustomUsualButton("Buscar Alojamiento");
	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");

	private JLayeredPane layeredPane = new JLayeredPane();

	public HotelPanel() {
		setLayout(null);
		setBounds(0, 0, 550, 550);
		setOpaque(false);

		int centerX = 20;
		int startY = 10;
		int labelWidth = 200;
		int labelHeight = 40;
		int verticalSpacing = 10;

		hotelNameLabel.setBounds(centerX, startY, labelWidth, labelHeight);
		hotelNameLabel.setForeground(Color.BLACK);
		hotelNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		roomTypeLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		roomTypeLabel.setForeground(Color.BLACK);
		roomTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));

		cityLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Arial", Font.BOLD, 20));

		priceLabel.setBounds(centerX, startY + 3 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(new Font("Arial", Font.BOLD, 20));

		checkInLabel.setBounds(centerX, startY + 4 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		checkInLabel.setForeground(Color.BLACK);
		checkInLabel.setFont(new Font("Arial", Font.BOLD, 20));

		checkOutLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		checkOutLabel.setForeground(Color.BLACK);
		checkOutLabel.setFont(new Font("Arial", Font.BOLD, 20));

		hotelNameInput.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		roomTypesInput.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
		cityInput.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300, labelHeight);
		priceInput.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300, labelHeight);
		dateCheckIn.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		dateCheckIn.setDateFormatString(dateFormat.toPattern());
		dateCheckIn.setMinSelectableDate(new java.util.Date());

		dateCheckOut.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		dateCheckOut.setDateFormatString(dateFormat.toPattern());
		dateCheckOut.setMinSelectableDate(new java.util.Date());

		searchButton.setBounds(320, 470, searchButton.getWidth() + 50, searchButton.getHeight());
		saveButton.setBounds(20, 470, saveButton.getWidth(), saveButton.getHeight());

		layeredPane.setBounds(0, 0, 550, 550);

		layeredPane.add(hotelNameLabel, Integer.valueOf(1));
		layeredPane.add(roomTypeLabel, Integer.valueOf(1));
		layeredPane.add(cityLabel, Integer.valueOf(1));
		layeredPane.add(priceLabel, Integer.valueOf(1));
		layeredPane.add(checkInLabel, Integer.valueOf(1));
		layeredPane.add(checkOutLabel, Integer.valueOf(1));
		layeredPane.add(cityInput, Integer.valueOf(1));
		layeredPane.add(priceInput, Integer.valueOf(1));
		layeredPane.add(hotelNameInput, Integer.valueOf(1));
		layeredPane.add(roomTypesInput, Integer.valueOf(1));
		layeredPane.add(dateCheckIn, Integer.valueOf(1));
		layeredPane.add(dateCheckOut, Integer.valueOf(1));
		layeredPane.add(searchButton, Integer.valueOf(1));
		layeredPane.add(saveButton, Integer.valueOf(1));

		add(layeredPane);
		setVisible(true);
	}
	
	public JTextField getHotelNameInput() {
		return hotelNameInput;
	}

	public JTextField getCityInput() {
		return cityInput;
	}

	public JTextField getPriceInput() {
		return priceInput;
	}

	public CustomComboBox getRoomTypesInput() {
		return roomTypesInput;
	}

	public JDateChooser getDateCheckIn() {
		return dateCheckIn;
	}

	public JDateChooser getDateCheckOut() {
		return dateCheckOut;
	}

	public CustomUsualButton getSearchButton() {
		return searchButton;
	}

	public CustomUsualButton getSaveButton() {
		return saveButton;
	}
}
