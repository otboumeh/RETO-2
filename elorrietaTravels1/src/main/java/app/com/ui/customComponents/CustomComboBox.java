package main.java.app.com.ui.customComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomComboBox extends JComboBox<String> {


	private static final long serialVersionUID = 1L;

	public CustomComboBox(String[] items) {
        super(items);
        customizeLook();
    }

    private void customizeLook() {
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setBackground(Color.WHITE);
        setForeground(Color.DARK_GRAY);
        setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 1));
        setFocusable(false);

        setRenderer(new DefaultListCellRenderer() {
    
			private static final long serialVersionUID = 1L;

			@Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                label.setBorder(new EmptyBorder(5, 10, 5, 10));
                
                if (isSelected) {
                    label.setBackground(new Color(100, 149, 237));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(Color.WHITE);
                    label.setForeground(Color.DARK_GRAY);
                }
                
                return label;
            }
        });
    }

    public String getSelectedItemText() {
        return (String) getSelectedItem();
    }

    public void setSelectedItemByText(String item) {
        setSelectedItem(item);
    }
}
