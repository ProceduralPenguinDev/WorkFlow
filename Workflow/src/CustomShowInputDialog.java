import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.MaskFormatter;

public class CustomShowInputDialog
{
    static MetalLookAndFeel metal;
    resizingLogic resize = new resizingLogic();
    GridBagConstraints inputPanelLayoutConstraints;
	String name, endTime, startTime;	
	static JCheckBox monday = new JCheckBox();
	static JCheckBox tuesday = new JCheckBox();
	static JCheckBox wednesday = new JCheckBox();
	static JCheckBox thursday = new JCheckBox();
	static JCheckBox friday = new JCheckBox();
	static JCheckBox saturday = new JCheckBox();
	static JCheckBox sunday = new JCheckBox();
	MaskFormatter hourMask = null;
	MaskFormatter minuteMask = null;
	



	public CustomShowInputDialog()
	{
		String timeHour = LocalTime.now().toString().substring(0, 2);
		String timeMinute = LocalTime.now().toString().substring(3, 5);
		JFrame inputFrame = new JFrame();
		JPanel inputPanel = new JPanel();
		JLabel colon1 = new JLabel(":");
		JLabel colon2 = new JLabel(":");	
		JLabel startTimeLabel = new JLabel("Start Time: ");
		JLabel endTimeLabel = new JLabel("End Time: ");
		try {
			hourMask = new MaskFormatter("##");
			hourMask.setPlaceholder(timeHour);
			minuteMask = new MaskFormatter("##");
			minuteMask.setPlaceholder(timeMinute);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		JTextField nameInput = new JTextField();
		JFormattedTextField startTimeHourInput = new JFormattedTextField(hourMask);
		JFormattedTextField startTimeMinuteInput = new JFormattedTextField(minuteMask);
		JFormattedTextField endTimeHourInput = new JFormattedTextField(hourMask);
		JFormattedTextField endTimeMinuteInput = new JFormattedTextField(minuteMask);
		
		JButton submit = new JButton("Done");
		String[] AMPM = {"AM","PM"};
		
		JPanel dayButtonPanel = new JPanel();
		
		 metal = new MetalLookAndFeel();
 	    MetalLookAndFeel.setCurrentTheme(new MetalThemeExtension());
 	    try {
 	      UIManager.setLookAndFeel(metal);
 	    }
 	    catch(UnsupportedLookAndFeelException e) {
 	      e.printStackTrace();
 	    }
 	    
 	    JComboBox<String> AMPM1 = new JComboBox<String>(AMPM);
		JComboBox<String> AMPM2 = new JComboBox<String>(AMPM);
 	    AMPM1.update(AMPM1.getGraphics());
		AMPM2.update(AMPM2.getGraphics());
 	    
 	    inputFrame.setUndecorated(true);
 	    inputFrame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
 	    inputPanel.setBackground(Color.WHITE);
 	    
 	    //resizingLogic resize = new resizingLogic(inputFrame);
 	    
 	    GridBagLayout inputPanelLayout = new GridBagLayout();
 	    inputPanelLayoutConstraints = new GridBagConstraints();
 	    
 	    inputPanel.setLayout(inputPanelLayout);
 	    
 	    inputFrame.setLocation((int)Gui.ParentFrame.getWidth()/2 - (int)Gui.ParentFrame.getWidth()/4, (int)Gui.ParentFrame.getHeight()/2 - (int)Gui.ParentFrame.getHeight()/4);
 	    
// 	    addTimeMouseListener(startTimeInput);
// 	    addTimeMouseListener(endTimeInput);
 	    nameInput.setPreferredSize(new Dimension(200,40));
 	    submit.setPreferredSize(new Dimension(150,40));
 	    formatTimeBox(startTimeHourInput);
 	    formatTimeBox(startTimeMinuteInput);
 	    formatTimeBox(endTimeHourInput);
 	    formatTimeBox(endTimeMinuteInput);
 	    AMPM1.setSelectedIndex(0);
 	    AMPM2.setSelectedIndex(0);
 	    
// 	    startTimeLabel.setVerticalTextPosition(JLabel.NORTH);
// 	   startTimeLabel.setHorizontalTextPosition(JLabel.LEFT);
 	    changeIcon iconChanger = new changeIcon();
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Sunday.png", sunday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\SundayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Monday.png", monday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\MondayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Tuesday.png", tuesday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\TuesdayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Wednesday.png", wednesday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\WednesdayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Tuesday.png", thursday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\TuesdayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Friday.png", friday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\FridayClicked.png");
 	    iconChanger.setIconAndStyleCheckBox("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Sunday.png", saturday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\SundayClicked.png");
 	    
 	    Color buttonAfterClick = new Color(189,16,0);
 	    Color buttonClicked = new Color(220,16,0);
// 	    buttonActions sundayStateChanger = new buttonActions(sunday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions mondayStateChanger = new buttonActions(monday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions tuesdayStateChanger = new buttonActions(tuesday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions wednesdayStateChanger = new buttonActions(wednesday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions thurdayStateChanger = new buttonActions(thursday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions fridayStateChanger = new buttonActions(friday, Color.WHITE,buttonAfterClick,buttonClicked);
// 	    buttonActions saturdayStateChanger = new buttonActions(saturday, Color.WHITE,buttonAfterClick,buttonClicked);
 	    
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Sunday.png", sunday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\SundayClicked.png");         
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Monday.png", monday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\MondayClicked.png");         
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Tuesday.png", tuesday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\TuesdayClicked.png");      
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Wednesday.png", wednesday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\WednesdayClicked.png");
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Tuesday.png", thursday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\TuesdayClicked.png");     
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Friday.png", friday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\FridayClicked.png");         
 	    changeColorOnClick("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\Sunday.png", saturday, "X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\SundayClicked.png");       
 	    
 	    dayButtonPanel.setBackground(Color.white);
 	    dayButtonPanel.add(sunday);
 	    dayButtonPanel.add(monday);
 	    dayButtonPanel.add(tuesday);
 	    dayButtonPanel.add(wednesday);
 	    dayButtonPanel.add(thursday);
 	    dayButtonPanel.add(friday);
 	    dayButtonPanel.add(saturday);
 	    
		nameInput.setFont(new Font(Font.SANS_SERIF,50,25));
		nameInput.setHorizontalAlignment(JTextField.CENTER);
 	    nameInput.setText("Name");
 	    addFocusListenerToNameBox(nameInput);
 	    
 	    addMouseListener(inputFrame,submit,nameInput,startTimeHourInput,startTimeMinuteInput,AMPM1,endTimeHourInput,endTimeMinuteInput,AMPM2);
		
 	    formatNameLayout();
 	    inputPanel.add(nameInput, inputPanelLayoutConstraints);
 	    formatLabelStartTimeLayout();
 	    inputPanel.add(startTimeLabel, inputPanelLayoutConstraints);
 	    formatHourStartTimeLayout();
 	    inputPanel.add(startTimeHourInput, inputPanelLayoutConstraints);
 	    formatColonStartTimeLayout();
 	    inputPanel.add(colon1, inputPanelLayoutConstraints);
 	    formatMinuteStartTimeLayout();
 	    inputPanel.add(startTimeMinuteInput, inputPanelLayoutConstraints);
 	    formatAMPMStartTimeLayout();
 	    inputPanel.add(AMPM1, inputPanelLayoutConstraints);
 	    formatLabelEndTimeLayout();
 	    inputPanel.add(endTimeLabel, inputPanelLayoutConstraints);
 	    formatHourEndTimeLayout();
 	    inputPanel.add(endTimeHourInput, inputPanelLayoutConstraints);
 	    formatColonEndTimeLayout();
	    inputPanel.add(colon2, inputPanelLayoutConstraints);
 	    formatMinuteEndTimeLayout();
	    inputPanel.add(endTimeMinuteInput, inputPanelLayoutConstraints);
	    formatAMPMEndTimeLayout();
 	    inputPanel.add(AMPM2, inputPanelLayoutConstraints);
 	    formatDayButtonPanelLayout();
 	    inputPanel.add(dayButtonPanel, inputPanelLayoutConstraints);
 	    formatSubmitButtonLayout();
 	    inputPanel.add(submit, inputPanelLayoutConstraints);
