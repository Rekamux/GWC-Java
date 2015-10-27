
public class Lab2
{
    ////////////////////////////////////////////////////////////////////////////
    // EXAMPLES
    ////////////////////////////////////////////////////////////////////////////
    enum MyEnum
    {
        RED,
        BLUE,
        GREEN
    };

    static void examples()
    {
        int myInt = 5;
        char myChar = 'a';
        String myString = "hello!";

        if( myInt < 6 )
        {
            System.out.println( myString + myChar );
        }
        else
        {
            System.out.println( "Good bye!" );
        }

        int counter = 5;
        while( counter > 0 )
        {
            counter = counter - 1;
            System.out.println( "Counter: " + counter );
        }

        MyEnum myEnum = MyEnum.RED;
        System.out.println( myEnum.toString() );
        if( myEnum == MyEnum.RED )
        {
            System.out.println( "Yup, it's " + MyEnum.RED );
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // JANKEN  (ROCK, PAPER, SCISSORS)
    ////////////////////////////////////////////////////////////////////////////
    enum Janken
    {
        ROCK,
        PAPER,
        SCISSORS
    };

    enum WhoWon
    {
        A_WON,
        TIE,
        B_WON
    }

    static WhoWon getWhoWon( Janken aPlay, Janken bPlay )
    {
        if( aPlay == bPlay )
        {
            return WhoWon.TIE;
        }
        else if( (aPlay == Janken.ROCK && bPlay == Janken.SCISSORS)
            || (aPlay == Janken.SCISSORS && bPlay == Janken.PAPER)
            || (aPlay == Janken.PAPER && bPlay == Janken.ROCK) )
        {
            return WhoWon.A_WON;

        }

        return WhoWon.B_WON;
    }

    ////////////////////////////////////////////////////////////////////////////
    // FIBONACCI
    ////////////////////////////////////////////////////////////////////////////

    // Each number of Fibonacci is the sum of the two previous one.
    // The sequence starts with 1 and 1:
    // 1
    // 1
    // 1 + 1 = 2
    // 1 + 2 = 3
    // 2 + 3 = 5
    // 3 + 5 = 8...
    // 5 + 8 = 13

    static int getNextFibonacciNumber( int previous_previous, int previous )
    {
        return previous_previous + previous;
    }

    static int getFirstFibonacciNumberGreaterThan( int minimum )
    {
        int previous_previous = 1;

        int previous = 1;

        while( previous <= minimum )
        {
            int next = getNextFibonacciNumber( previous_previous, previous );
            System.out.println( "Next: " + next );
            previous_previous = previous;
            previous = next;
        }

        return previous;
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
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public static void main( String[] args )
    {
        runTests();
    }

    public static boolean testJanken( Janken a, Janken b )
    {
        boolean tie = a == b;
        boolean a_won =
            a.ordinal() - b.ordinal() == 1 || a.ordinal() - b.ordinal() == -2;
        WhoWon expected =
            tie ? WhoWon.TIE : a_won ? WhoWon.A_WON : WhoWon.B_WON;
        WhoWon whoWon = getWhoWon( a, b );
        boolean result = expected == whoWon;
        String gameResult = "A(" + a + ") vs B(" + b + "): " + whoWon;

        if( result )
        {
            System.out.println( gameResult );
        }
        else
        {
            System.err.println( gameResult + ", expected " + expected );
        }

        return result;
    }

    public static boolean testFibonacci( int min )
    {
        int a = 1, b = 1;
        while( b <= min )
        {
            int nextFibo = getNextFibonacciNumber( a, b );
            String nextFiboResult =
                "getNextFibonacciNumber(" + a + ", " + b + ") = " + nextFibo;
            b = a + b;
            a = b - a;

            if( b == nextFibo )
            {
                System.out.println( nextFiboResult );
            }
            else
            {
                System.err.println( nextFiboResult + ", expected " + b );
                return false;
            }
        }

        int firstGreater = getFirstFibonacciNumberGreaterThan( min );
        String firstGreaterResult =
            "getFirstFibonacciNumberGreaterThan(" + min + ") = " + firstGreater;

        if( b == firstGreater )
        {
            System.out.println( firstGreaterResult );
            return true;
        }
        else
        {
            System.err.println( firstGreaterResult + ", expected " + b );
            return false;
        }
    }

    public static void runTests()
    {
        for( Janken a : Janken.values() )
        {
            for( Janken b : Janken.values() )
            {
                if( !testJanken( a, b ) )
                {
                    System.err.println( "JANKEN TEST:  FAILURE" );
                    return;
                }
            }
        }
        System.out.println( "JANKEN TEST:  SUCCESS!" );
        for( int i = 0; i <= 100; i += 20 )
        {
            if( !testFibonacci( i ) )
            {
                System.err.println( "FIBONACCI TEST:  FAILURE" );
                return;
            }
        }
        System.out.println( "FIBONACCI TEST:  SUCCESS!" );
    }
}
