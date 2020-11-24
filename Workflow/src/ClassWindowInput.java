import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClassWindowInput {
	
	private String name = "";
	private String startTime = "";
	private String endTime = "";
	
	JTextField nameInput = new JTextField();
	JTextField startTimeInput = new JTextField();
	JTextField endTimeInput = new JTextField();
	
	public void popUpInputForClass()
	{
		JOptionPane.showInputDialog(nameInput, startTimeInput, endTimeInput);
	
	}
}
