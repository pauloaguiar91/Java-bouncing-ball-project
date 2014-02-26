/**
 * @author Paulo Aguiar 2012
 */

package pauloaguiar;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

/**
 * Creates JFrame and adds the Gui class to the JFrame and displays it on the
 * screen
 */
public class Main {
	private static String title = "Bouncing Ball Project - 2012";

	public static void main(String[] args) {
		JFrame frame = new JFrame(title);
		
		// Exits the application and so it doesn't run at the background
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create the gui object
		Gui view = new Gui();

		// Sets the size of the frame
		frame.setSize(1024, 768);

		// Set frame to non-resizable
		frame.setResizable(true);
		
		//adds it to the frame
		frame.add(view);
		
		//center it
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

		// Display frame
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Click anywhere!","Message", JOptionPane.DEFAULT_OPTION);
	}
}
