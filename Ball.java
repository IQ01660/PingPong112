import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends MovingObject implements WindowInfo{
	public final static double INITIAL_SPEED = 400;
	public final static double RADIUS = 20;
	private Random rand = new Random();
	
	public Color ballColor = Color.ORANGE;
	
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
	//if l => left side lost
	public char whereDied() {
		if(this.getPosition().x < 0) {
			return 'l';
		}
		else if(this.getPosition().x > WindowInfo.WINDOW_WIDTH) {
			return 'r';
		}
		else{
			return ' ';
		}
	}
	public void startOver() {
		if(this.whereDied() == 'l') {
			this.setPosition(new Pair(WindowInfo.WINDOW_WIDTH/2, WindowInfo.WINDOW_HEIGHT/2));
			this.setVelocity(new Pair(-INITIAL_SPEED, 0.0));
		}
		if(this.whereDied() == 'r') {
			this.setPosition(new Pair(WindowInfo.WINDOW_WIDTH/2, WindowInfo.WINDOW_HEIGHT/2));
			this.setVelocity(new Pair(INITIAL_SPEED, 0.0));
		}
	}
	public void drawBall(Graphics g) {
		//drawing the ball
		//this.x and this.y are the center coordinates
		g.setColor(this.ballColor);
		g.fillOval((int)(this.getPosition().x - RADIUS), (int)(this.getPosition().y - RADIUS), (int)RADIUS*2, (int)RADIUS*2);
	}
	
}