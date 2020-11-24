import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class URLOpenLogic {
	
	public void URLOpen(String pass) throws URISyntaxException
	{
	URI Uri = new java.net.URI(pass);
	try {
		java.awt.Desktop.getDesktop().browse(Uri);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}
}
