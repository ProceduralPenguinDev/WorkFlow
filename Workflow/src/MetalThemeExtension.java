import java.awt.Color;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class MetalThemeExtension extends DefaultMetalTheme {
	
	Color darkRed = new Color(79,5,1);
	Color White = new Color(255,255,255);

    @Override
    public ColorUIResource getMenuBackground() {
      return new ColorUIResource(darkRed);
    }
    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(darkRed);
    }
    public ColorUIResource getWindowTitleInactiveBackground() {
    	return new ColorUIResource(darkRed);
    }
    public ColorUIResource getMenuForeground() {
        return new ColorUIResource(White);
    }
    public ColorUIResource getWindowTitleForeground() {
        return new ColorUIResource(White);
    }
    public ColorUIResource getWindowTitleInactiveForeground() {
     	return new ColorUIResource(White);
    }
  }  
  
