import java.awt.GridBagConstraints;

public class layoutConstraintManager {
	
	public void setTitleLayoutConstraints(GridBagConstraints gblc)
	{
        gblc.weightx = 1;
        gblc.weighty = 1;
        gblc.fill = GridBagConstraints.HORIZONTAL;
        gblc.anchor = GridBagConstraints.WEST;
        gblc.gridx = 0;
        gblc.gridy = 0;
	}
	
	public void setMinimizeLayoutConstraints(GridBagConstraints gblc)
	{
		gblc.gridx = 1;
		
	}
	public void setMaximizeLayoutConstraints(GridBagConstraints gblc)
	{
		gblc.gridx = 2;
		
	}
	public void setCloseLayoutConstraints(GridBagConstraints gblc)
	{
		gblc.gridx = 3;
		gblc.gridwidth = GridBagConstraints.REMAINDER;
		
	}

}
