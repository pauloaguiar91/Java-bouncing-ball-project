/**
 * @author Paulo Aguiar 2012
 */

package pauloaguiar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Gui extends JPanel implements MouseListener {

	private JPanel panel;
	private Ball ball;
	private int count;

	/**
	 * BorderLayout position the JPanel. Main class adds the JPanel to JFrame
	 * Adds MouseListener to the JPanel
	 */
	public Gui() {
		super();
		setLayout(new BorderLayout());
		panel = new JPanel();
		add(panel, "Center");
		this.addMouseListener(this);
	}

	/**
	 * Creates an instance of the ball class and get position of the MouseClicked
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		if (count < 20) {
			ball = new Ball(x, y, panel);
			ball.start();
		}
		count++;
	}

	//apparently these need to be inherited
	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
}
