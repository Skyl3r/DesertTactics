import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by waratte on 1/10/2015.
 */
public class Array2D<T> {

    protected T[][] array;

    public Array2D( Class<T> ComponentType, int Width, int Height ) {

        // This will throw an exception if ClassType is not of type T so this is checked/strong typing
        @SuppressWarnings("unchecked")
        final T[][] Temp = (T[][]) Array.newInstance( ComponentType, Width, Height );
        this.array = Temp;

    }

    public T get( int X, int Y ) {

        return array[X][Y];

    }

    public void put( int X, int Y, T Value ) throws ArrayIndexOutOfBoundsException {

        if( X < 0 || Y < 0 ) {

            throw new ArrayIndexOutOfBoundsException("Negative indices not supported");

        }

        if( X >= array.length ) {

            array = Arrays.copyOf( array, X + 1 );

        }

        if( Y >= array[X].length ) {

            for( T[] SecondaryArray : array ) {

                if( SecondaryArray.length != Y ) {

                    SecondaryArray = Arrays.copyOf(SecondaryArray, Y + 1);

                }

            }

        }

        array[X][Y] = Value;

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }

    @Override
    public String toString() {

        return String.format("width = %i, height = %i", array.length, array[0].length );

    }

}