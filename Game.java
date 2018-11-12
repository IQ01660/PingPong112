//positions are counted from the center of the ball and paddle
// Game will control the rules of the game
// it extends Pong to get the access to game's elements
// NOTE: semantically Pong is actually a type of game
// but here it is just used to get the Pong's fields
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.Math;

public class Game{
	private final double maxAngle = 75;
	private Ball pongBall;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private int leftScore = 0;
	private int rightScore = 0;
	public Game(Ball _ball, Paddle _leftP, Paddle _rightP) {
		this.pongBall = _ball;
		this.leftPaddle = _leftP;
		this.rightPaddle = _rightP;
		
	}
	private boolean isLeftBounced() {
		if( (this.leftPaddle.getPosition().x + Paddle.WIDTH/2 >= this.pongBall.getPosition().x - Ball.RADIUS) &&
		    (this.leftPaddle.getPosition().y - Paddle.HEIGHT/2 < this.pongBall.getPosition().y + Ball.RADIUS &&
		    		this.leftPaddle.getPosition().y + Paddle.HEIGHT/2 > this.pongBall.getPosition().y - Ball.RADIUS) ){
			return true;
		}
		else {
			return false;
		}
	}
	private boolean isRightBounced() {
		if( (this.rightPaddle.getPosition().x - Paddle.WIDTH/2 <= this.pongBall.getPosition().x + Ball.RADIUS) &&
			    (this.rightPaddle.getPosition().y - Paddle.HEIGHT/2 < this.pongBall.getPosition().y + Ball.RADIUS &&
			    		this.rightPaddle.getPosition().y + Paddle.HEIGHT/2 > this.pongBall.getPosition().y - Ball.RADIUS) ){
				return true;
			}
			else {
				return false;
			}
	}
	private void reflect() {
		if(this.pongBall.getPosition().y <= Ball.RADIUS ||
		  this.pongBall.getPosition().y >= (WindowInfo.WINDOW_HEIGHT - Ball.RADIUS)) {
			this.pongBall.setVelocity(new Pair(this.pongBall.getVelocity().x, (-1)*this.pongBall.getVelocity().y));
		}
	}
	//this method is only used if the ball touched the paddle already
	private Pair findBouncedVelocity() {
		double verticalDistance;
		if (this.isLeftBounced()) {
			verticalDistance = this.pongBall.getPosition().y - (this.leftPaddle.getPosition().y - Paddle.HEIGHT/2 - Ball.RADIUS);
		}
		else {
			verticalDistance = this.pongBall.getPosition().y - (this.rightPaddle.getPosition().y - Paddle.HEIGHT/2 - Ball.RADIUS);

		}
		double maxDistance = Paddle.HEIGHT + Ball.RADIUS*2;
		double theta = (verticalDistance * this.maxAngle*2 / maxDistance) - this.maxAngle;
		
		double velocityX;
		double velocityY = Math.sin(Math.toRadians(theta)) * Ball.INITIAL_SPEED;
		if (this.pongBall.getVelocity().x > 0) {
			velocityX = (-1)*Math.cos(Math.toRadians(theta)) * Ball.INITIAL_SPEED;
		}
		else {
			velocityX = Math.cos(Math.toRadians(theta)) * Ball.INITIAL_SPEED;
		}
		System.out.println(theta);
		return new Pair(velocityX, velocityY);
	}
	public void bounce() {
		this.reflect();
		if(this.isRightBounced() == true || this.isLeftBounced() == true) {
			this.pongBall.setVelocity(this.findBouncedVelocity());
		}
	}
	private void scoreUpdate() {
		if(this.pongBall.whereDied() == 'l') {
			this.rightScore++;
			this.pongBall.startOver();
		}
		if(this.pongBall.whereDied() == 'r') {
			this.leftScore++;
			this.pongBall.startOver();
		}	
	}
	public void drawScore(Graphics g) {
		this.scoreUpdate();
		if(this.leftScore >= 10) {
			g.setColor(Color.PINK);
	        g.fillRect(0, 0, (int) WindowInfo.WINDOW_WIDTH, (int) WindowInfo.WINDOW_HEIGHT);
	        g.setColor(Color.BLUE);
	        //g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
			g.drawString("Left player wins", (int)WindowInfo.WINDOW_WIDTH/2 - 100, (int)WindowInfo.WINDOW_HEIGHT - 50);
		}
		if(this.rightScore >= 10) {
			g.setColor(Color.PINK);
	        g.fillRect(0, 0, (int) WindowInfo.WINDOW_WIDTH, (int) WindowInfo.WINDOW_HEIGHT);
	        g.setColor(Color.BLUE);
	        //g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
			g.drawString("Right player wins", (int)WindowInfo.WINDOW_WIDTH/2 - 100, (int)WindowInfo.WINDOW_HEIGHT - 50);
		}
		else {
			g.setColor(Color.GREEN);
			//g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
			g.drawString(this.leftScore + "   " + this.rightScore, (int)WindowInfo.WINDOW_WIDTH/2 - 35, (int)WindowInfo.WINDOW_HEIGHT - 50);
		}
	}
}