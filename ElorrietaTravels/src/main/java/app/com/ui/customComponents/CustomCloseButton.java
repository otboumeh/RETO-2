package main.java.app.com.ui.customComponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CustomCloseButton extends JButton{

	
	private static final long serialVersionUID = 1L;
	private Color normalColor = new Color(220, 20, 60); 
    private Color hoverColor = new Color(200, 0, 50); 
    private Color pressedColor = new Color(180, 0, 40);
    private Color currentColor = normalColor;

    public CustomCloseButton() {
        setSize(20, 20);
        setContentAreaFilled(false);
        setBorderPainted(false); 
        setFocusPainted(false); 
        setOpaque(false); 

        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                currentColor = hoverColor;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                currentColor = normalColor;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                currentColor = pressedColor;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentColor = hoverColor;
                repaint();
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(currentColor);
        g2.fillOval(0, 0, getWidth(), getHeight());

        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.WHITE);
        int padding = 7;
        g2.drawLine(padding, padding, getWidth() - padding, getHeight() - padding);
        g2.drawLine(getWidth() - padding, padding, padding, getHeight() - padding);

        g2.dispose();
    }

}
