package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.java.app.com.ui.customComponents.customButtons.CustomUsualButton;

public class LoginPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/loginBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel panelTitle = new JLabel("Login");
	private JLabel usernameLabel = new JLabel("Usuario");
	private JLabel passwordLabel = new JLabel("Contraseña");
	private JTextField usernameInput = new JTextField();
	private JTextField passwordInput = new JPasswordField();
	private JLayeredPane layeredPane = new JLayeredPane();
	
	private CustomUsualButton loginButton = new CustomUsualButton("Login");
	private CustomUsualButton newProfileButton = new CustomUsualButton("Nuevo Perfil");
	/*private CustomCloseButton closeButton = new CustomCloseButton();*/

	public LoginPanel() {
        
        setLayout(null);
        setBounds(0, 0, 1200, 800);
        
        
    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	panelTitle.setFont(new Font("Segoe UI", Font.BOLD, 60));
    	panelTitle.setForeground(Color.BLACK);
    	panelTitle.setBounds(0, 100, 1190, 200);
    	panelTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	panelTitle.setVerticalAlignment(SwingConstants.CENTER);
    	
    	usernameLabel.setBounds(420, 300, 150, 40);
    	usernameLabel.setForeground(Color.BLACK);
    	usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	passwordLabel.setBounds(420, 350, 150, 40);
    	passwordLabel.setForeground(Color.BLACK);
    	passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	usernameInput.setBounds(570, 300, 200, 40);
    	usernameInput.setBorder(BorderFactory.createCompoundBorder( usernameInput.getBorder(), new EmptyBorder(0, 10, 0, 0)));
    	passwordInput.setBounds(570, 350, 200, 40);   
    	passwordInput.setBorder(BorderFactory.createCompoundBorder( passwordInput.getBorder(), new EmptyBorder(0, 10, 0, 0)));
    	
        loginButton.setBounds(600, 450, loginButton.getWidth(), loginButton.getHeight());
        newProfileButton.setBounds(430, 450, newProfileButton.getWidth(), newProfileButton.getHeight());

    	
        layeredPane.setBounds(0, 0, 1200, 800);
        
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(panelTitle, Integer.valueOf(1)); 
        layeredPane.add(usernameLabel, Integer.valueOf(1));
        layeredPane.add(passwordLabel, Integer.valueOf(1));
        layeredPane.add(usernameInput, Integer.valueOf(1));
        layeredPane.add(passwordInput, Integer.valueOf(1));
        
        layeredPane.add(loginButton, Integer.valueOf(1));
        layeredPane.add(newProfileButton, Integer.valueOf(1));
        
    	add(layeredPane);
        setVisible(true);
	}
	
    public JTextField getUsernameInput() {
		return usernameInput;
	}

	public JTextField getPasswordInput() {
		return passwordInput;
	}

	public CustomUsualButton getLoginButton() {
		return loginButton;
	}
    
    public CustomUsualButton getNewProfileButton() {
		return newProfileButton;
	}

}
