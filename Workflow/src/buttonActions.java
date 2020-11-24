import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class buttonActions {
	
	public buttonActions(Component button, Color backgroundColor, Color mouseOnColor, Color clickedStateColor)
	{
		button.addMouseListener(new MouseAdapter() {
	        	public void mouseEntered(MouseEvent e) {
	        		button.setBackground(mouseOnColor);
	        	}
	        	public void mouseExited(MouseEvent e) {
	        		if(button.getBackground()==mouseOnColor)
	        			button.setBackground(backgroundColor);
	        		if(button.getBackground()==clickedStateColor)
	        			button.setBackground(backgroundColor);
	        	}
	        	public void mousePressed(MouseEvent e) {
	        		
	        			button.setBackground(clickedStateColor);
	        	}
	        	public void mouseReleased(MouseEvent e)
	        	{
	        		if(e.getSource()==Gui.newClass)
	        		{
	        			newClassAction();
	        		} else if(e.getSource()==Gui.close)
	        		{
	        			closeAction();	        		
	        			} else if(e.getSource()==Gui.minimize)
	        			{
	        				minimizeAction();
	        			} else if(e.getSource()==Gui.maximize)
	        				{
	        					maximizeAction();
	        				} else if(e.getComponent().getParent() == Gui.leftSidePanel)
	        				{
	        					if(e.getSource() != Gui.newClass)
	        					{
	        						for(int i = 0; i < Gui.ClassMap.size(); i++)
	        						{
	        							System.out.println(Gui.ClassMap.get(i).getName());
	        							if(e.getSource() == Gui.ClassMap.get(i).getButton())
	        							{
	        								//System.out.println("entered if logic");
	        								Gui.changePanelOnClick(Gui.ClassMap.get(i));
	        							} 
	        						}
	        					}
	        				}
	        		} 
			});
	}
	
	public void newClassAction()
	{
		new CustomShowInputDialog();
	}
	public void closeAction()
	{
		Gui.ParentFrame.dispose();
	}
	public void minimizeAction()
	{
        Gui.ParentFrame.setState(Frame.ICONIFIED);
	}
	public void maximizeAction()
	{
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize() + " " +  Gui.ParentFrame.getSize());
		Gui.ParentFrame.setState(Frame.MAXIMIZED_BOTH);
		if(Gui.ParentFrame.getSize().equals(new Dimension(Toolkit.getDefaultToolkit().getScreenSize())))
		{
			System.out.println("test2");
			Gui.ParentFrame.setSize(Gui.ParentFrame.getPreferredSize());
		} else {
		Gui.ParentFrame.setLocation(0,0);
		Gui.ParentFrame.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		}
	}
}
