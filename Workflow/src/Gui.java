import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.*; 
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

import javafx.event.ActionEvent;

import javax.swing.plaf.metal.DefaultMetalTheme;

public class Gui {
	 // JFrame Instantiations 
    static JFrame ParentFrame; 
    static JPanel leftSidePanel;
    static JPanel rightContentPanel;
    static JPanel toolbarPanel;
    static JPanel parentPanel;
    static JPanel exitBarPanel;
    static MetalLookAndFeel metal;
    static JButton newClass;
    static JButton minimize; 
    static JButton maximize; 
    static JButton close;
    static JButton edit;
    static int yPositionCounter;
    static int k;
    Color leftSideColor = new Color(189,16,0);
    
    
    
    public static Map<Integer,Class> ClassMap = new HashMap<Integer,Class>();
    
    
    static Icon newIcon = new ImageIcon();
    
    resizingLogic resize = new resizingLogic();   
    static changeIcon icon = new changeIcon();
    ClassWindowInput popUpClass = new ClassWindowInput();
    layoutConstraintManager layoutcstmgr = new layoutConstraintManager();

    // JButton 
    
  
    // label to display text 
    static JLabel l; 
    
    public Gui() {
  
    // main class
//    	    metal = new MetalLookAndFeel();
//    	    MetalLookAndFeel.setCurrentTheme(new MetalThemeExtension());
//    	    try {
//    	      UIManager.setLookAndFeel(metal);
//    	    }
//    	    catch(UnsupportedLookAndFeelException e) {
//    	      e.printStackTrace();
//    	    }
    	    ParentFrame = new JFrame();
    	    
    	    ParentFrame.setUndecorated(true);
    	    ParentFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    	    resizingLogic resizeFrame = new resizingLogic(ParentFrame);
    	    //ComponentResizer componentResizer = new ComponentResizer(ParentFrame);
    
    // create a new frame to store text field and button 
         
  
        // create a label to display text 
        l = new JLabel("panel label"); 
  
        // create a new buttons 
        //b = new JButton("button1");  
  
        // create a panel to add buttons 
        parentPanel = new JPanel();
        leftSidePanel = new JPanel();
        rightContentPanel = new JPanel();
        toolbarPanel = new JPanel();
        exitBarPanel = new JPanel();
        
        leftSidePanel.setBackground(leftSideColor);
        rightContentPanel.setBackground(Color.white);
        toolbarPanel.setBackground(new Color(112,9,0));
        exitBarPanel.setBackground(new Color(79,5,1));
        
        
        //layout manager for parent panel
        GridBagLayout panelLayout = new GridBagLayout();
        GridBagConstraints panelLayoutConstraints = new GridBagConstraints();
        parentPanel.setLayout(panelLayout);
        
        //exit Panel
        JLabel title = new JLabel("          WorkFlow");
        Font titleFont = new Font(Font.SANS_SERIF,0,20);
        title.setFont(titleFont);
        title.setForeground(new Color(255,255,255));
        minimize = new JButton(); 
        maximize = new JButton(); 
        close = new JButton();
        GridBagLayout exitBarLayout = new GridBagLayout();
        exitBarPanel.setLayout(exitBarLayout); 
        
        //toolbar Panel
        toolbarPanel.setLayout(new GridBagLayout());
        GridBagConstraints editConstraints = new GridBagConstraints();
        editConstraints.gridx = 0;
        editConstraints.gridy = 0;
        editConstraints.weighty = 1;
        editConstraints.fill = GridBagConstraints.VERTICAL;
        editConstraints.anchor = GridBagConstraints.EAST;
        editConstraints.weightx = 1;
        edit = new JButton();
        buttonActions editStateChanger = new buttonActions(edit, new Color(112,9,0), new Color(100,16,0), new Color(150,9,0));
        
        icon.setIconAndFormat("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\EditIcon.png", edit, new Color(112,9,0));
        toolbarPanel.add(new JLabel(), editConstraints);
        editConstraints.gridx = 1;
        editConstraints.weightx = 0;
        toolbarPanel.add(edit, editConstraints);
        
        
        Color mouseOnColor = new Color(255,0,16);
        Color clickedStateColor = new Color(152,0,25);
        buttonActions closeStateChanger = new buttonActions(close, exitBarPanel.getBackground(),mouseOnColor,clickedStateColor);
        mouseOnColor = new Color(156,9,2);     
        clickedStateColor = new Color(152,0,25);
        buttonActions minimizeStateChanger = new buttonActions(minimize, exitBarPanel.getBackground(),mouseOnColor,clickedStateColor);
        buttonActions maximizeStateChanger = new buttonActions(maximize, exitBarPanel.getBackground(),mouseOnColor,clickedStateColor);
        
        icon.setIconAndFormat("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\ExitButtonIcon.png", close,exitBarPanel.getBackground());
        icon.setIconAndFormat("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\MinimizeButton.png", minimize, exitBarPanel.getBackground());
        icon.setIconAndFormat("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\MaximizeButton.png", maximize, exitBarPanel.getBackground());
        
        
        GridBagConstraints minimizeLayoutConstraints = new GridBagConstraints();
        GridBagConstraints maximizeLayoutConstraints = new GridBagConstraints();
        GridBagConstraints closeLayoutConstraints = new GridBagConstraints();
        GridBagConstraints titleLayoutConstraints = new GridBagConstraints();
        layoutcstmgr.setTitleLayoutConstraints(titleLayoutConstraints);
        layoutcstmgr.setMinimizeLayoutConstraints(minimizeLayoutConstraints);
        layoutcstmgr.setMaximizeLayoutConstraints(maximizeLayoutConstraints);
        layoutcstmgr.setCloseLayoutConstraints(closeLayoutConstraints);
        exitBarPanel.add(title, titleLayoutConstraints);
        exitBarPanel.add(minimize, minimizeLayoutConstraints);
        exitBarPanel.add(maximize, maximizeLayoutConstraints);
        exitBarPanel.add(close, closeLayoutConstraints);
        
        //leftSidePanel
        mouseOnColor = new Color(130,16,0);
        clickedStateColor = new Color(219,16,0);
        newClass = new JButton();
        newClass.setBackground(leftSideColor);
        newClass.setPressedIcon(newIcon);
        newClass.setSelectedIcon(newIcon);
        
        buttonActions newClassStateChanger = new buttonActions(newClass, leftSideColor,mouseOnColor,clickedStateColor);
       
        icon.setIconAndFormat("X:\\Development\\GitHub\\WorkFlow\\WorkFlow\\NewIcon.png", newClass, leftSidePanel.getBackground());
        
        
        GridBagLayout leftSideLayout = new GridBagLayout();
        GridBagConstraints leftSideLayoutConstraints = new GridBagConstraints();
        leftSidePanel.setLayout(leftSideLayout);
        
        leftSideLayoutConstraints.weightx = 1;
        leftSideLayoutConstraints.weighty = 0;
        leftSideLayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        leftSideLayoutConstraints.anchor = GridBagConstraints.NORTH;
        leftSideLayoutConstraints.gridx = 0;
        leftSideLayoutConstraints.gridy = 0;
        yPositionCounter = 1;
        
        leftSidePanel.add(newClass, leftSideLayoutConstraints);
        leftSideLayoutConstraints.gridy = 1;
        leftSideLayoutConstraints.weighty = 1;
        leftSidePanel.add(new JLabel(), leftSideLayoutConstraints);
        
        JPanel welcomePanel = new JPanel();
        JPanel tutorialPanel = new JPanel();
        rightContentPanel.add(welcomePanel, "WELCOME_PANEL");
        welcomePanel.add(new JLabel("Welcome!"));
        CardLayout rightContentPanelLayout = new CardLayout();
        rightContentPanel.setLayout(rightContentPanelLayout);
        rightContentPanelLayout.show(rightContentPanel, "WELCOME_PANEL");
        
        
        // add buttons and textfield to panel 
        leftSidePanel.setPreferredSize(new Dimension(100,150));
        rightContentPanel.setPreferredSize(new Dimension(100,150));
        toolbarPanel.setPreferredSize(new Dimension(100,50));
        exitBarPanel.setPreferredSize(new Dimension(400,50));
        
        panelLayoutConstraints.fill = GridBagConstraints.BOTH;
        panelLayoutConstraints.gridx = 0;
        panelLayoutConstraints.gridy = 0;
        panelLayoutConstraints.weightx = 1;
        panelLayoutConstraints.weighty = 0;
        panelLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        parentPanel.add(exitBarPanel, panelLayoutConstraints);
        panelLayoutConstraints.fill = GridBagConstraints.BOTH;
        panelLayoutConstraints.gridx = 0;
        panelLayoutConstraints.gridy = 1;
        panelLayoutConstraints.weightx = .2;
        panelLayoutConstraints.weighty = 1;
        panelLayoutConstraints.gridwidth = GridBagConstraints.RELATIVE;
        //panelLayoutConstraints.fill = GridBagConstraints.VERTICAL;
        panelLayoutConstraints.gridheight = 2;
        parentPanel.add(leftSidePanel, panelLayoutConstraints); 
        //panelLayoutConstraints.gridwidth = GridBagConstraints.REMAINDER;
        panelLayoutConstraints.weightx = 1;
        panelLayoutConstraints.weighty = 1;
        panelLayoutConstraints.gridx = 1;
        panelLayoutConstraints.gridy = 2;
        panelLayoutConstraints.gridheight = 1;
        parentPanel.add(rightContentPanel, panelLayoutConstraints); 
        panelLayoutConstraints.gridx = 1;
        panelLayoutConstraints.gridy = 1;
        panelLayoutConstraints.weighty = 0;
        parentPanel.add(toolbarPanel, panelLayoutConstraints); 

  
		// setbackground of panel 
       // parentPanel.setBackground(Color.red); 
        //parent panel sizing
        ParentFrame.addComponentListener(new ComponentAdapter() {
        	public void componentResized(ComponentEvent e) {
        		 resize.resizeTitleDynamic(parentPanel.getWidth());
//        		 System.out.println("resized");
        		 
        	}
        	
		});
 
       
        resize.sizeParentPanel();
        resize.resizeTitle();
        
        // add panel to frame 
        ParentFrame.add(parentPanel); 
  
        // set the size of frame 
        //ParentFrame.setSize(300, 300); 
        ParentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ParentFrame.pack();
        ParentFrame.show(); 
    }
    
