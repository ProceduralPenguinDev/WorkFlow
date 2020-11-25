import javax.swing.JButton;

interface ContentPanelButtonInterface {
	public void setIcon();
	void setClickedAction(JButton button);
	void setUpdateGraphicsOnPropertyChange(JButton button);
	void addActionListener(JButton button);
}
