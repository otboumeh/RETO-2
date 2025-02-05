package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class NewProfilePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private String[] agencyTypes = {"Elige una Opcion", "Mayorista", "Minorista", "Mayorista-minorista"};
	private String[] numEmployees = {"Elige una Opcion", "Entre 2 a 10", "Entre 10 a 100", "Entre 100 a 1000"}; 
	
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel panelTitle = new JLabel("Perfil Nuevo");
	private JLabel agencyNameLabel = new JLabel("Nombre Agencia");
	private JLabel agencyPasswordLabel = new JLabel("Contraseña");
	private JLabel agencyColorLabel = new JLabel("Color de marca");
	private JLabel numEmployeesLabel = new JLabel("Número de Empleados");
	private JLabel agencyTypeLabel = new JLabel("Tipo de Agencia");
	private JLabel logoLabel = new JLabel("Logo");
	
	private JTextField agencyNameInput = new JTextField();
	private JTextField agencyPasswordInput = new JTextField();
	private JTextField agencyColorInput = new JTextField();
	private CustomComboBox numEmployeesInput = new CustomComboBox(numEmployees);
	private CustomComboBox agencyTypesInput = new CustomComboBox(agencyTypes);
	private JTextField logoInput = new JTextField();
	
	private CustomUsualButton saveButton = new CustomUsualButton("Guardar");
	private CustomUsualButton cancelButton = new CustomUsualButton("Cancelar");
	private JLayeredPane layeredPane = new JLayeredPane();

	
	public NewProfilePanel() {
		
		setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
    	panelTitle.setForeground(Color.BLACK);
    	panelTitle.setBounds(0, 50, 1190, 250);
    	panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	panelTitle.setVerticalAlignment(SwingConstants.CENTER);
    	
    	agencyNameLabel.setBounds(350, 250, 250, 40);
    	agencyNameLabel.setForeground(Color.BLACK);
    	agencyNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	agencyPasswordLabel.setBounds(350, 300, 250, 40);
    	agencyPasswordLabel.setForeground(Color.BLACK);
    	agencyPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	agencyColorLabel.setBounds(350, 350, 250, 40);
    	agencyColorLabel.setForeground(Color.BLACK);
    	agencyColorLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	numEmployeesLabel.setBounds(350, 400, 250, 40);
    	numEmployeesLabel.setForeground(Color.BLACK);
    	numEmployeesLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	agencyTypeLabel.setBounds(350, 450, 250, 40);
    	agencyTypeLabel.setForeground(Color.BLACK);
    	agencyTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	logoLabel.setBounds(350, 500, 250, 40);
    	logoLabel.setForeground(Color.BLACK);
    	logoLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	agencyNameInput.setBounds(600, 250, 250, 40);
    	agencyPasswordInput.setBounds(600, 300, 250, 40);
    	agencyColorInput.setBounds(600, 350, 250, 40);
    	numEmployeesInput.setBounds(600, 400, 250, 40);
    	agencyTypesInput.setBounds(600, 450, 250, 40);
    	logoInput.setBounds(600, 500, 500, 40);
    	
        saveButton.setBounds(600, 600, saveButton.getWidth(), saveButton.getHeight());
        cancelButton.setBounds(430, 600, cancelButton.getWidth(), cancelButton.getHeight());
    	
        
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(panelTitle, Integer.valueOf(1)); 
        layeredPane.add(agencyNameLabel, Integer.valueOf(1));
        layeredPane.add(agencyPasswordLabel, Integer.valueOf(1));
        layeredPane.add(agencyColorLabel, Integer.valueOf(1));
        layeredPane.add(numEmployeesLabel, Integer.valueOf(1));
        layeredPane.add(agencyTypeLabel, Integer.valueOf(1));
        layeredPane.add(logoLabel, Integer.valueOf(1));
        
        layeredPane.add(agencyNameInput, Integer.valueOf(1));
        layeredPane.add(agencyPasswordInput, Integer.valueOf(1));
        layeredPane.add(agencyColorInput, Integer.valueOf(1));
        layeredPane.add(numEmployeesInput, Integer.valueOf(1));
        layeredPane.add(agencyTypesInput, Integer.valueOf(1));
        layeredPane.add(logoInput, Integer.valueOf(1));

        layeredPane.add(saveButton, Integer.valueOf(1));
        layeredPane.add(cancelButton, Integer.valueOf(1));

    	add(layeredPane);
        setVisible(true);
	}


	public JTextField getAgencyNameInput() {
		return agencyNameInput;
	}
	public JTextField getAgencyPasswordInput() {
		return agencyPasswordInput;
	}

	public JTextField getAgencyColorInput() {
		return agencyColorInput;
	}

	public CustomComboBox getNumEmployeesInput() {
		return numEmployeesInput;
	}

	public CustomComboBox getAgencyTypesInput() {
		return agencyTypesInput;
	}

	public JTextField getLogoInput() {
		return logoInput;
	}

	public CustomUsualButton getSaveButton() {
		return saveButton;
	}

	public CustomUsualButton getCancelButton() {
		return cancelButton;
	}
}
