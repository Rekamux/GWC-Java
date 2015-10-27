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
    public static void examples()
    {
        // Create a new array of 10 booleans
        boolean array[] = new boolean[10];

        // Access the 5th element (index 0 is the first!)
        array[5] = true;
        if( false == array[5] )
        {
            System.out.println( "Well, that was unexpected" );
        }

        // Get the size of the array (which is 10 here)
        int size = array.length;

        // Loop on all the elements with the index
        for( int i = 0; i < size; i++ )
        {
            array[i] = false;
        }

        // Loop on all the elements without an index
        // WARNING: that means you cannot modify the array!
        for( boolean element : array )
        {
            System.out.println( element );
        }
    }

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

        char charAtIndex10 = '0'; // TODO get the char at the index 10!
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
        for( int i = 0; i < size; i++ )
        {
            int elementAtI = array[i];
            System.out
                .println( "The element at index " + i + " is " + elementAtI );
            // TODO
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
            copy[i] = false; // TODO: copy arrayToBeCopied
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
        return 0; // TODO
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
        return 10.0; // TODO
    }

    /**
     * Find the biggest and the smallest integer in an array, and swap them
     *
     * @param array
     *            the array to be treated
     */
    static void swapSmallestAndBiggest( int array[] )
    {
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
        // TODO
    }

    /**
     * Sort an array of integers!
     *
     * @param array
     *            to be sorted from the smallest to the biggest
     */
    static void sortArray( int array[] )
    {
        // TODO
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
