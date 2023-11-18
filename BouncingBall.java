import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.util.Random;
import java.util.Timer;

public class BouncingBall extends Canvas
{
	int x, y, dx, dy;
	Color cur;
	Random rng;
	boolean flashing = false;
	
	public static void main( String[] args )
	{
		JFrame win = new JFrame("BouncingBall");
		win.setSize(1010,735);
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		win.add( new BouncingBall() );
		win.setVisible(true);
	}

	public BouncingBall()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		x = 500;
		y = 350;
		dx = 5;
		dy = 5;
		cur = Color.black;
		rng = new Random();
		Timer t = new Timer(true);
		t.schedule( new java.util.TimerTask()
		{
			public void run()
			{
				doStuff();
				repaint();
			}
		}, 10, 10);

	}

	public void paint( Graphics g )
	{
		g.setColor(cur);
		g.fillOval(x, y, 20, 20);
	}

	public void processKeyEvent(KeyEvent e)
	{
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_SPACE )
			{
				flashing = ! flashing;	
			}
		}
	}
	
	public void doStuff()
	{
		x += dx;
		y += dy;

		// and bounce if we hit a wall
		if ( x < 0 || x+20 > 1000 )
			dx = -dx;
		if ( y < 0 || y+20 > 700 )
			dy = -dy;
			
		if ( flashing )
		{
			int r = rng.nextInt(256);
			int g = rng.nextInt(256);
			int b = rng.nextInt(256);
			cur = new Color(r,g,b);
		}
	}
	
	public boolean isFocusable() { return true;	}
}