    public static void addClassToLeftSide(Class classObject)
    {
    	for(Component comp : leftSidePanel.getComponents())
    	{
    		if(comp instanceof JLabel)
    		{
    			leftSidePanel.remove(comp);
    		}
    	}
    		
    	leftSidePanel.setVisible(false);
        GridBagConstraints addButtonConstraints = new GridBagConstraints();
    	addButtonConstraints.gridy = yPositionCounter;
    	addButtonConstraints.gridx = 0;
    	addButtonConstraints.weightx = 1;
    	addButtonConstraints.weighty = .2;
    	addButtonConstraints.fill = GridBagConstraints.BOTH;
    	addButtonConstraints.anchor = GridBagConstraints.NORTH;
    	System.out.println(ClassMap);
    	icon.format(classObject.getButton(), leftSidePanel.getBackground());
        buttonActions volatileButtonStateChanger = new buttonActions(classObject.getButton(), new Color(189,16,0),new Color(130,16,0),new Color(219,16,0));
        leftSidePanel.add(classObject.getButton(), addButtonConstraints);
        addButtonConstraints.weighty = 1;
        addButtonConstraints.gridy = yPositionCounter+1;
        leftSidePanel.add(new JLabel(), addButtonConstraints);
        yPositionCounter++;
    	leftSidePanel.setVisible(true);
    }
    public static void changePanelOnClick(Class classData)
    {
    	//you might want to figure this out later because this is a weird solution
    	CardLayout cl = (CardLayout)rightContentPanel.getLayout();
    	rightContentPanel.add(classData.getViewPanel(), classData.getName());
    	cl.next(rightContentPanel);
    	cl.show(rightContentPanel, classData.getName());
    }

    
}
	