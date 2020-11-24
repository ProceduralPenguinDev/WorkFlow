import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class resizingLogic {
	
	private int windowSizing = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
    private Dimension windowSize = new Dimension(windowSizing + windowSizing/6, windowSizing);
    
    private Dimension popUpSizing = new Dimension((windowSizing + windowSizing/6)/3 + 100, windowSizing/3 + 100);
	
    private Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    private final int RESIZE_E_BORDER = 0;
    private final int RESIZE_S_BORDER = 1;
    private final int RESIZE_W_BORDER = 2;
    private final int RESIZE_N_BORDER = 3;
    
    
    public resizingLogic()
    {
    	//Convenience constructor
    }
    
    public resizingLogic(Component component) {
    	component.addMouseListener(new MouseAdapter() {
    		
    		volatile private Boolean resizing = false;
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				resizing = false;
				component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				System.out.println("resizing off");
			}
			
			@Override
			public  void mousePressed(MouseEvent arg0) {
					Point cursor = MouseInfo.getPointerInfo().getLocation();
				    int cursorX = cursor.x;
				    int cursorY = cursor.y;
				    int componentHeight = component.getHeight();
				    int componentWidth = component.getWidth();
				    int componentXOrigin = component.getX();
				    int componentYOrigin = component.getY();
				    int componentWidthAbsolute = componentWidth+componentXOrigin;
				    int componentHeightAbsolute = componentHeight+componentYOrigin;
				    int northUpperBound = componentYOrigin;
				    int northLowerBound = componentYOrigin+5;
				    int southUpperBound = componentHeightAbsolute-5;
				    int southLowerBound = componentHeightAbsolute;
				    int westLeftBound = componentXOrigin;
				    int westRightBound = componentXOrigin+5;
				    int eastLeftBound = componentWidthAbsolute-5;
				    int eastRightBound = componentWidthAbsolute;


//				    System.out.println("Cursor at ("+cursorX +","+cursorY+")");
//				    System.out.println(cursorX);
//				    System.out.println(cursorY);
//				    System.out.println(componentWidth);
//				    System.out.println(componentHeight);
				    
//				    System.out.println("["+eastLeftBound+","+componentYOrigin+"]");
//				    System.out.println("["+eastRightBound+","+componentYOrigin+"]");
//				    System.out.println("["+eastLeftBound+","+componentHeight+"]");
//				    System.out.println("["+eastRightBound+","+componentHeight+"]");
				    
				    if(cursorY >= northUpperBound && cursorY <= northLowerBound && cursorX >= componentXOrigin && cursorX <= componentWidth)
				    {
//				    	System.out.println(componentXOrigin);
				    	//System.out.println("Top");
				    	resizing = true;
				    	component.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
				    	initThread(componentWidth, componentHeight, componentXOrigin, componentYOrigin, RESIZE_N_BORDER);
				    }
				    if(cursorY >= southUpperBound && cursorY <= southLowerBound && cursorX >= componentXOrigin && cursorX <= componentWidth)
				    {
//				    	System.out.println("Bottom");
				    	resizing = true;
				    	component.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
				    	initThread(componentWidth,componentHeight, componentXOrigin, componentYOrigin, RESIZE_S_BORDER);
				    }
				    if(cursorX >= westLeftBound && cursorX <= westRightBound && cursorY >= componentYOrigin && cursorY <= componentHeight)
				    {
//				    	System.out.println("Left");
				    	resizing = true;
				    	component.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
				    	initThread(componentWidth,componentHeight, componentXOrigin, componentYOrigin, RESIZE_W_BORDER);
				    }
				    if(cursorX >= eastLeftBound && cursorX < eastRightBound && cursorY >= componentYOrigin && cursorY <= componentHeight)
				    {
//				    	System.out.println("right");
				    	resizing = true;
				    	component.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
				    	initThread(componentWidth,componentHeight, componentXOrigin, componentYOrigin, RESIZE_E_BORDER);
				    }
				
			}
			public void setEastBound(int width, int height, int locationX, int locationY, int direction) {
			while(resizing == true)
	    	{
				Point cursor = MouseInfo.getPointerInfo().getLocation();
	    		component.setSize(new Dimension((int) Math.round(cursor.getX())-component.getX(),height));
	    		//System.out.println(cursor.getX());
	    		//System.out.println("sizing");
	    		initThread(width, height, locationX, locationY, direction);
	    	}
			}
			public void setSouthBound(int Width, int Height, int locationX, int locationY, int direction) {
				while(resizing == true)
		    	{
					Point cursor = MouseInfo.getPointerInfo().getLocation();
		    		component.setSize(new Dimension(Width,(int) cursor.getY()-component.getY()));
		    		//System.out.println(cursor.getY());
		    		//System.out.println("sizing");
		    		initThread(Width, Height, locationX, locationY, direction);
		    	}
				}
			public void setWestBound(int Width, int Height, int locationX, int locationY, int direction) {
				while(resizing == true)
		    	{
					Point cursor = MouseInfo.getPointerInfo().getLocation();
		    		component.setLocation((int)cursor.getX(), locationY);
		    		component.setSize(new Dimension((int)(Width - (cursor.getX()-locationX)), Height));
		    		//System.out.println(cursor.getX());
		    		//System.out.println("sizing");
		    		initThread(Width, Height, locationX, locationY, direction);
		    	}
				}
			public void setNorthBound(int Width, int Height, int locationX, int locationY, int direction) {
				System.out.println(resizing);
				while(resizing == true)
		    	{
//					System.out.println(locationX + " Entered logic");
					Point cursor = MouseInfo.getPointerInfo().getLocation();
		    		component.setLocation(locationX, (int)cursor.getY());
		    		component.setSize(new Dimension(Width, (int)(Height - (cursor.getY()-locationY))));
//		    		System.out.println(cursor.getY());
		    		//System.out.println("sizing");
		    		initThread(Width, Height, locationX, locationY, direction);
		    	}
				}
			
			volatile private boolean isRunning = false;
			private synchronized boolean checkAndMark() {
			    if (isRunning) return false;
			    isRunning = true;
			    return true;
			}
			    private void initThread(int x, int y, int locationX ,int locationY, int direction) {
			        if (checkAndMark()) {
			            new Thread() {
			                public void run() {
			                    do {
//			                    	System.out.println(locationX);
//			                    	System.out.println("Resizing: " + resizing);
			                    	if(direction == RESIZE_E_BORDER)
			                        setEastBound(x,y,locationX,locationY,direction);
			                    	if(direction == RESIZE_S_BORDER)
			                        setSouthBound(x,y,locationX,locationY,direction);
			                    	if(direction == RESIZE_W_BORDER)
			                    	setWestBound(x, y, locationX, locationY, direction);
			                    	if(direction == RESIZE_N_BORDER)
			                    	setNorthBound(x,y,locationX,locationY,direction);
			                    } while (resizing);
			                    isRunning = false;
			                }
			            }.start();
			        }
			    }
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
    	});
    }
    
	public void resizeTitle()
	{
		String title = "WorkFlow";
//		System.out.println(windowSizing);
		int width = windowSizing + (windowSizing/6);
		int numOfChar = (width/3)-50;
//		System.out.println(numOfChar);
		for(int i=0; i<numOfChar;i++)
			title = title.concat(" ");
//		System.out.println(title);
		Gui.ParentFrame.setTitle(title);
	}
	
	public void resizeTitleDynamic(int width)
	{
		int numOfChar = 0;
		String title = "WorkFlow";
		if(width%2 == 1) {
		numOfChar = (width/3)-50;
		} else {
			numOfChar = (width/3)-51;
		}
//		System.out.println(numOfChar);
		for(int i=0; i<numOfChar;i++)
			title = title.concat(" ");
//		System.out.println(title);
		Gui.ParentFrame.setTitle(title);
	}
	
	public void sizeParentPanel() 
	{ 
		Gui.parentPanel.setPreferredSize(windowSize);
	}
	
	public void resizePopUp(String titlePass, JFrame popUpWindowPass)
	{
		String title = titlePass;
		int width = ((windowSizing + (windowSizing/6)/3 + 100 + 100));
		int numOfChar = (width/6)-85;
		for(int i=0; i<numOfChar;i++)
			title = title.concat(" ");
		popUpWindowPass.setTitle(title);
	}
	
	public void sizePopUps(JPanel panelPass) 
	{ 
		panelPass.setPreferredSize(popUpSizing);
	}
	
}
