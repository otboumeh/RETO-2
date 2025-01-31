package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.java.app.com.ui.customComponents.CustomComboBox;

public class NewEvent extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private FlightPanel flightPanel = new FlightPanel();
	private ReturnFlightPanel returnflightPanel = new ReturnFlightPanel();
	private HotelPanel hotelPanel = new HotelPanel();
	private ActivityPanel activitypanel = new ActivityPanel();
	private String[] eventTypes = {"Elige una opción", "Vuelo", "Hotel", "Actividad"};
	
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel eventNameLabel = new JLabel("Nombre de evento");
	private JLabel eventTypesLabel = new JLabel("Tipo de evento");
	private JTextField eventNameInput = new JTextField();
	private CustomComboBox eventTypesInput = new CustomComboBox(eventTypes);
	private JLayeredPane layeredPane = new JLayeredPane();
	
	
	
public NewEvent() {
        
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	
    	eventNameLabel.setBounds(20, 75, 250, 40);
    	eventNameLabel.setForeground(Color.BLACK);
    	eventNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	eventTypesLabel.setBounds(20, 125, 250, 40);
    	eventTypesLabel.setForeground(Color.BLACK);
    	eventTypesLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	
    	eventNameInput.setBounds(231, 75, 250, 40);
    	eventTypesInput.setBounds(231, 125, 250, 40);

    	   	

    	
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(eventNameLabel, Integer.valueOf(1));
        layeredPane.add(eventTypesLabel, Integer.valueOf(1));
        layeredPane.add(eventNameInput, Integer.valueOf(1));
        layeredPane.add(eventTypesInput, Integer.valueOf(1));
        //layeredPane.add(flightPanel, Integer.valueOf(1));
        //layeredPane.add(returnflightPanel, Integer.valueOf(1));
        //layeredPane.add(hotelPanel, Integer.valueOf(1));
        layeredPane.add(activitypanel, Integer.valueOf(1));


    	add(layeredPane);
        setVisible(true);
	}

	


}



