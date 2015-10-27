import java.util.Arrays;
import java.util.Random;

/**
 *
 * Let's play with Arrays!
 *
 * @author Ax
 *
 */
public class Lab4
{
    /**
     * Return the character at the index 10
     *
     * @param array
     *            an array of more than 10 characters
     * @return the character at the index 10
     */
    static char getCharAtIndex10( char array[] )
    {
        char charAtIndex5 = array[5];
        System.out.println( "The character at index 5 is " + charAtIndex5 );

        char charAtIndex10 = array[10]; // TODO get the char at the index 10!
        System.out.println( "The character at index 10 is " + charAtIndex10 );
        return charAtIndex10;
    }

    /**
     * Return the index of the first "5" of the array
     *
     * @param array
     *            array containing at least a "5"
     * @return the index of the first "5"
     */
    static int getIndexOfThe5( int array[] )
    {
        int size = array.length;
        System.out.println( Arrays.toString( array ) );
        for( int i = 0; i < size; i++ )
        {
            int elementAtI = array[i];
            System.out
                .println( "The element at index " + i + " is " + elementAtI );
            if( array[i] == 5 )
            {
                return i;
            }
        }
        return 0;
    }

    /**
     * Copy a boolean Array into an other
     *
     * @param arrayToBeCopied
     *            array to be copied
     * @return a copy of arrayToBeCopied
     */
    static boolean[] copyBooleanArray( boolean arrayToBeCopied[] )
    {
        int size = arrayToBeCopied.length;
        boolean copy[] = new boolean[size];
        for( int i = 0; i < size; i++ )
        {
            copy[i] = arrayToBeCopied[i]; // TODO: copy arrayToBeCopied
        }
        return copy;
    }

    /**
     * Return the biggest integer in an Array
     *
     * @param array
     *            contains a bunch of integers
     * @return the biggest integer
     */
    static int getBiggestInt( int array[] )
    {
        int biggest = array[0];
        for( int element : array )
        {
            if( element > biggest )
            {
                biggest = element;
            }
        }
        return biggest; // TODO
    }

    /**
     * Return the smallest double in an Array
     *
     * @param array
     *            contains a bunch of doubles
     * @return the smallest double
     */
    static double getSmallestDouble( double array[] )
    {
        double smallest = array[0];
        for( double element : array )
        {
            if( element < smallest )
            {
                smallest = element;
            }
        }
        return smallest; // TODO
    }

    /**
     * Find the biggest and the smallest integer in an array, and swap them
     *
     * @param array
     *            the array to be treated
     */
    static void swapSmallestAndBiggest( int array[] )
    {
        int smallest = 0, biggest = 0;
        for( int i = 0; i < array.length; i++ )
        {
            if( array[smallest] > array[i] )
            {
                smallest = i;
            }
            if( array[biggest] < array[i] )
            {
                biggest = i;
            }
        }
        int tmp = array[smallest];
        array[smallest] = array[biggest];
        array[biggest] = tmp;
        // TODO
    }

    /**
     * Find all the duplicates and replace them with a zero
     *
     * @param array
     *            array of digits in 1-9
     */
    static void replaceDuplicateWithZero( int array[] )
    {
        int counts[] = new int[10];
        for( int i = 1; i < 10; i++ )
        {
            counts[i] = 0;
        }
        for( int i = 0; i < array.length; i++ )
        {
            counts[array[i]]++;
            if( counts[array[i]] > 1 )
            {
                array[i] = 0;
            }
        }
        // TODO
    }

    /**
     * Sort an array of integers!
     *
     * @param array
     *            to be sorted
     */
    static void sortArray( int array[] )
    {
        // TODO
        Arrays.sort( array );
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    static int LOOPS = 3;

    static void test_getCharAtIndex10() throws Exception
    {
        Random r = new Random();
        for( int i = 0; i < LOOPS; i++ )
        {
            char array[] = new char[15];
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = (char) ('A' + r.nextInt( 26 ));
            }
            char expected = array[10];
            char got = getCharAtIndex10( array );
            String call =
                "getCharAtIndex10( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
            System.out.println( call + " = " + got );
        }

        System.out.println( "Well done!  getCharAtIndex10 is implemented!\n" );
    }

