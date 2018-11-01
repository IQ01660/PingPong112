/* This method is the only one having "main"
 * This class and file should stay here - DO NOT DELETE IT
 * DO NOT change the name of the class or file
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pong extends JPanel implements WindowInfo{
	private static final int FPS = 60;
	public Pong() {
		this.setPreferredSize(new Dimension((int)WindowInfo.WINDOW_WIDTH, (int)WindowInfo.WINDOW_HEIGHT));
		Thread mainThread = new Thread(new Runner());
		mainThread.start();
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
    }    
	class Runner implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				
				repaint();
				try {
					Thread.sleep(1000/FPS);
				}
				catch(InterruptedException e){}
			}
		}
		
	}
}