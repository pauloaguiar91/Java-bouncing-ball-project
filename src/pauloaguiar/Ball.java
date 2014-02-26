/**
 * @author Paulo Aguiar 2012
 * @author Lautaro Sosa - Thanks for working with me on this class.
 */

package pauloaguiar;
import java.awt.*;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class Ball extends Thread implements Runnable{
	
	private int y = 100;
	private int x = 100;
	private int dx = 20;
	private int diameterX = 50;
	private int diameterY = 50;
	private int dy = 40;
	private Random generator = new Random();
	private Color BallColor = new Color(0, 0, 0);
	private JPanel ballPanel;
	
	/**
	 * Creates and stores JPanel.
	 * Creates position and color of the balls
	 * @param xBallPos
	 * @param yBallPos
	 * @param Ball
	 */
	public Ball(int xBallPos, int yBallPos, JPanel Ball){
		ballPanel = Ball;
		BallColor=Color.getHSBColor(generator.nextFloat(), generator.nextFloat(), generator.nextFloat());
		x = xBallPos;
		y = yBallPos;
	}
	
	/**
	 * Creates the ball
	 */
	public void createBall(){
		Graphics gBall = ballPanel.getGraphics();
		gBall.setColor(BallColor);
		gBall.fillOval(x, y,diameterX, diameterY);
	}
	
	/**
	 * Moves the ball
	 */
	public void moveBall(){
		Graphics gBall = ballPanel.getGraphics();
		gBall.clearRect(x, y, diameterX, diameterY);
		x = x+dx;
		y = y+dy;
		
		/**
		 * detects the borders of the window and bounces back
		 */
		if(x < 0){
			x = 0;
			dx = -dx;
			}
		if(y < 0){
			y = 0;
			dy = -dy;
		}
		
		if(x >ballPanel.getWidth() - diameterX){
			x = ballPanel.getWidth() - diameterX;
			dx = -dx;
		}
		
		if(y > ballPanel.getHeight() - diameterY){
			y = ballPanel.getHeight() - diameterY;
			dy = -dy;
		}
		
		gBall.setColor(BallColor);
		gBall.fillOval(x, y,diameterX,diameterY);	
}
	
	/**
	 * Initiate create ball method and creates threads for each ball then moves it.
	 */
	public void run(){
		try
		{
			createBall();
			for(int count=1; count <=9000; count++){
				moveBall();
		try{
			Thread.sleep(50);
				}
				catch (InterruptedException ex){
					ex.printStackTrace();
				}
			}
		}
		
		finally {
			
		}
	}
}