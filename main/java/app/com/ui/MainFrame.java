package main.java.app.com.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.app.com.ui.components.CustomButton;

public class MainFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
    	 setTitle("My Application");
         setSize(1000, 800); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setLayout(null);
         
         ///adding panels
         JPanel panel = new JPanel();
         panel.setBounds(100, 100, 200, 100);
         CustomButton customButton = new CustomButton("Click Me");
         panel.add(customButton);
         add(panel);
         
         setResizable(false);
         setVisible(true);
    }

}
