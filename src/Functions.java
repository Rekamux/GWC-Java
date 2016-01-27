import java.util.Arrays;
import java.util.Random;

public class Functions
{

    static double area_of_circle( double diameter )
    {
        return diameter / 2.0 * diameter / 2.0 * 3.1416;
    }

    public static char my_function( int arg1, String arg2 )
    {
        char result = '0';
        // Do stuff
        return result;
    }

    public static int factorial_iterative( int n )
    {
        int result = 1;

        for( int i = 2; i <= n; i++ )
        {
            result *= i;
        }

        return result;
    }

    public static int factorial_recursive( int n )
    {
        if( n <= 1 )
        {
            return 1;
        }

        return n * factorial_recursive( n - 1 );
    }

    public static void insertion_sort( int array[], int last_index )
    {
        if( last_index == 0 )
        {
            return;
        }

        insertion_sort( array, last_index - 1 );

        int to_be_inserted = array[last_index];
        int index_comparison = last_index - 1;
        while( index_comparison >= 0
            && array[index_comparison] > to_be_inserted )
        {
            array[index_comparison + 1] = array[index_comparison];
            index_comparison--;
        }
        array[index_comparison + 1] = to_be_inserted;
    }

    public static void main( String[] args )
    {
        System.out.println( "The program has started!" );

        int array[] = new int[10];
        Random r = new Random();
        for( int i = 0; i < array.length; i++ )
        {
            array[i] = r.nextInt( 10 );
        }
        int witness[] = Arrays.copyOf( array, array.length );
        Arrays.sort( witness );

        insertion_sort( array, array.length - 1 );

        if( Arrays.equals( array, witness ) )
        {

            System.out.println( "VICTORY!!" );
        }
        else
        {
            System.out.println( "FAILURE" );
        }
    }
}
