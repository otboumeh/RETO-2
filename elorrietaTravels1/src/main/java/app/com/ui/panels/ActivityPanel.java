package main.java.app.com.ui.panels;


import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;


import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ActivityPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
    private JLabel descriptionLabel = new JLabel("Descripción:");
    private JLabel dateLabel = new JLabel("Fecha:");
    private JLabel priceLabel = new JLabel("Precio (€):");

  
    private JTextArea descriptionInput = new JTextArea();
	private JDateChooser dateInput = new JDateChooser();
    private JTextField priceInput = new JTextField();

    private CustomUsualButton saveButton = new CustomUsualButton("Guardar");
    private CustomUsualButton cancelButton = new CustomUsualButton("Cancelar");

    private JLayeredPane layeredPane = new JLayeredPane();

    public ActivityPanel() {
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
          //Background 
        backgroundLabel.setBounds(0, 0, 1200, 800);
        
        // Configuración de etiquetas y campos
       
        descriptionLabel.setBounds(20, 200, 400, 30);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	descriptionLabel.setForeground(Color.BLACK);

        descriptionInput.setBounds(231, 200, 250, 100);
        descriptionInput.setLineWrap(true);
        descriptionInput.setWrapStyleWord(true);

        dateLabel.setBounds(20, 340, 150, 40);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	dateLabel.setForeground(Color.BLACK);

        dateInput.setBounds(231, 340, 250, 40);

        priceLabel.setBounds(20, 450, 150, 40);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	priceLabel.setForeground(Color.BLACK);

        priceInput.setBounds(231, 450, 250, 40);

        saveButton.setBounds(150, 550, 200, saveButton.getHeight());
        cancelButton.setBounds(400, 550, 200, cancelButton.getHeight());;


        // Añadir componentes al panel
        layeredPane.setBounds(0, 0, 1200, 800);

        layeredPane.add(backgroundLabel, Integer.valueOf(0));
  
      
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

    public CustomUsualButton getCancelButton() {
        return cancelButton;
    }
}
