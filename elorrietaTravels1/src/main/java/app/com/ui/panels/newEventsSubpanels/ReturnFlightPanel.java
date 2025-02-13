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

public class ReturnFlightPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] airlines = { "Qatar", "Iberia" };
	
    private Calendar calendar = Calendar.getInstance();

	private JLabel returnDateLabel = new JLabel("Fecha de vuelta");
	private JLabel flightIdLabel = new JLabel("Código de vuelo");
	private JLabel returnAirlineLabel = new JLabel("Aerolinea de vuelta");
	private JLabel totalPriceLabel = new JLabel("Precio total");
	private JLabel returnTimeLabel = new JLabel("Horario de vuelta");
	private JLabel returnDurationLabel = new JLabel("Duración de vuelta");

	private JDateChooser dateChooserReturn = new JDateChooser();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private JTextField flightIdInput = new JTextField();
	private CustomComboBox returnAirlineInput = new CustomComboBox(airlines);
	private JTextField totalPriceInput = new JTextField();

	private SpinnerDateModel modelTimeRtn = new SpinnerDateModel();

	private JSpinner returnTimeInput = new JSpinner(modelTimeRtn);
	private JSpinner.DateEditor editorReturnTime = new JSpinner.DateEditor(returnTimeInput, "HH:mm:ss");

	private SpinnerDateModel modelDurationRtn = new SpinnerDateModel();
	private JSpinner returnDurationInput = new JSpinner(modelDurationRtn);
	private JSpinner.DateEditor editorDuration = new JSpinner.DateEditor(returnDurationInput, "HH:mm:ss");

	private JLayeredPane layeredPane = new JLayeredPane();

	public ReturnFlightPanel() {
		setLayout(null);
		setBounds(0, 0, 550, 400);
		setOpaque(false);
		
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

		int centerX = 20;
		int startY = 60;
		int labelWidth = 200;
		int labelHeight = 40;
		int verticalSpacing = 10;

		returnDateLabel.setBounds(centerX, startY, labelWidth, labelHeight);
		returnDateLabel.setForeground(Color.BLACK);
		returnDateLabel.setFont(new Font("Arial", Font.BOLD, 20));

		flightIdLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		flightIdLabel.setForeground(Color.BLACK);
		flightIdLabel.setFont(new Font("Arial", Font.BOLD, 20));

		returnAirlineLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		returnAirlineLabel.setForeground(Color.BLACK);
		returnAirlineLabel.setFont(new Font("Arial", Font.BOLD, 20));

		totalPriceLabel.setBounds(centerX, startY + 3 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		totalPriceLabel.setForeground(Color.BLACK);
		totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));

		returnTimeLabel.setBounds(centerX, startY + 4 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		returnTimeLabel.setForeground(Color.BLACK);
		returnTimeLabel.setFont(new Font("Arial", Font.BOLD, 20));

		returnDurationLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		returnDurationLabel.setForeground(Color.BLACK);
		returnDurationLabel.setFont(new Font("Arial", Font.BOLD, 20));

		dateChooserReturn.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		dateChooserReturn.setDateFormatString(dateFormat.toPattern());
		dateChooserReturn.setMinSelectableDate(new java.util.Date());


		flightIdInput.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		returnAirlineInput.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		totalPriceInput.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		returnTimeInput.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		returnTimeInput.setEditor(editorReturnTime);
		returnTimeInput.setValue(calendar.getTime()); 
		
		returnDurationInput.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300,
				labelHeight);
		returnDurationInput.setEditor(editorDuration);
		returnDurationInput.setValue(calendar.getTime()); 

		layeredPane.setBounds(0, 0, 550, 400);
		layeredPane.add(returnDateLabel, Integer.valueOf(1));
		layeredPane.add(flightIdLabel, Integer.valueOf(1));
		layeredPane.add(returnAirlineLabel, Integer.valueOf(1));
		layeredPane.add(totalPriceLabel, Integer.valueOf(1));
		layeredPane.add(returnTimeLabel, Integer.valueOf(1));
		layeredPane.add(returnDurationLabel, Integer.valueOf(1));
		layeredPane.add(dateChooserReturn, Integer.valueOf(1));
		layeredPane.add(flightIdInput, Integer.valueOf(1));
		layeredPane.add(returnAirlineInput, Integer.valueOf(1));
		layeredPane.add(totalPriceInput, Integer.valueOf(1));
		layeredPane.add(returnTimeInput, Integer.valueOf(1));
		layeredPane.add(returnDurationInput, Integer.valueOf(1));

		add(layeredPane);
		setVisible(true);
	}

	public JTextField getFlightIdInput() {
		return flightIdInput;
	}

	public CustomComboBox getReturnAirlineInput() {
		return returnAirlineInput;
	}

	public JTextField getTotalPriceInput() {
		return totalPriceInput;
	}

	public JSpinner getReturnTimeInput() {
		return returnTimeInput;
	}

	public JSpinner getReturnDurationInput() {
		return returnDurationInput;
	}

	public JDateChooser getDateChooserReturn() {
		return dateChooserReturn;
	}

}
