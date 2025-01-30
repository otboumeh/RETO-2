package main.java.app.com.controllers;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.ui.panels.TripsAndEventsPanel;

public class TripsAndEventsPanelController {
	AgenciaDAO agenciaDAO = new AgenciaDAO();
    
    public TripsAndEventsPanelController() {
        TripsAndEventsPanel tripsAndEventsPanel = MainController.getInstance().getTripsAndEventsPanel();

        tripsAndEventsPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                String user = tripsAndEventsPanel.getUser();
                Agencia agencia = new Agencia();
                ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies(); 
                for(Agencia agency : agencias) {
                	if(agency.getNomAgencia().equalsIgnoreCase(user)) {
                		agencia = agency;
                		break;
                	}
                }
                tripsAndEventsPanel.getWelcomeTxt().setText("Welcome Back " + user);
                changeImage(tripsAndEventsPanel.getLogoLabel(), agencia.getLogo());
                
            }
        });
    }
    
    public static void resizeImageToLabel(JLabel label, ImageIcon icon) {
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        Image resizedImage = icon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(resizedImage));
    }
    
    public static void changeImage(JLabel label, String imageUrl) {
        try {
            URL url = new URL(imageUrl);

            Image logo = ImageIO.read(url);

            ImageIcon logoIcon = new ImageIcon(logo);
            resizeImageToLabel(label, logoIcon);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage());
        }
    }
}
