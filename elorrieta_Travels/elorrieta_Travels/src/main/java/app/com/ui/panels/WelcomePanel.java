package main.java.app.com.ui.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * La clase de Panel del panel Login
 * 
 * @author Grupo_01
 */
public class WelcomePanel extends JPanel{

    private static final long serialVersionUID = 1L;
    
	private ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/welcomeBackground.jpg");
	private JLabel backgroundLabel = new JLabel(backgroundImage);
	private JLabel welcomeText = new JLabel("Bienvenidas");
	private JLayeredPane layeredPane = new JLayeredPane();

	/**
	 * Constructor del panel con los componentes
	 */
    public WelcomePanel() {
    	
    	setLayout(null);
    	setBounds(0, 0, 1200, 800);

    	backgroundLabel.setBounds(0, 0, 1200, 800);
    	
    	welcomeText.setFont(new Font("Segoe UI", Font.BOLD, 60));
    	welcomeText.setForeground(Color.WHITE);
    	welcomeText.setBounds(0, 0, 1190, 790);
    	welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
    	welcomeText.setVerticalAlignment(SwingConstants.CENTER);
    	
        layeredPane.setBounds(0, 0, 1200, 800);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(welcomeText, Integer.valueOf(1)); 
    	
    	add(layeredPane);
    	setVisible(true);
    }

    /**
     * Obtiene la etiqueta de fondo del panel.
     *
     * @return Retorna un `JLabel` que representa la imagen de fondo.
     */
	public JLabel getBackgroundLabel() {
		return backgroundLabel;
	}
}
