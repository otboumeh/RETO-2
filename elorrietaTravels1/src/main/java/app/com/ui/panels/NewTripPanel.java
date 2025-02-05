package main.java.app.com.ui.panels;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.java.app.com.ui.customComponents.customButtons.CustomBackButton;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;


public class NewTripPanel  extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel nameLabel = new JLabel("Nombre viaje");
	private JLabel typeLabel = new JLabel("Tipo viaje");
	private JLabel startLabel = new JLabel("Inicio viaje");
	private JLabel endLabel = new JLabel("Fin viaje");
	private JLabel daysLabel = new JLabel("Días");
	private JLabel countryLabel = new JLabel("País");
	private JLabel descriptionLabel = new JLabel("Descripción");
	private JLabel servicesLabel = new JLabel("Servicios no inc.");
	private JLayeredPane layeredPane = new JLayeredPane();
	JTextField nameField = new JTextField();
	JTextField typeField = new JTextField();
	JTextField endDateField = new JTextField("dd/MM/yyyy");
    JTextField startDateField = new JTextField("dd/MM/yyyy");
    JTextField daysField = new JTextField();
    String[] countries = {"España", "Francia", "Italia", "Alemania", "Reino Unido"};
    JComboBox<String> countryComboBox = new JComboBox<>(countries);
    JTextArea descriptionArea = new JTextArea();
    JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
    JTextArea servicesArea = new JTextArea();
    JScrollPane servicesScroll = new JScrollPane(servicesArea);
	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");
	private CustomUsualButton cancelButton = new CustomUsualButton("Cancelar");
	
	private CustomBackButton backButton = new CustomBackButton("←");


	public NewTripPanel() {
		 setLayout(null);
	        setBounds(0, 0, 1200, 800);        
	    
	    	backgroundLabel.setBounds(0, 0, 1200, 800);
	        layeredPane.setBounds(0, 0, 1200, 800);
	        
	        int centerX = 200;
	        int startY = 150;
	        int labelWidth = 200;
	        int labelHeight = 30;
	        int verticalSpacing = 30;

	        nameLabel.setBounds(centerX, startY, labelWidth, labelHeight);
	        nameLabel.setForeground(Color.BLACK);
	        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        typeLabel.setBounds(centerX, startY + 1 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        typeLabel.setForeground(Color.BLACK);
	        typeLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        startLabel.setBounds(centerX, startY + 2 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        startLabel.setForeground(Color.BLACK);
	        startLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        
	    	backButton.setBounds(30, 30, 50, 30);


	        endLabel.setBounds(centerX, startY + 3 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        endLabel.setForeground(Color.BLACK);
	        endLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        daysLabel.setBounds(centerX, startY + 4 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        daysLabel.setForeground(Color.BLACK);
	        daysLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        countryLabel.setBounds(centerX, startY + 5 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        countryLabel.setForeground(Color.BLACK);
	        countryLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        descriptionLabel.setBounds(centerX, startY + 6 * (labelHeight + verticalSpacing), labelWidth, labelHeight);
	        descriptionLabel.setForeground(Color.BLACK);
	        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 20));

	        servicesLabel.setBounds(centerX, startY + 8 * (labelHeight + verticalSpacing), 300, labelHeight);
	        servicesLabel.setForeground(Color.BLACK);
	        servicesLabel.setFont(new Font("Arial", Font.BOLD, 20));
	        startDateField.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300, labelHeight);
	        servicesScroll.setBounds(centerX + labelWidth + 10, startY + 8 * (labelHeight + verticalSpacing), 300, 100);
	        descriptionScroll.setBounds(centerX + labelWidth + 10, startY + 6 * (labelHeight + verticalSpacing), 300, 100);
	        countryComboBox.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300, labelHeight);
	        daysField.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300, labelHeight);
	        daysField.setEditable(false);
	        endDateField.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300, labelHeight);
	        typeField.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
	        nameField.setBounds(centerX + labelWidth + 10, startY, 300, labelHeight);
	        saveButton.setBounds(900, 300, saveButton.getWidth(), saveButton.getHeight());
	        cancelButton.setBounds(900, 450, cancelButton.getWidth(), cancelButton.getHeight());
	        
	        layeredPane.add(backgroundLabel, Integer.valueOf(0));

	        
	        layeredPane.add(servicesScroll, Integer.valueOf(1));
	        layeredPane.add(descriptionScroll, Integer.valueOf(1));

	        layeredPane.add(countryComboBox, Integer.valueOf(1));
	        layeredPane.add(daysField, Integer.valueOf(1));
	        layeredPane.add(endDateField, Integer.valueOf(1));
	        layeredPane.add(typeField, Integer.valueOf(1));
	        layeredPane.add(nameField, Integer.valueOf(1));

	        layeredPane.add(startDateField, Integer.valueOf(1));
	        layeredPane.add(nameLabel, Integer.valueOf(1));
	        layeredPane.add(typeLabel, Integer.valueOf(1));
	        layeredPane.add(startLabel, Integer.valueOf(1));
	        layeredPane.add(endLabel, Integer.valueOf(1));
	        layeredPane.add(daysLabel, Integer.valueOf(1));
	        layeredPane.add(countryLabel, Integer.valueOf(1));
	        layeredPane.add(descriptionLabel, Integer.valueOf(1));
	        layeredPane.add(servicesLabel, Integer.valueOf(1));
	        layeredPane.add(saveButton, Integer.valueOf(1));
	        layeredPane.add(cancelButton, Integer.valueOf(1));
	        layeredPane.add(backButton, Integer.valueOf(1));



      
	    	add(layeredPane);
	        setVisible(true);
	}
	   public JTextField getNameField() {
			return nameField;
		}
	   public JTextField getTypeField() {
				return typeField;
			}  
	   public JTextField getEndDateField() {
				return endDateField;
			}   public JTextField getStartDateField() {
				return startDateField;
			}   
			public JTextField getDaysField() {
				return daysField;
			}   
			public JComboBox<String> getCountryComboBox() {
				return countryComboBox;
			}   
			public JTextArea getDescriptionArea() {
				return descriptionArea;
			}   
			public JTextArea getServicesArea() {
				return servicesArea;
			}
			public CustomUsualButton getSavebutton() {
				return saveButton;
			}	
			public CustomUsualButton getCancelButton() {
				return cancelButton;
			}
			public CustomBackButton getBackButton() {
				return backButton;
			}
}
