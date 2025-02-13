package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import main.java.app.com.ui.customComponents.customButtons.CustomDeleteButton;
import main.java.app.com.ui.customComponents.customButtons.CustomSignOutButton;
import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class TripsAndEventsPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private String[] tripsCulumns = {"Viaje", "Tipo", "Días", "Fecha Inicio", "Fecha Fin", "País"};
	private String[] eventsCulumns = {"Nombre Evento", "Tipo", "Fecha", "Precio"};

	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	
	private String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg/1920px-Bhaga_River_Darcha_Gemur_Lahaul_Jun24_A7CR_00231.jpg";
    private Image logo;
    private ImageIcon logoIcon = new ImageIcon();
	private JLabel logoLabel = new JLabel();
	
	private JLabel panelTitle = new JLabel("Viajes y Eventos");
	private JLabel welcomeTxt = new JLabel("hello");
	
	 //// trips table
    private JPanel tripsListPanel = new JPanel();;
    private DefaultTableModel tripsTableModel = new DefaultTableModel(tripsCulumns, 0);

	private JTable tripsTable = new JTable(tripsTableModel);
	private JTableHeader tripsHeader = tripsTable.getTableHeader();
	private DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	private JScrollPane tripsScrollPane = new JScrollPane(tripsTable);
    ///////
	
	////////events table
	
    private JPanel eventsListPanel = new JPanel();;
    private DefaultTableModel eventsTableModel = new DefaultTableModel(eventsCulumns, 0);

	private JTable eventsTable = new JTable(eventsTableModel);
	private JTableHeader eventsHeader = eventsTable.getTableHeader();
	private JScrollPane eventsScrollPane = new JScrollPane(eventsTable);
	//////////////
	
	private CustomUsualButton generateOfferButton = new CustomUsualButton("Generar Oferta");
	private CustomUsualButton newTripButton = new CustomUsualButton("Nuevo Viaje");
	private CustomUsualButton newEventButton = new CustomUsualButton("Nuevo Evento");
	private CustomSignOutButton signOutButton = new CustomSignOutButton("Desconectar");
	private CustomDeleteButton tripDeleteButton = new CustomDeleteButton();
	private CustomDeleteButton eventDeleteButton = new CustomDeleteButton();

    
	private String user = null;
	private String userId = null;

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
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
        }
    	logoLabel.setBounds(1000, 0, 200, 200);
    	
    	panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
    	panelTitle.setForeground(Color.BLACK);
    	panelTitle.setBounds(0, 50, 950, 150);
    	panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	panelTitle.setVerticalAlignment(SwingConstants.CENTER);
    	
    	welcomeTxt.setBounds(0, 0, 950, 100);
    	welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
    	welcomeTxt.setVerticalAlignment(SwingConstants.CENTER);
    	welcomeTxt.setForeground(Color.BLACK);
    	welcomeTxt.setText(user);
    	welcomeTxt.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	/////////////////trips 
    	tripsListPanel.setLayout(null);
    	tripsHeader.setFont(new Font("Arial", Font.BOLD, 12));
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tripsTable.getColumnCount(); i++) {
            tripsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tripsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    	tripsScrollPane.setBounds(1, 0, 789, 200);
    	tripsListPanel.setBounds(100, 200, 790, 200);
    	tripsListPanel.add(tripsScrollPane);
    	
    	////////////////////
    	
    	//////////////events
    	eventsListPanel.setLayout(null);
    	eventsHeader.setFont(new Font("Arial", Font.BOLD, 12));
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < eventsTable.getColumnCount(); i++) {
            eventsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        eventsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    	eventsScrollPane.setBounds(1, 0, 789, 200);
    	eventsListPanel.setBounds(100, 420, 790, 200);
    	eventsListPanel.add(eventsScrollPane);
    	//////////////////////
    	
    	
    	generateOfferButton.setBounds(690, 670, 200, generateOfferButton.getHeight());
    	newTripButton.setBounds(1020, 220, 150, generateOfferButton.getHeight());
    	newEventButton.setBounds(1020, 270, 150, generateOfferButton.getHeight());
    	signOutButton.setBounds(100, 670, 200, generateOfferButton.getHeight());
    	tripDeleteButton.setBounds(900, 200, 30, 30);
    	eventDeleteButton.setBounds(900, 420, 30, 30);
    	
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(welcomeTxt, Integer.valueOf(1));
        layeredPane.add(panelTitle, Integer.valueOf(1)); 
        layeredPane.add(logoLabel, Integer.valueOf(1));
        layeredPane.add(tripsListPanel, Integer.valueOf(1));
        layeredPane.add(eventsListPanel, Integer.valueOf(1));
        layeredPane.add(generateOfferButton, Integer.valueOf(1));
        layeredPane.add(newTripButton, Integer.valueOf(1));
        layeredPane.add(newEventButton, Integer.valueOf(1));
        layeredPane.add(signOutButton, Integer.valueOf(1));
        layeredPane.add(tripDeleteButton, Integer.valueOf(2));
        layeredPane.add(eventDeleteButton, Integer.valueOf(2));
        
    	add(layeredPane);
        setVisible(true);
	}
	
	public JTable getTripsTable() {
		return tripsTable;
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
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public JLabel getWelcomeTxt() {
		return welcomeTxt;
	}

    public JLabel getPanelTitle() {
		return panelTitle;
	}

	public DefaultTableModel getTripsTableModel() {
		return tripsTableModel;
	}

	public DefaultTableModel getEventsTableModel() {
		return eventsTableModel;
	}

	public JTable getEventsTable() {
		return eventsTable;
	}

	public CustomUsualButton getNewTripButton() {
		return newTripButton;
	}

	public CustomUsualButton getNewEventButton() {
		return newEventButton;
	}

	public CustomSignOutButton getSignOutButton() {
		return signOutButton;
	}

	public CustomDeleteButton getTripDeleteButton() {
		return tripDeleteButton;
	}

	public CustomDeleteButton getEventDeleteButton() {
		return eventDeleteButton;
	}

	public CustomUsualButton getGenerateOfferButton() {
		return generateOfferButton;
	}
	
    
}
