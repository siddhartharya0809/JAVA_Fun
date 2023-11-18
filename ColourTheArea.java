import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class ColourTheArea extends Canvas
{
	int x, y;
	Color cur;
	
	public static void main( String[] args )
	{
		JFrame wind = new JFrame("Use the arrow keys!");
		wind.setSize(1024,758	);
		wind.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		wind.add( new ColourTheArea() );
		wind.setVisible(true);
	}

	public ColourTheArea()
	{
		enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
		requestFocus();
		x = 500;
		y = 300;
		cur = Color.PINK;
	}

	public void paint( Graphics gr)
	{
		gr.setColor(cur);
		gr.fillOval(x, y, 30, 30);
	}

	public void update( Graphics g )
	{
		paint(g);
	}

	public void processKeyEvent(KeyEvent e)
	{
		// it is called automatically when this any key is pressed
		if ( e.getID() == KeyEvent.KEY_PRESSED )
		{
			if ( e.getKeyCode() == KeyEvent.VK_UP )
				y -= 5;
			if ( e.getKeyCode() == KeyEvent.VK_DOWN )
				y += 5;
			if( e.getKeyCode() == KeyEvent.VK_RIGHT )
				x +=5;
			if(e.getKeyCode() == KeyEvent.VK_LEFT )
				x -=5;

			// and we manually call paint() again to redraw
			repaint();
		}
	}
	
	public boolean isFocusable()
	{
		return true;
	}
}
