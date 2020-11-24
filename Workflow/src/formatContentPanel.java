import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class formatContentPanel {
	
	static Font titleFont = new Font(Font.SANS_SERIF,Font.BOLD,50);
	static GridBagLayout layoutManager = new GridBagLayout();
	static GridBagConstraints layoutManagerConstraints = new GridBagConstraints();
	

	public static void format(JPanel viewPanel, String name, String startTime, String endTime) {
		
		viewPanel.setLayout(layoutManager);
		
	}

}
