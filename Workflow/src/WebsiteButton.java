import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.*;

public class WebsiteButton implements ContentPanelButtonInterface{

	public WebsiteButton(String name, String path) {
		JButton websiteButton = new JButton(name);
		setIcon();
		setClickedAction(websiteButton);
	}
	
	@Override
	public void setIcon() {
		
	}

	@Override
	public void addActionListener(JButton button)
	{
//		button.addMouseListener(new MouseAdapter() {
//			
//		});
		setClickedAction(button);
	}
	
	@Override
	public void setClickedAction(JButton button) {
		
	}

	@Override
	public void setUpdateGraphicsOnPropertyChange(JButton button)
	{
		buttonActions changeButtonProperties = new buttonActions(button, new Color(255,255,255), new Color(240,240,240), new Color(250,250,250));
	}

}