// 	    inputPanel.add(monday);
// 	    inputPanel.add(tuesday);
// 	    inputPanel.add(wednesday);
// 	    inputPanel.add(thursday);
// 	    inputPanel.add(friday);
// 	    inputPanel.add(saturday);
// 	    inputPanel.add(sunday);
 	    
 	  
 	    inputFrame.add(inputPanel);
 	    resize.sizePopUps(inputPanel);
 	    resize.resizePopUp("New Class",inputFrame);
 	    
 	    inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 	    inputFrame.pack();
 	    inputFrame.show();
		
	}
	
	public void formatNameLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(5,5,20,5);
		inputPanelLayoutConstraints.gridx = 0;
		inputPanelLayoutConstraints.gridy = 0;
		inputPanelLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
		
	}
	public void formatLabelStartTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 3;
		inputPanelLayoutConstraints.gridy = 1;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		inputPanelLayoutConstraints.anchor = GridBagConstraints.CENTER;
	}
	public void formatHourStartTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 4;
		inputPanelLayoutConstraints.gridy = 1;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatColonStartTimeLayout()
	{
		inputPanelLayoutConstraints.gridx = 5;
		inputPanelLayoutConstraints.gridy = 1;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatMinuteStartTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 6;
		inputPanelLayoutConstraints.gridy = 1;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatAMPMStartTimeLayout()
	{
		inputPanelLayoutConstraints.gridx = 7;
		inputPanelLayoutConstraints.gridy = 1;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatLabelEndTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 3;
		inputPanelLayoutConstraints.gridy = 2;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatHourEndTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 4;
		inputPanelLayoutConstraints.gridy = 2;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatColonEndTimeLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(0,0,0,0);
		inputPanelLayoutConstraints.gridx = 5;
		inputPanelLayoutConstraints.gridy = 2;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatMinuteEndTimeLayout()
	{
		inputPanelLayoutConstraints.gridx = 6;
		inputPanelLayoutConstraints.gridy = 2;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatAMPMEndTimeLayout()
	{
		inputPanelLayoutConstraints.gridx = 7;
		inputPanelLayoutConstraints.gridy = 2;
		inputPanelLayoutConstraints.gridwidth = 1;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.BOTH;
		//inputPanelLayoutConstraints.anchor = GridBagConstraints.NORTHWEST;
	}
	public void formatDayButtonPanelLayout()
	{
		inputPanelLayoutConstraints.gridx = 0;
		inputPanelLayoutConstraints.gridy = 4;
		inputPanelLayoutConstraints.gridwidth = 8;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		inputPanelLayoutConstraints.insets = new Insets(10, 0, 0, 0);

	}
	public void formatSubmitButtonLayout()
	{
		inputPanelLayoutConstraints.insets = new Insets(20, 5, 5, 5);
		inputPanelLayoutConstraints.gridx = 3;
		inputPanelLayoutConstraints.gridy = 5;
		inputPanelLayoutConstraints.gridwidth = 0;
		inputPanelLayoutConstraints.gridheight = 1;
		inputPanelLayoutConstraints.fill = GridBagConstraints.NONE;
		inputPanelLayoutConstraints.anchor = GridBagConstraints.CENTER;
	}
	
	public void formatTimeBox(JTextField field)
	{
		field.setFont(new Font(Font.SANS_SERIF,50,25));
//		field.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e)
//			{
//				if(e.getComponent().equals(field))
//				{
//					String initialText = field.getText();
//					//System.out.println(initialText + "this is the text whenever it is grabbed");
//					if(e.getKeyCode()<48 ||e.getKeyCode()>57)
//					{
////					field.setEnabled(false);
////					System.out.println(initialText + "this is the text after recognizing that the code is not an integer");
////					field.setText(initialText);
//					}
//				}
//			}
//			public void keyReleased(KeyEvent e)
//			{
//				if(e.getKeyCode()>=48 && e.getKeyCode()<=57)
//				{
//					//System.out.println("Entered " +  e.getKeyCode());
//					String text = field.getText() + (e.getKeyChar());
//					field.setText(text);
//				} else { 
//					
//				}
//			}
//		});
		field.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(arg0.getComponent().equals(field))
				{
				field.setSelectionStart(0);
				field.setSelectionEnd(2);
				}
			}
		});
	}
	public void addFocusListenerToNameBox(JTextField field)
	{
		field.addFocusListener(new FocusListener() {
			
				@Override
				public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
				}
			
				@Override
				public void focusGained(FocusEvent arg0) {
					if(arg0.getComponent().equals(field))
					{
						field.setSelectionStart(0);
						field.setSelectionEnd(4);
					}
				}
			});
		}
	public void addMouseListener(JFrame inputFrame, JButton button, JTextField nameInput, JTextField startTimeHourInput, JTextField startTimeMinuteInput, JComboBox<String> AMPM1, JTextField endTimeHourInput, JTextField endTimeMinuteInput, JComboBox<String> AMPM2)
	{
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e)
			{
				if(e.getComponent().equals(button))
				{
					getEntriesThenClose();
				}
			}

			private void getEntriesThenClose() {
				name = nameInput.getText();
				startTime = startTimeHourInput.getText() + ' ' + startTimeMinuteInput.getText() + AMPM1.getSelectedItem();
				endTime = endTimeHourInput.getText() + ' ' + endTimeMinuteInput.getText() + AMPM2.getSelectedItem();
				Map<String, Boolean> dayBooleanMap = new HashMap<String, Boolean>();
				dayBooleanMap.put("Sunday", sunday.isSelected());
				dayBooleanMap.put("Monday", monday.isSelected());
				dayBooleanMap.put("Tuesday", tuesday.isSelected());
				dayBooleanMap.put("Wednesday", wednesday.isSelected());
				dayBooleanMap.put("Thursday", thursday.isSelected());
				dayBooleanMap.put("Friday", friday.isSelected());
				dayBooleanMap.put("Saturday", saturday.isSelected());
				System.out.println("name: " + name + " Start Time: " + startTime + " End Time: " + endTime);
				Class currentClass = new Class(name,startTime,endTime, dayBooleanMap);
				Gui.ClassMap.put(Gui.k, currentClass);
				Gui.k++;
				//System.out.println(Gui.ClassMap + " " + Gui.k);
				inputFrame.dispose();
				Gui.addClassToLeftSide(currentClass);
			}
		});
	}
	public void changeColorOnClick(String icon,JCheckBox box, String pressedIcon)
	{
		box.setBackground(Color.white);
			box.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					if(box.isSelected())
					{
					box.setIcon(new ImageIcon(pressedIcon));
					} else {
						box.setIcon(new ImageIcon(icon));
					}
				}
			});
		}
	}
	
