import java.awt.image.ImageObserver;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by waratte on 1/10/2015.
 */
public final class Map {

    private Map() {

        throw new AssertionError();

    }

    protected static Array2D<Integer> Tilemap;
    protected static int Width;
    protected static int Height;

    protected static int TileWidth;
    protected static int TileHeight;
    protected static BufferedImage TileImagemap;

    public static Array2D<Integer> getTilemap() {

        return Tilemap;

    }

    public static void setTilemap(Array2D<Integer> Tilemap) {

        Map.Tilemap = Tilemap;

    }

    public static int getTileWidth() {

        return TileWidth;

    }

    public static void setTileWidth(int TileWidth) {

        Map.TileWidth = TileWidth;

    }

    public static int getTileHeight() {

        return TileHeight;

    }

    public static void setTileHeight(int TileHeight) {

        Map.TileHeight = TileHeight;

    }

    public static BufferedImage getTileImagemap() {

        return TileImagemap;

    }

    public static void setTileImagemap(BufferedImage TileImagemap) {

        Map.TileImagemap = TileImagemap;

    }

    public static void loadTilemap(String Path) {

        // Load map

    }

    public static void loadTileImagemap(String Path) {

        try {

            TileImagemap = ImageIO.read(new File(Path));

        }

        catch( IOException e ) {

            System.out.println(e);

        }


    }

    public static void draw() {

        for( int X = 0; X < Width; ++X ) {

            for( int Y = 0; Y < Height; ++Y ) {

                Game.Context.drawImage(
                    TileImagemap.getSubimage(
                        Tilemap.get(X, Y) * TileWidth,
                        0,
                        TileWidth,
                        TileHeight
                    ),
                    X * TileWidth,
                    Y * TileHeight,
                    Game.Observer
                );

            }

        }

    }

}
