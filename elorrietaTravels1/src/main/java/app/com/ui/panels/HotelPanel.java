package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import main.java.app.com.ui.customComponents.CustomComboBox;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class HotelPanel extends JPanel{


	private static final long serialVersionUID = 1L;
	
	private String[] roomTypes = {"Elige una opción", "Doble", "Individual", "Uso doble e individual", "Individual", "Triple"};
	
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel roomTypeLabel = new JLabel("Tipo de habitación");
	private JLabel panelCity = new JLabel("Ciudad");
	private JLabel priceLabel = new JLabel("Precio");
	private JLabel checkInLabel = new JLabel("Fecha de entrada");
	private JLabel checkOutLabel = new JLabel("Fecha de salida");
	private JTextField cityInput = new JTextField();
	private JTextField priceInput = new JTextField();
    private CustomComboBox roomTypesInput = new CustomComboBox(roomTypes);
	private JDateChooser dateCheckIn = new JDateChooser();
	private JDateChooser dateCheckOut = new JDateChooser();
	private CustomUsualButton searchButton = new CustomUsualButton("Buscar Alojamiento");
	private CustomUsualButton cancelButton = new CustomUsualButton("Cancelar");
	private JLayeredPane layeredPane = new JLayeredPane();
	
public HotelPanel() {
        
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	
    	roomTypeLabel.setBounds(42, 200, 250, 40);
    	roomTypeLabel.setForeground(Color.BLACK);
    	roomTypeLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	panelCity.setBounds(42, 250, 250, 40);
    	panelCity.setForeground(Color.BLACK);
    	panelCity.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	priceLabel.setBounds(42, 300, 250, 40);
    	priceLabel.setForeground(Color.BLACK);
    	priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	checkInLabel.setBounds(42, 350, 250, 40);
    	checkInLabel.setForeground(Color.BLACK);
    	checkInLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	checkOutLabel.setBounds(42, 400, 250, 40);
    	checkOutLabel.setForeground(Color.BLACK);
    	checkOutLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    
    	roomTypesInput.setBounds(300, 200, 200, 40);
    	cityInput.setBounds(300, 250, 200, 40);
    	priceInput.setBounds(300, 300, 200, 40);
    	dateCheckIn.setBounds(300, 350, 200, 40);
    	dateCheckOut.setBounds(300, 400, 200, 40);

    	searchButton.setBounds(150, 450, 200, searchButton.getHeight());
    	cancelButton.setBounds(400, 450, 200, cancelButton.getHeight());


    	   	

    	
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(roomTypeLabel, Integer.valueOf(1));
        layeredPane.add(panelCity, Integer.valueOf(1));
        layeredPane.add(priceLabel, Integer.valueOf(1));
        layeredPane.add(checkInLabel, Integer.valueOf(1));
        layeredPane.add(checkOutLabel, Integer.valueOf(1));
        layeredPane.add(cityInput, Integer.valueOf(1));
        layeredPane.add(priceInput, Integer.valueOf(1));
        layeredPane.add(roomTypesInput, Integer.valueOf(1));
        layeredPane.add(dateCheckIn, Integer.valueOf(1));
        layeredPane.add(dateCheckOut, Integer.valueOf(1));
        layeredPane.add(searchButton, Integer.valueOf(1));
        layeredPane.add(cancelButton, Integer.valueOf(1));


        
        
        
    	add(layeredPane);
        setVisible(true);
	}

	


}
