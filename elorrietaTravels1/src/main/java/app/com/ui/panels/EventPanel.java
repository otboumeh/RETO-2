package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EventPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
    private JLabel panelTitle = new JLabel("Evento");
    private JLabel nameLabel = new JLabel("Nombre del evento:");
    private JLabel typeLabel = new JLabel("Tipo de evento:");
    private JLabel descriptionLabel = new JLabel("Descripción:");
    private JLabel dateLabel = new JLabel("Fecha:");
    private JLabel priceLabel = new JLabel("Precio (€):");

    private JTextField nameInput = new JTextField();
    private JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"Vuelo", "Alojamiento", "Actividad"});
    private JTextArea descriptionInput = new JTextArea();
    private JTextField dateInput = new JTextField();
    private JTextField priceInput = new JTextField();

    private CustomUsualButton saveButton = new CustomUsualButton("Guardar");
    private CustomUsualButton cancelButton = new CustomUsualButton("Cancelar");

    private JLayeredPane layeredPane = new JLayeredPane();

    public EventPanel() {
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
          //Background 
        backgroundLabel.setBounds(0, 0, 1200, 800);
        
        // Configuración de etiquetas y campos
        panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
        panelTitle.setForeground(Color.BLACK);
        panelTitle.setBounds(0, 50, 1190, 100);
        panelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        nameLabel.setBounds(300, 200, 200, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        nameInput.setBounds(500, 200, 300, 30);

        typeLabel.setBounds(300, 250, 200, 30);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        typeComboBox.setBounds(500, 250, 300, 30);

        descriptionLabel.setBounds(300, 300, 200, 30);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));

        descriptionInput.setBounds(500, 300, 300, 100);
        descriptionInput.setLineWrap(true);
        descriptionInput.setWrapStyleWord(true);

        dateLabel.setBounds(300, 420, 200, 30);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));

        dateInput.setBounds(500, 420, 300, 30);

        priceLabel.setBounds(300, 470, 200, 30);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));

        priceInput.setBounds(500, 470, 300, 30);

        saveButton.setBounds(500, 550, 140, 40);
        cancelButton.setBounds(660, 550, 140, 40);

        // Añadir componentes al panel
        layeredPane.setBounds(0, 0, 1200, 800);

        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(panelTitle, Integer.valueOf(1));
        layeredPane.add(nameLabel, Integer.valueOf(1));
        layeredPane.add(nameInput, Integer.valueOf(1));
        layeredPane.add(typeLabel, Integer.valueOf(1));
        layeredPane.add(typeComboBox, Integer.valueOf(1));
        layeredPane.add(descriptionLabel, Integer.valueOf(1));
        layeredPane.add(descriptionInput, Integer.valueOf(1));
        layeredPane.add(dateLabel, Integer.valueOf(1));
        layeredPane.add(dateInput, Integer.valueOf(1));
        layeredPane.add(priceLabel, Integer.valueOf(1));
        layeredPane.add(priceInput, Integer.valueOf(1));
        layeredPane.add(saveButton, Integer.valueOf(1));
        layeredPane.add(cancelButton, Integer.valueOf(1));

        add(layeredPane);
        setVisible(true);
    }

    public JTextField getNameInput() {
        return nameInput;
    }

    public JComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }

    public JTextArea getDescriptionInput() {
        return descriptionInput;
    }

    public JTextField getDateInput() {
        return dateInput;
    }

    public JTextField getPriceInput() {
        return priceInput;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
