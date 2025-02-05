package main.java.app.com.ui.customComponents.customButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomBackButton extends JButton {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color startColor = new Color(30, 144, 255);
    private Color endColor = new Color(65, 105, 225);
    private Color hoverStartColor = new Color(50, 170, 255);
    private Color hoverEndColor = new Color(80, 130, 255);
    private Color pressedStartColor = new Color(0, 102, 204);
    private Color pressedEndColor = new Color(0, 82, 184);
    
    private boolean isHovered = false;
    private boolean isPressed = false;

    public CustomBackButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setMargin(new Insets(0, 0, 0, 0));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 25));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            GradientPaint gradient;
            if (isPressed) {
                gradient = new GradientPaint(0, 0, pressedStartColor, getWidth(), getHeight(), pressedEndColor);
            } else if (isHovered) {
                gradient = new GradientPaint(0, 0, hoverStartColor, getWidth(), getHeight(), hoverEndColor);
            } else {
                gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
            }
            
            g2.setPaint(gradient);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
            
        }
        super.paintComponent(g);
    }
}
