/* This method is the only one having "main"
 * This class and file should stay here - DO NOT DELETE IT
 * DO NOT change the name of the class or file
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pong extends JPanel implements WindowInfo, KeyListener{
	private static final int FPS = 60;
	private Game pongGame;
	private Ball pongBall;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private int ringRadius = 20;
	private boolean didGameStart = false;
	
	public Pong() {
		pongBall = new Ball();
		leftPaddle = new Paddle(false);
		rightPaddle = new Paddle(true);
		pongGame = new Game(this.pongBall, this.leftPaddle, this.rightPaddle);
		
		this.addKeyListener(leftPaddle);
		this.addKeyListener(rightPaddle);
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension((int)WindowInfo.WINDOW_WIDTH, (int)WindowInfo.WINDOW_HEIGHT));
		Thread mainThread = new Thread(new Runner());
		mainThread.start();
	}
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	public static void main(String[] args) {
		JFrame frame = new JFrame("Ping Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pong world = new Pong();
        frame.setContentPane(world);
        frame.pack();
        frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);            
        //draw here
        g.setColor(new Color(31, 115, 145));
        g.fillRect(0, 0, (int) WindowInfo.WINDOW_WIDTH, (int) WindowInfo.WINDOW_HEIGHT);
        g.setColor(Color.WHITE);
        g.drawLine((int)WindowInfo.WINDOW_WIDTH/2, 0, (int)WindowInfo.WINDOW_WIDTH/2, (int)WindowInfo.WINDOW_HEIGHT);
        g.drawOval((int)(WindowInfo.WINDOW_WIDTH/2 - this.ringRadius), (int)(WindowInfo.WINDOW_HEIGHT/2 - this.ringRadius), this.ringRadius*2, this.ringRadius*2);
        pongBall.drawBall(g);
        leftPaddle.drawPaddle(g);
        rightPaddle.drawPaddle(g);
        pongGame.drawScore(g);
        if (this.didGameStart == false) {
        	g.setColor(Color.ORANGE);
        	g.setFont(new Font("Monospaced", Font.PLAIN, 30));
        	g.drawString("Press ENTER to begin",(int) WindowInfo.WINDOW_WIDTH/2, 100);
        }
    }    
	class Runner implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			double timeSpan = 1.0/(double)FPS;
			while(true) {
				if(didGameStart == true) {
					pongBall.move(timeSpan);
					leftPaddle.move(timeSpan);
					rightPaddle.move(timeSpan);
					pongGame.bounce();
				}
				
				repaint();
				try {
					Thread.sleep(1000/FPS);
				}
				catch(InterruptedException e){}
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER && this.didGameStart == false) {
			this.didGameStart = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}