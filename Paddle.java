import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Paddle extends MovingObject implements WindowInfo, KeyListener{
	public final static double WIDTH = 10;
	public final static double HEIGHT = 150;
	private final static double SPEED = 300;
	
	private boolean side;//shows => the right or left paddle
	public Color paddleColor = Color.BLUE;
	private Random rand = new Random();
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
			xPos = WindowInfo.WINDOW_WIDTH - (WIDTH/2);
			this.side = true;
		}
		else {
			xPos = WIDTH/2;
			this.side = false;
		}
		//giving the initial position to paddle (y is random)
		this.setPosition(new Pair(xPos, (rand.nextInt((int)(WindowInfo.WINDOW_HEIGHT - HEIGHT) ) + HEIGHT/2) ));
		this.setVelocity(new Pair(0.0, 0.0));
	}
	public void drawPaddle(Graphics g) {
		g.setColor(this.paddleColor);
		g.fillRect((int)(this.getPosition().x - WIDTH/2), (int)(this.getPosition().y - HEIGHT/2), (int)WIDTH, (int)HEIGHT);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char typedKey = e.getKeyChar();
		if(this.side == false) {
			this.changeVelocityControls(typedKey, 'r', 'f', 'v');
		}
		else {
			this.changeVelocityControls(typedKey, 'u', 'j', 'n');
		}
	}
	private void changeVelocityControls(char _typed,char _up, char _down, char _stop) {
		if(_typed == _up) {
			this.setVelocity(new Pair(0.0, -SPEED));
		}
		else if(_typed == _down) {
			this.setVelocity(new Pair(0.0, SPEED));
		}
		else if(_typed == _stop) {
			this.setVelocity(new Pair(0.0, 0.0));
		}
	}
	@Override
	public void move(double _time) {
		super.move(_time);
		if (this.getPosition().y <= HEIGHT/2 || this.getPosition().y >= WindowInfo.WINDOW_HEIGHT - HEIGHT/2) {
			this.setVelocity(new Pair(0.0, 0.0));//stopping the paddle if it reaches the edge
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}