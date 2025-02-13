package main.java.app.com.ui.panels.newEventsSubpanels;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

import javax.swing.JTextArea;

public class ActivityPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel descriptionLabel = new JLabel("Descripción:");
	private JLabel dateLabel = new JLabel("Fecha:");
	private JLabel priceLabel = new JLabel("Precio (€):");

	private JTextArea descriptionInput = new JTextArea();
	private JDateChooser dateInput = new JDateChooser();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private JTextField priceInput = new JTextField();

	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");

	private JLayeredPane layeredPane = new JLayeredPane();

	public ActivityPanel() {
		setLayout(null);
		setBounds(0, 0, 550, 550);
		setOpaque(false);

		int centerX = 20;
		int startY = 10;
		int labelWidth = 200;
		int labelHeight = 40;
		int verticalSpacing = 10;

		dateLabel.setBounds(centerX, startY, labelWidth, labelHeight);
		dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
		dateLabel.setForeground(Color.BLACK);

		priceLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
		priceLabel.setForeground(Color.BLACK);

		descriptionLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
		descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));
		descriptionLabel.setForeground(Color.BLACK);

		dateInput.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
		dateInput.setDateFormatString(dateFormat.toPattern());

		priceInput.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);

		descriptionInput.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300,
				labelHeight * 4);
		descriptionInput.setLineWrap(true);
		descriptionInput.setWrapStyleWord(true);

		saveButton.setBounds(20, 420, saveButton.getWidth(), saveButton.getHeight());

		layeredPane.setBounds(0, 0, 550, 550);

		layeredPane.add(descriptionLabel, Integer.valueOf(1));
		layeredPane.add(descriptionInput, Integer.valueOf(1));
		layeredPane.add(dateLabel, Integer.valueOf(1));
		layeredPane.add(dateInput, Integer.valueOf(1));
		layeredPane.add(priceLabel, Integer.valueOf(1));
		layeredPane.add(priceInput, Integer.valueOf(1));
		layeredPane.add(saveButton, Integer.valueOf(1));

		add(layeredPane);
		setVisible(true);
	}

	public JTextArea getDescriptionInput() {
		return descriptionInput;
	}

	public JDateChooser getDateInput() {
		return dateInput;
	}

	public JTextField getPriceInput() {
		return priceInput;
	}

	public CustomUsualButton getSaveButton() {
		return saveButton;
	}

}
