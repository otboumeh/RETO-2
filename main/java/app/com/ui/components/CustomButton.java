package main.java.app.com.ui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CustomButton extends JButton {
    private Color startColor = new Color(30, 144, 255);  // Light Blue (Default)
    private Color endColor = new Color(65, 105, 225);    // Dark Blue (Default)
    
    private Color hoverStartColor = new Color(50, 170, 255);  // Brighter Blue (Hover)
    private Color hoverEndColor = new Color(80, 130, 255);    // Brighter Dark Blue (Hover)
    
    private Color pressedStartColor = new Color(0, 102, 204);  // Dark Blue (Pressed)
    private Color pressedEndColor = new Color(0, 82, 184);     // Even Darker Blue (Pressed)

    private boolean isHovered = false;
    private boolean isPressed = false;
    private int cornerRadius = 15; // Rounded corners

    public CustomButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));

        // Mouse interactions
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Select gradient colors based on button state
        Color start = isPressed ? pressedStartColor : (isHovered ? hoverStartColor : startColor);
        Color end = isPressed ? pressedEndColor : (isHovered ? hoverEndColor : endColor);

        // Apply gradient
        GradientPaint gradient = new GradientPaint(0, 0, start, getWidth(), getHeight(), end);
        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g);
        g2.dispose();
    }

}
