package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TripsAndEventsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	
	private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg/1920px-Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg";
    private Image logo;
    private ImageIcon logoIcon = new ImageIcon();
	private JLabel logoLabel = new JLabel();
	
	private JLabel panelTitle = new JLabel("Viajes y Eventos");
	private JLabel welcomeTxt = new JLabel("hello");

	private String user = null;

	private JLayeredPane layeredPane = new JLayeredPane();

	
	public TripsAndEventsPanel() {
		 
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	try {
            URL url = new URL(imageUrl);
            logo = ImageIO.read(url);
            logoIcon = new ImageIcon(logo);
            logoLabel.setIcon(logoIcon);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage());
        }
    	logoLabel.setBounds(1000, 0, 200, 200);
    	
    	panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
    	panelTitle.setForeground(Color.BLACK);
    	panelTitle.setBounds(0, 100, 1190, 200);
    	panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	panelTitle.setVerticalAlignment(SwingConstants.CENTER);
    	
    	welcomeTxt.setBounds(0, 0, 1200, 200);
    	welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
    	welcomeTxt.setVerticalAlignment(SwingConstants.CENTER);
    	welcomeTxt.setForeground(Color.BLACK);
    	welcomeTxt.setText(user);
    	welcomeTxt.setFont(new Font("Arial", Font.BOLD, 20));
    	
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(welcomeTxt, Integer.valueOf(1));
        layeredPane.add(panelTitle, Integer.valueOf(1)); 
        layeredPane.add(logoLabel, Integer.valueOf(1));
        
    	add(layeredPane);
        setVisible(true);
	}
	
	

	public JLabel getLogoLabel() {
		return logoLabel;
	}

	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
	    this.user = user;
	    welcomeTxt.setText("Hello, " + user);
	    repaint(); 
	    revalidate();
	}
	public JLabel getWelcomeTxt() {
		return welcomeTxt;
	}

}
