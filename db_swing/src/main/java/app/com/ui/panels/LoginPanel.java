package main.java.app.com.ui.panels;

import javax.swing.JPanel;

import main.java.app.com.ui.customComponents.CustomCloseButton;
import main.java.app.com.ui.customComponents.CustomUsualButton;

public class LoginPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public LoginPanel() {
        
        setLayout(null);
        setBounds(100, 100, 200, 100);
        CustomUsualButton customButton = new CustomUsualButton("Click Me");
        customButton.setBounds(10, 50, customButton.getWidth(), customButton.getHeight());
        
        CustomCloseButton closeButton = new CustomCloseButton();
        closeButton.setBounds(10, 10, closeButton.getWidth(), closeButton.getHeight());
        
        add(customButton);
        add(closeButton);
        setVisible(true);
    
		
	}

}
