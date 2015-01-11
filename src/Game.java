/**
 * Created by Kevin on 1/10/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.util.Random;

public class Game extends JFrame
{
	static final long serialVersionUID = 0;

    public static int Width  = 800;
    public static int Height = 600;

    private static Image DrawingBuffer;
    private static Image BackBuffer;

    public static Graphics Context;
    public static ImageObserver Observer;

	Game()
	{
		super("Game Skeleton");
		JPanel p = new JPanel();
        this.setSize( Width, Height );
        this.setVisible(true);
        p.requestFocus();

        DrawingBuffer = createImage( Width, Height );
        BackBuffer    = createImage( Width, Height );

        Context  = BackBuffer.getGraphics();
        Observer = this;

        Map.Height = 15;
        Map.Width  = 20;

        Map.TileWidth  = 32;
        Map.TileHeight = 32;

        Map.loadTileImagemap("tilemap.png");

        Map.setTilemap(new Array2D<Integer>( Integer.class, Map.Width, Map.Height ));

        Random rand = new Random();

        for( int X = 0; X < Map.Width; ++X ) {

            for( int Y = 0; Y < Map.Height; ++Y ) {

                int TileType = rand.nextInt(5);
                Map.getTilemap().put( X, Y, (TileType < 3) ? 0 : TileType - 2 ); // Makes desert tiles more likely

            }

        }

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
            clearScreen();
            Map.draw();
            swapBuffers();
		}
	}

    public void swapBuffers() {

        Graphics DrawingBufferContext = DrawingBuffer.getGraphics();
        DrawingBufferContext.drawImage( BackBuffer, 0, 0, this );
        this.getGraphics().drawImage( DrawingBuffer, 0, 0, this );

    }

    public void clearScreen() {

        Context.setColor(Color.BLACK);
        Context.fillRect( 0, 0, Width, Height );

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