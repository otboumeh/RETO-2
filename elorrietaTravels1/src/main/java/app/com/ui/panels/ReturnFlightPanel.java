package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnFlightPanel extends JPanel{ 
	
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel returnDateLabel = new JLabel("Fecha de vuelta");
	private JLabel flightIdLabel = new JLabel("Código de vuelo");
	private JLabel returnAirlineLabel = new JLabel("Aerolinea de vuelta");
	private JLabel totalPriceLabel = new JLabel("Precio total");
	private JLabel returnTimeLabel = new JLabel("Horario de vuelta");
	private JLabel returnDurationLabel = new JLabel("Duración de vuelta");
	
	private JTextField flightIdInput = new JTextField();
	private JTextField returnAirlineInput = new JTextField();
	private JTextField totalPriceInput = new JTextField();
	private JTextField returnTimeInput = new JTextField();
	private JTextField returnDurationInput = new JTextField();
	private JLayeredPane layeredPane = new JLayeredPane();

	
public ReturnFlightPanel() {
        
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	
    	returnDateLabel.setBounds(600, 270, 250, 40);
    	returnDateLabel.setForeground(Color.BLACK);
    	returnDateLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	flightIdLabel.setBounds(600, 320, 250, 40);
    	flightIdLabel.setForeground(Color.BLACK);
    	flightIdLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	returnAirlineLabel.setBounds(600, 370, 250, 40);
    	returnAirlineLabel.setForeground(Color.BLACK);
    	returnAirlineLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	totalPriceLabel.setBounds(600, 420, 250, 40);
    	totalPriceLabel.setForeground(Color.BLACK);
    	totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	returnTimeLabel.setBounds(600, 470, 250, 40);
    	returnTimeLabel.setForeground(Color.BLACK);
    	returnTimeLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	returnDurationLabel.setBounds(600, 520, 250, 40);
    	returnDurationLabel.setForeground(Color.BLACK);
    	returnDurationLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    
    	flightIdInput.setBounds(858, 320, 200, 40);
    	returnAirlineInput.setBounds(858, 370, 200, 40);
    	totalPriceInput.setBounds(858, 420, 200, 40);
    	returnTimeInput.setBounds(858, 470, 200, 40);
    	returnDurationInput.setBounds(858, 520, 200, 40);
    	
        layeredPane.setBounds(0, 0, 1200, 800);        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(returnDateLabel, Integer.valueOf(1));
        layeredPane.add(flightIdLabel, Integer.valueOf(1));
        layeredPane.add(returnAirlineLabel, Integer.valueOf(1));
        layeredPane.add(totalPriceLabel, Integer.valueOf(1));
        layeredPane.add(returnTimeLabel, Integer.valueOf(1));
        layeredPane.add(returnDurationLabel, Integer.valueOf(1));
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
public JTextField getReturnAirlineInput() {
    return returnAirlineInput;
}
public JTextField getTotalPriceInput() {
    return totalPriceInput;
}
public JTextField getReturnTimeInput() {
    return returnTimeInput;
}
public JTextField getReturnDurationInput() {
    return returnDurationInput;
}
}
