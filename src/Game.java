/**
 * Created by Kevin on 1/10/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game extends JFrame
{
	static final long serialVersionUID = 0;
	Image im;

	Game()
	{
		super("Game Skeleton");
		JPanel p = new JPanel();
		this.setSize(600, 600);
		this.setVisible(true);
		p.requestFocus();
	}

	public void makeProgramWait(int milliseconds)
	{
		try
		{
			Thread.sleep(milliseconds);
		}
		catch (Exception e)
		{
			System.out.println("An error in sleep process.");
		}
	}

	public void playGame()
	{
		while (true)
		{
			makeProgramWait(10);
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		if (im == null)
		{
			im = createImage(this.getWidth(), this.getHeight());
		}
		Graphics tempG = im.getGraphics();
		paintScreen(tempG);
		g.drawImage(im, 0, 0, this);
	}

	public void paintScreen(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public static void main(String args[])
	{
		Game app = new Game();
		app.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		app.playGame();
	}
}