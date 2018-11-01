import java.awt.Color;
import java.util.Random;

public class Paddle extends MovingObject implements WindowInfo{
	public final static double WIDTH = 30;
	public final static double HEIGHT = 150;
	private final static double SPEED = 50;
	
	public Color paddleColor = Color.BLUE;
	
	private Random rand;
	/**
	 * Input false if the paddle is on 
	 * the left, and true if it is on
	 * the right
	 * @param side
	 */
	public Paddle(boolean side) {
		//determining if the paddle's on the left or right
		double xPos;
		if (side == true) {
			xPos = WindowInfo.WINDOW_WIDTH - (this.WIDTH/2);
		}
		else {
			xPos = this.WIDTH/2;
		}
		//giving the initial position to paddle (y is random)
		this.setPosition(new Pair(xPos, rand.nextInt((int)(WindowInfo.WINDOW_HEIGHT - this.WIDTH) ) + this.WIDTH/2));
		this.setVelocity(new Pair(0.0, 0.0));
	}
	
}