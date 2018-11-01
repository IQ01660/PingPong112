import java.awt.Color;
import java.util.Random;

public class Ball extends MovingObject implements WindowInfo{
	private final static double INITIAL_SPEED = 200;
	public final static double RADIUS = 20;
	private Random rand;
	
	public Color ballColor = Color.YELLOW;
	
	public Ball() {
		this.setPosition(new Pair(WindowInfo.WINDOW_WIDTH/2, WindowInfo.WINDOW_HEIGHT/2));
		int initDirection = rand.nextInt(2); //randomly determine initial direction => left or right
		// TO THE RIGHT
		if (initDirection == 0) {
			this.setVelocity(new Pair(INITIAL_SPEED, 0.0));
		}
		// TO THE LEFT
		else {
			this.setVelocity(new Pair(-INITIAL_SPEED, 0.0));
		}
	}
}