package main.java.app.com.controllers;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.ui.panels.NewProfilePanel;

public class NewProfilePanelController {
	
	public NewProfilePanelController(){
		
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        
        newProfilePanel.getAgencyColorInput().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	colorInputBackground(); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	colorInputBackground(); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	colorInputBackground();
            }
        });
        
        newProfilePanel.getLogoInput().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	logoEvaluator(); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	logoEvaluator(); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	logoEvaluator();
            }
        });

        newProfilePanel.getCancelButton().addActionListener(e -> toLoginPanelButton());
        newProfilePanel.getSaveButton().addActionListener(e -> newProfileDataEvaluator());
	}
        
	private void toLoginPanelButton() {
		
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
		
        MainController.getInstance().hideAllPanels();
        MainController.getInstance().getLoginPanel().setVisible(true);
    	newProfilePanel.getAgencyNameInput().setText("");
    	newProfilePanel.getAgencyColorInput().setText("");
    	newProfilePanel.getNumEmployeesInput().setSelectedIndex(0);
    	newProfilePanel.getAgencyTypesInput().setSelectedIndex(0);
    	newProfilePanel.getLogoInput().setText("");
	}
	
    
   public static Color getComplementaryColor(String hexColor) {

	   Color originalColor = Color.decode(hexColor);

        int r = originalColor.getRed();
        int g = originalColor.getGreen();
        int b = originalColor.getBlue();

        int complementR = 255 - r;
        int complementG = 255 - g;
        int complementB = 255 - b;

        return new Color(complementR, complementG, complementB);
    }
	
	private boolean colorCodeEvaluator(String inputColor) {
		String colorRegex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
		return inputColor.matches(colorRegex);
	}
	
	
	private void colorInputBackground() {
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        String inputColor = newProfilePanel.getAgencyColorInput().getText().trim();
        
        if(colorCodeEvaluator(inputColor)) {
        	newProfilePanel.getAgencyColorInput().setBackground(Color.decode(inputColor));
        	newProfilePanel.getAgencyColorInput().setForeground(getComplementaryColor(inputColor));
        }else {
        	newProfilePanel.getAgencyColorInput().setBackground(Color.WHITE);
        	newProfilePanel.getAgencyColorInput().setForeground(Color.RED);

        }
	}
	
	private boolean numEmployeesEvaluator() {
		boolean ret = false;
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        if(newProfilePanel.getNumEmployeesInput().getSelectedIndex() != 0) {
        	ret = true;
        }
        return ret;
	}
	
	private boolean agencyTypeEvaluator() {
		boolean ret = false;
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        if(newProfilePanel.getAgencyTypesInput().getSelectedIndex() != 0) {
        	ret = true;
        }
        return ret;
	}
	
	
	private boolean urlCodeEvaluator(String inputURL) {
		String urlRegex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
		return inputURL.matches(urlRegex);
	}
	
	private void logoEvaluator() {
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        String inputLogo = newProfilePanel.getLogoInput().getText().trim();
        
        if(urlCodeEvaluator(inputLogo)) {
        	newProfilePanel.getLogoInput().setForeground(Color.BLACK);
        }else {
        	newProfilePanel.getLogoInput().setForeground(Color.RED);
        }
	}
	
	
	private void newProfileDataEvaluator() {
        NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
        String inputColor = newProfilePanel.getAgencyColorInput().getText().trim();
        String inputLogo = newProfilePanel.getLogoInput().getText().trim();
        
		if(colorCodeEvaluator(inputColor) && numEmployeesEvaluator() && agencyTypeEvaluator() && urlCodeEvaluator(inputLogo)) {
			////// add it to the database
			///and 
			toLoginPanelButton();
		}else {
	        JOptionPane.showMessageDialog(null, "Por Favor, Ingresa Datos Correctos en Todos los Campos", "Datos Incorrectos", JOptionPane.ERROR_MESSAGE);

		}
	}
	
}
