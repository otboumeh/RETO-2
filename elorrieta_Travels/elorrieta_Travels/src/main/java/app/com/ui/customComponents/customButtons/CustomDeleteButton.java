package main.java.app.com.ui.customComponents.customButtons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * Clase personalizada para un boton de eliminar con icono de papelera
 * 
 * @author Grupo_01
 */
public class CustomDeleteButton extends JButton {

    /**
     * SerialVersionUID para la clase CustomDeleteButton
     */
	private static final long serialVersionUID = 1L;

    private Color startColor = new Color(255, 69, 58); 
    private Color endColor = new Color(200, 0, 0);   
    private boolean hover = false; 

    /**
     * Constructor que configura el boton
     */
	public CustomDeleteButton() {
		
        setPreferredSize(new Dimension(50, 50));  
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    /**
     * Metodo para pintar el boton con un fondo de gradiente y un icono de papelera
     * @param g objeto Graphics que se usa para pintar el boton
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, hover ? Color.RED : endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(0, 0, width, height);

        drawTrashIcon(g2d, width, height);

        g2d.dispose();
        super.paintComponent(g);
    }

    /**
     * Metodo para dibujar el icono de la papelera en el boton
     * @param g2d objeto Graphics2D utilizado para dibujar
     * @param width ancho del boton
     * @param height alto del boton
     */
    private void drawTrashIcon(Graphics2D g2d, int width, int height) {
        g2d.setColor(Color.WHITE);  
        int iconSize = width / 3;  
        int x = (width - iconSize) / 2;
        int y = (height - iconSize) / 2;

        int gap = 1; 

        g2d.fillRect(x , y + 4 + gap, iconSize, iconSize - 2);
        g2d.fillRect(x, y, iconSize, 4); 
        g2d.fillRect(x + (iconSize / 4), y - 3, iconSize / 2, 4); 
    }

}
