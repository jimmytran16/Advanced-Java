package application;
import javax.swing.JFrame;

/**
 * 
 * 
 * 
 *
 */

//Main class 
public class ReaderOfBooks {

	public static void main(String[] args)
	{
	
		JFrame frame = new JFrame("Reader Of Books");
		ReaderOfBooksPanel panel = new ReaderOfBooksPanel();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	
	}	
}
