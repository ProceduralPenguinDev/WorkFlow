import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Class {
	
	private String name;
	private String startTime;
	private String endTime;
	private JPanel viewPanel;
	private JButton referenceButton;
	private Map<String, Boolean> dayBooleanMap = new HashMap<String, Boolean>();
	
	public Class(String namePass, String startTimePass, String endTimePass, Map<String, Boolean> dayBooleanMapPass)
	{
		ArrayList <String> filePaths = new ArrayList<String>();
		ArrayList <String> urls = new ArrayList<String>();
		dayBooleanMap = dayBooleanMapPass;
		name = namePass;
		startTime = startTimePass;
		endTime = endTimePass;
		viewPanel = new JPanel();
		formatContentPanel.format(viewPanel, name, startTime, endTime);
		viewPanel.add(new JLabel(name));
		viewPanel.add(new JLabel(startTime));
		viewPanel.add(new JLabel(endTime));
		//viewPanel.add(new JLabel("Sunday: " + dayBooleanMap.get("Sunday") + " Monday: " + dayBooleanMap.get("Monday") + " Tuesday: " + dayBooleanMap.get("Tuesday") + " Wednesday: " + dayBooleanMap.get("Wednesday") + " Thursday: " + dayBooleanMap.get("Thursday") + " Friday: " + dayBooleanMap.get("Friday") + " Saturday: " + dayBooleanMap.get("Saturday")));
		referenceButton = new JButton(name);
	}	
	public JButton getButton()
	{
		return this.referenceButton;
	}
	public String getName()
	{
		return this.name;
	}
	public String getStartTime()
	{
		return this.startTime;
	}
	public String getEndTime()
	{
		return this.endTime;
	}
	public JPanel getViewPanel()
	{
		return this.viewPanel;
	}
	public Boolean getSundaySelected()
	{
		return this.dayBooleanMap.get("Sunday");
	}
	public Boolean getMondaySelected()
	{
		return this.dayBooleanMap.get("Monday");
	}
	public Boolean getTuesdaySelected()
	{
		return this.dayBooleanMap.get("Tuesday");
	}
	public Boolean getWednesdaySelected()
	{
		return this.dayBooleanMap.get("Wednesday");
	}
	public Boolean getThursdaySelected()
	{
		return this.dayBooleanMap.get("Thursday");
	}
	public Boolean getFridaySelected()
	{
		return this.dayBooleanMap.get("Friday");
	}
	public Boolean getSaturdaySelected()
	{
		return this.dayBooleanMap.get("Saturday");
	}
}
