package main.java.app.com.ui.panels.newEventsSubpanels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ReturnFlightPanel extends JPanel{ 
	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel returnDateLabel = new JLabel("Fecha de vuelta");
	private JLabel flightIdLabel = new JLabel("Código de vuelo");
	private JLabel returnAirlineLabel = new JLabel("Aerolinea de vuelta");
	private JLabel totalPriceLabel = new JLabel("Precio total");
	private JLabel returnTimeLabel = new JLabel("Horario de vuelta");
	private JLabel returnDurationLabel = new JLabel("Duración de vuelta");
	private JDateChooser dateChooserReturn = new JDateChooser();

	private JTextField flightIdInput = new JTextField();
	private JTextField returnAirlineInput = new JTextField();
	private JTextField totalPriceInput = new JTextField();
	private JTextField returnTimeInput = new JTextField();
	private JTextField returnDurationInput = new JTextField();
	private JLayeredPane layeredPane = new JLayeredPane();

	
public ReturnFlightPanel() {
        setLayout(null);
        setBounds(0, 0, 550, 400);  
        setOpaque(false);

        int centerX = 20;
        int startY = 10;
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
    	flightIdInput.setBounds(centerX + labelWidth + 10, startY + 1 * (labelHeight + verticalSpacing), 300, labelHeight);
    	returnAirlineInput.setBounds(centerX + labelWidth + 10, startY + 2 * (labelHeight + verticalSpacing), 300, labelHeight);
    	totalPriceInput.setBounds(centerX + labelWidth + 10, startY + 3 * (labelHeight + verticalSpacing), 300, labelHeight);
    	returnTimeInput.setBounds(centerX + labelWidth + 10, startY + 4 * (labelHeight + verticalSpacing), 300, labelHeight);
    	returnDurationInput.setBounds(centerX + labelWidth + 10, startY + 5 * (labelHeight + verticalSpacing), 300, labelHeight);
    	
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