    static void test_getIndexOfThe5() throws Exception
    {
        Random r = new Random();
        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = new int[10];
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextInt( 5 );
            }
            int expected = r.nextInt( array.length );
            array[expected] = 5;
            int got = getIndexOfThe5( array );
            String call = "getIndexOfThe5( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
            System.out.println( call + " = " + got );
        }

        System.out.println( "Well done!  getIndexOfThe5 is implemented!\n" );
    }

    static void test_copyBooleanArray() throws Exception
    {
        Random r = new Random();
        for( int i = 0; i < LOOPS; i++ )
        {
            boolean array[] = new boolean[10];
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextBoolean();
            }
            boolean expected[] = Arrays.copyOf( array, array.length );
            boolean got[] = copyBooleanArray( array );
            String call =
                "copyBooleanArray( " + Arrays.toString( array ) + " )";
            if( array == got )
            {
                throw new Exception( call
                    + ": you didn't return a copy, you returned the array itself!" );
            }
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }
            System.out.println( call + " = " + Arrays.toString( got ) );
        }

        System.out.println( "Well done!  copyBooleanArray is implemented!\n" );
    }

    static void test_getBiggestInt() throws Exception
    {
        Random r = new Random();
        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = new int[10];
            int expected = 0;
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextInt( 500 );
                if( j == 0 || expected < array[j] )
                {
                    expected = array[j];
                }
            }
            int got = getBiggestInt( array );
            String call = "getBiggestInt( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
            System.out.println( call + " = " + got );
        }

        System.out.println( "Well done!  getBiggestInt is implemented!\n" );
    }

    static void test_getSmallestDouble() throws Exception
    {
        Random r = new Random();
        for( int i = 0; i < LOOPS; i++ )
        {
            double array[] = new double[10];
            double expected = 0;
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextDouble();
                if( j == 0 || expected > array[j] )
                {
                    expected = array[j];
                }
            }
            double got = getSmallestDouble( array );
            String call =
                "getSmallestDouble( " + Arrays.toString( array ) + " )";
            if( expected != got )
            {
                throw new Exception(
                    call + ": expected " + expected + ", got " + got );
            }
            System.out.println( call + " = " + got );
        }

        System.out.println( "Well done!  getSmallestDouble is implemented!\n" );
    }

    static void test_swapSmallestAndBiggest() throws Exception
    {
        Random r = new Random();

        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = new int[10];
            int smallest = 0, biggest = 0;
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextInt( 500 );
                if( j != 0 )
                {
                    if( array[smallest] > array[j] )
                    {
                        smallest = j;
                    }
                    if( array[biggest] < array[j] )
                    {
                        biggest = j;
                    }
                }
            }

            int expected[] = Arrays.copyOf( array, array.length );
            int tmp = expected[biggest];
            expected[biggest] = expected[smallest];
            expected[smallest] = tmp;

            int got[] = Arrays.copyOf( array, array.length );
            swapSmallestAndBiggest( got );

            String call =
                "swapSmallestAndBiggest( " + Arrays.toString( array ) + " )";
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }
            System.out.println( call + " = " + Arrays.toString( got ) );
        }

        System.out
            .println( "Well done!  swapSmallestAndBiggest is implemented!\n" );
    }

    static void test_replaceDuplicateWithZero() throws Exception
    {
        Random r = new Random();

        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = new int[20];
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextInt( 9 ) + 1;
            }

            int expected[] = Arrays.copyOf( array, array.length );
            int got[] = Arrays.copyOf( array, array.length );
            int counts[] = new int[10];
            for( int j = 0; j < counts.length; j++ )
            {
                counts[j] = 0;
            }
            for( int j = 0; j < expected.length; j++ )
            {
                counts[expected[j]]++;
                if( counts[expected[j]] > 1 )
                {
                    expected[j] = 0;
                }
            }

            replaceDuplicateWithZero( got );

            String call =
                "replaceDuplicateWithZero( " + Arrays.toString( array ) + " )";
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }
            System.out.println( call + " = " + Arrays.toString( got ) );
        }

        System.out.println(
            "Well done!  replaceDuplicateWithZero is implemented!\n" );
    }

    static void test_sortArray() throws Exception
    {
        Random r = new Random();

        for( int i = 0; i < LOOPS; i++ )
        {
            int array[] = new int[20];
            for( int j = 0; j < array.length; j++ )
            {
                array[j] = r.nextInt( 100 );
            }

            int expected[] = Arrays.copyOf( array, array.length );
            int got[] = Arrays.copyOf( array, array.length );

            Arrays.sort( expected );
            sortArray( got );

            String call = "sortArray( " + Arrays.toString( array ) + " )";
            if( !Arrays.equals( expected, got ) )
            {
                throw new Exception(
                    call + ": expected " + Arrays.toString( expected )
                        + ", got " + Arrays.toString( got ) );
            }
            System.out.println( call + " = " + Arrays.toString( got ) );
        }

        System.out.println( "Well done!  sortArray is implemented!\n" );
    }

    public static void main( String args[] )
    {
        try
        {
            test_getCharAtIndex10();
            test_getIndexOfThe5();
            test_copyBooleanArray();
            test_getBiggestInt();
            test_getSmallestDouble();
            test_swapSmallestAndBiggest();
            test_replaceDuplicateWithZero();
            test_sortArray();
            System.out.println( "AWESOME JOB!!!!" );
        } catch( Exception e )
        {
            System.err.println( e.getMessage() );
        }
    }
}
