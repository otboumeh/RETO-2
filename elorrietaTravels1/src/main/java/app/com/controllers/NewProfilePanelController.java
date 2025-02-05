package main.java.app.com.controllers;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.java.app.com.controllers.mainController.MainController;
import main.java.app.com.database.dao.AgenciaDAO;
import main.java.app.com.database.models.Agencia;
import main.java.app.com.ui.panels.NewProfilePanel;

public class NewProfilePanelController {
    NewProfilePanel newProfilePanel = MainController.getInstance().getNewProfilePanel();
    AgenciaDAO agenciaDAO = new AgenciaDAO();
	
	public NewProfilePanelController(){
		        
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
        
        newProfilePanel.getAgencyPasswordInput().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	passwordEvaluator(); 
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	passwordEvaluator(); 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	passwordEvaluator();
            }
        });

        newProfilePanel.getCancelButton().addActionListener(e -> toLoginPanelButton());
        newProfilePanel.getSaveButton().addActionListener(e -> newProfileDataEvaluator());
	}
        
	private void toLoginPanelButton() {
				
        MainController.getInstance().hideAllPanels();
        MainController.getInstance().getLoginPanel().setVisible(true);
    	newProfilePanel.getAgencyNameInput().setText("");
    	newProfilePanel.getAgencyColorInput().setText("");
    	newProfilePanel.getNumEmployeesInput().setSelectedIndex(0);
    	newProfilePanel.getAgencyTypesInput().setSelectedIndex(0);
    	newProfilePanel.getLogoInput().setText("");
	}
	
	private boolean passwordEvaluator() {
		boolean ret = false; 
        String inputPass = newProfilePanel.getAgencyPasswordInput().getText();
        String upperRegex = ".*[A-Z].*";
        String symbolRegex = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>?/`~].*";
        String numberRegex = ".*[0-9].*";
        
		if(!inputPass.matches(upperRegex)) {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		}else if(!inputPass.matches(symbolRegex)){
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		}else if(!inputPass.matches(numberRegex)){
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.RED);
		}else {
			newProfilePanel.getAgencyPasswordInput().setForeground(Color.BLACK);
			ret = true;
		}
		return ret;
	}
	
    
   private Color getComplementaryColor(String hexColor) {

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
        if(newProfilePanel.getNumEmployeesInput().getSelectedIndex() != 0) {
        	ret = true;
        }
        return ret;
	}
	
	private boolean agencyTypeEvaluator() {
		boolean ret = false;
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
        String inputLogo = newProfilePanel.getLogoInput().getText().trim();
        
        if(urlCodeEvaluator(inputLogo)) {
        	newProfilePanel.getLogoInput().setForeground(Color.BLACK);
        }else {
        	newProfilePanel.getLogoInput().setForeground(Color.RED);
        }
	}

	private static String incrementString(String input) {
		String prefix = input.replaceAll("[0-9]", "");
		String numberPart = input.replaceAll("[^0-9]", "");
		int number = Integer.parseInt(numberPart) + 1;
		String newNumberPart = String.format("%0" + numberPart.length() + "d", number);
		return prefix + newNumberPart;
	}
	
	private String getIdLastAgency() {
		String ret = null;
		ArrayList<Agencia> agencias = agenciaDAO.getAllAgencies();
		ret = agencias.get(agencias.size()-1).getIdAgencia();
		return ret;
	}
	
	private void newProfileDataEvaluator() {
		String idAgencia = incrementString(getIdLastAgency());
        String inputName = newProfilePanel.getAgencyNameInput().getText();
        String inputPass = newProfilePanel.getAgencyPasswordInput().getText();
        String inputTipo = (String) newProfilePanel.getAgencyTypesInput().getSelectedItem();
        String inputNumEmp = (String) newProfilePanel.getNumEmployeesInput().getSelectedItem();
        String inputColor = newProfilePanel.getAgencyColorInput().getText();
        String inputLogo = newProfilePanel.getLogoInput().getText();
        
        Agencia newAgencia = new Agencia();
        newAgencia.setIdAgencia(idAgencia);
        newAgencia.setNomAgencia(inputName);
        newAgencia.setPass(inputPass);
        newAgencia.setTipoAgencia(inputTipo);
        newAgencia.setNumEmp(inputNumEmp);
        newAgencia.setColorAgencia(inputColor);
        newAgencia.setLogo(inputLogo);

        
		if(!passwordEvaluator()) {
	        JOptionPane.showMessageDialog(null, "La contraseña debe contener MAYUSCULAS, Symbolos y Numeros", "Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
		}else if(!colorCodeEvaluator(inputColor) || !numEmployeesEvaluator() || !agencyTypeEvaluator() || !urlCodeEvaluator(inputLogo)) {
	        JOptionPane.showMessageDialog(null, "Alguno de los datos ingresados no son correctos.", "Datos Incorrectos", JOptionPane.ERROR_MESSAGE);
		}else {
			agenciaDAO.addAgencyToDB(newAgencia);
			toLoginPanelButton();
		}
	}
	
}
