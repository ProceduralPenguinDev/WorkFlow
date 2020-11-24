import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class changeIcon {
	
	
	
	public void setIconAndFormat(String filePath, JButton button, Color bgrndColor)
	{
		button.setIcon(new ImageIcon(filePath));
		//button.setOpaque(false);
		//button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setBackground(bgrndColor);
	}
	public void format(JButton button, Color bgrndColor)
	{
		//button.setOpaque(false);
		//button.setContentAreaFilled(false);
		button.setBorderPainted(true);
		button.setFocusPainted(false);
		button.setBackground(bgrndColor);
		button.setForeground(new Color(255,255,255));
		button.setFont(new Font(Font.SANS_SERIF,50,25));
		button.setMaximumSize(new Dimension(100,200));
	}
	public void setIconAndStyleCheckBox(String normalIconPath, JCheckBox button, String clickedIconPath)
	{
		button.setIcon(new ImageIcon(normalIconPath));
		button.setPressedIcon(new ImageIcon(clickedIconPath));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
}
