package Exercise;
import javax.swing.JOptionPane;

public class demo 
{
	private static double PI = Math.PI;
	
	public static void main(String [] args)
	{
		while(true)
		{
			// "showInputDialog()" always returns a String
			String Count = JOptionPane.showInputDialog(null, "Please type an integer");
			
			// needing a numeric I must convert the String
			int count = Integer.parseInt(Count);
			double dCount = Double.parseDouble(Count);
			
			count = (int)(count * PI);
			JOptionPane.showMessageDialog(null, count);
			
			dCount = dCount / PI;
			JOptionPane.showMessageDialog(null, dCount);
			
			if (JOptionPane.showConfirmDialog(null, "Will we try again?") != JOptionPane.YES_OPTION)
			{
				break;
			}
		}
	}
}

