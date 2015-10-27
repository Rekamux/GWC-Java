import java.util.Arrays;
import java.util.Random;

public class Lab5
{

    static int getBiggestInt_On( int array[] )
    {
        int biggest = array[0];
        for( int i = 1; i < array.length; i++ )
        {
            if( array[i] > biggest )
            {
                biggest = array[i];
            }
        }
        return biggest;
    }

    static int getBiggestInt_On2( int array[] )
    {
        boolean isBiggest[] = new boolean[array.length];
        for( int i = 0; i < array.length; i++ )
        {
            isBiggest[i] = true;
        }
        for( int i = 0; i < array.length; i++ )
        {
            for( int element : array )
            {
                if( element > array[i] )
                {
                    isBiggest[i] = false;
                }
            }
        }
        for( int i = 0; i < array.length; i++ )
        {
            if( isBiggest[i] )
            {
                return array[i];
            }
        }

        return 0;
    }

    static void swap( int array[], int i, int j )
    {
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    static void insertionSort_On2( int array[] )
    {
        insertionSort_On2_upTo( array, array.length );
    }

    static void insertionSort_On2_upTo( int array[], int end )
    {
        for( int i = 1; i < end; i++ )
        {
            for( int j = i; j > 0 && array[j - 1] > array[j]; j-- )
            {
                swap( array, j - 1, j );
            }
        }
    }

    static void badSort_On3( int array[] )
    {
        for( int i = 0; i <= array.length; i++ )
        {
            insertionSort_On2_upTo( array, i );
        }
    }

    static int LOOPS = 3;

    static void test_getBiggestInt() throws Exception
    {
        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = generateArray( 100 );
            int expected = 0;
            for( int j = 0; j < array.length; j++ )
            {
                if( j == 0 || expected < array[j] )
                {
                    expected = array[j];
                }
            }
            int got = getBiggestInt_On2( array );
            String call =
                "getBiggestInt_On2( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
            got = getBiggestInt_On( array );
            call = "getBiggestInt_On( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
        }
    }

    static void test_sortArray() throws Exception
    {
        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = generateArray( 100 );
            int expected[] = Arrays.copyOf( array, array.length );
            int got[] = Arrays.copyOf( array, array.length );

            Arrays.sort( expected );

            insertionSort_On2( got );
            String call =
                "insertionSort_On2( " + Arrays.toString( array ) + " )";
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }

            got = Arrays.copyOf( array, array.length );
            badSort_On3( got );
            call = "badSort_On3( " + Arrays.toString( array ) + " )";
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }
        }
    }

    interface Execute
    {
        void execute( int array[] );
    }

    class ExecuteBiggestIntOn implements Execute
    {
        @Override
        public void execute( int[] array )
        {
            getBiggestInt_On( array );
        }
    }

    class ExecuteBiggestIntOn2 implements Execute
    {
        @Override
        public void execute( int[] array )
        {
            getBiggestInt_On2( array );
        }
    }

    class ExecuteInsertionSortOn2 implements Execute
    {
        @Override
        public void execute( int[] array )
        {
            insertionSort_On2( array );
        }
    }

    class ExecuteBadSortOn3 implements Execute
    {
        @Override
        public void execute( int[] array )
        {
            badSort_On3( array );
        }
    }

    static int[] generateArray( int size )
    {
        Random r = new Random();
        int array[] = new int[size];
        for( int j = 0; j < array.length; j++ )
        {
            array[j] = r.nextInt( size );
        }
        return array;
    }

    static int[] sizes = { 1000, 10000, 100000, 150000 };

    static String getPrettyTime( long nano )
    {
        int M = 1000;
        int n = (int) (nano - (nano / M * M));
        nano /= M;
        int u = (int) (nano - (nano / M * M));
        nano /= M;
        int m = (int) (nano - (nano / M * M));
        nano /= M;
        int s = (int) (nano - (nano / M * M));
        nano /= M;
        String r = s == 0 ? "" : s + "s ";
        r += m == 0 ? "" : m + "ms ";
        r += u == 0 ? "" : u + "us ";
        r += n == 0 ? "" : n + "ns";
        return r;
    }

    static void measureTime( Execute e, int size )
    {
        int array[] = generateArray( size );
        long t0 = System.nanoTime();
        e.execute( array );
        long t1 = System.nanoTime();
        long d = t1 - t0;
        System.out
            .println( e.getClass().getName() + " got " + getPrettyTime( d ) );
    }

    static void run()
    {
        Lab5 l = new Lab5();
        for( int size : sizes )
        {
            System.out.println( "\nFOR A SIZE OF " + size );
            measureTime( l.new ExecuteBiggestIntOn(), size );
            measureTime( l.new ExecuteBiggestIntOn2(), size );
            measureTime( l.new ExecuteInsertionSortOn2(), size );
            measureTime( l.new ExecuteBadSortOn3(), size );
        }
    }

    public static void main( String args[] ) throws Exception
    {
        test_getBiggestInt();
        test_sortArray();
        System.out.println( "TESTS DONE\n" );
        run();
    }
}
