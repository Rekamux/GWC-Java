public final class Lab3HalfCorrected
{
    // TREASURE OR TIGER

    // A king is bored of watching executions of his prisoners, and wants to
    // spice things up a little.
    // He decides to give each prisoner a challenge:  they will be presented
    // 2 doors, each with either a tiger or a treasure behind.
    // Each door has a sign, which reads a statement, generally about what's
    // behind the doors.  Each sign can either lie or tell the truth.
    // The king then gives a hint about which sign lies and which doesn't.

    // For each prisoner, implement what the signs say, what the king's hint is,
    // and compare your solution with the one the computer finds in order to
    // save them!

    enum BehindDoor
    {
        TREASURE,
        TIGER
    }

    enum PrisonerSolution
    {
        BOTH_HAVE_TREASURE,
        ROOM1_HAS_TREASURE,
        ROOM2_HAS_TREASURE,
        NEITHER_HAVE_TREASURE,
        SEVERAL_SOLUTIONS,
        NO_SOLUTION
    }

    // First prisoner
    // Room 1's sign reads:
    // "THIS ROOM CONTAINS A TREASURE, AND THE OTHER ONE CONTAINS A TIGER"
    // Room 2's sign reads:
    // "ONE OF THESE ROOMS CONTAINS A TREASURE, AND ONE OF THEM A TIGER"
    // The king says:
    // "Only ONE sign tells the truth, the OTHER lies"
    public class Prisoner1 implements Prisoner
    {
        @Override
        public final String getRoom1sSign()
        {
            return "THIS ROOM CONTAINS A TREASURE, AND THE OTHER ONE CONTAINS A TIGER";
        }

        @Override
        public boolean isRoom1sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE && room2 == BehindDoor.TIGER;
        }

        @Override
        public final String getRoom2sSign()
        {
            return "ONE OF THESE ROOMS CONTAINS A TREASURE, AND ONE OF THEM A TIGER";
        }

        @Override
        public boolean isRoom2sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            return room1 != room2;
        }

        @Override
        public final String getKingsRule()
        {
            return "Only ONE sign tells the truth, the OTHER lies";
        }

        @Override
        public boolean isKingsRuleRespected( BehindDoor r1, BehindDoor r2,
            boolean room1sSignIsTrue, boolean room2sSignIsTrue )
        {
            return room1sSignIsTrue ^ room2sSignIsTrue;
        }

        @Override
        public final PrisonerSolution whatIsTheSolution()
        {
            return PrisonerSolution.ROOM2_HAS_TREASURE;
        }
    }

    public static PrisonerSolution computeTheSolution( Prisoner prisoner )
    {
        for( BehindDoor room1 : BehindDoor.values() )
        {
            for( BehindDoor room2 : BehindDoor.values() )
            {
                boolean room1IsTrue = prisoner.isRoom1sSignTrue( room1, room2 );
                boolean room2IsTrue = prisoner.isRoom2sSignTrue( room1, room2 );
                boolean isKingCorrect = prisoner.isKingsRuleRespected( room1,
                    room2, room1IsTrue, room2IsTrue );

                if( isKingCorrect )
                {
                    if( room1 == BehindDoor.TIGER )
                    {
                        if( room2 == BehindDoor.TIGER )
                        {
                            return PrisonerSolution.NEITHER_HAVE_TREASURE;
                        }
                        else if( room2 == BehindDoor.TREASURE )
                        {
                            return PrisonerSolution.ROOM2_HAS_TREASURE;
                        }
                    }
                    else if( room1 == BehindDoor.TREASURE )
                    {
                        if( room2 == BehindDoor.TIGER )
                        {
                            return PrisonerSolution.ROOM1_HAS_TREASURE;
                        }
                        else if( room2 == BehindDoor.TREASURE )
                        {
                            return PrisonerSolution.BOTH_HAVE_TREASURE;
                        }

                    }
                }
            }
        }
        return PrisonerSolution.NO_SOLUTION;
    }

    // Second prisoner
    // Room 1's sign reads:
    // "THERE IS A TREASURE IN AT LEAST ONE OF THE ROOMS"
    // Room 2's sign reads:
    // "THERE IS A TIGER IN THE OTHER ROOM"
    // The king says:
    // "Either they are BOTH TRUE or they BOTH tell a LIE"
    public class Prisoner2 implements Prisoner
    {
        @Override
        public final String getRoom1sSign()
        {
            return "THERE IS A TREASURE IN AT LEAST ONE OF THE ROOMS";
        }

        @Override
        public boolean isRoom1sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getRoom2sSign()
        {
            return "THERE IS A TIGER IN THE OTHER ROOM";
        }

        @Override
        public boolean isRoom2sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getKingsRule()
        {
            return "Either they are BOTH TRUE or they BOTH tell a LIE";
        }

        @Override
        public boolean isKingsRuleRespected( BehindDoor r1, BehindDoor r2,
            boolean room1sSignIsTrue, boolean room2sSignIsTrue )
        {
            // TODO
            return true;
        }

        @Override
        public final PrisonerSolution whatIsTheSolution()
        {
            // TODO: what do you think the solution is?
            return PrisonerSolution.NO_SOLUTION;
        }
    }

    // Third prisoner
    // Room 1's sign reads:
    // "THERE IS A TREASURE IN BOTH ROOMS"
    // Room 2's sign reads:
    // "THERE IS A TREASURE IN BOTH ROOMS"
    // The king says:
    // "If there is a treasure behind the first door, its sign is true, else it's false.
    //  If there is a treasure behind the second door, its sign is false, else it's true."
    public class Prisoner3 implements Prisoner
    {
        @Override
        public final String getRoom1sSign()
        {
            return "THERE IS A TREASURE IN BOTH ROOMS";
        }

        @Override
        public boolean isRoom1sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getRoom2sSign()
        {
            return "THERE IS A TREASURE IN BOTH ROOMS";
        }

        @Override
        public boolean isRoom2sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getKingsRule()
        {
            return "If there is a treasure behind the first door, its sign is true, else it's false."
                + "If there is a treasure behind the second door, its sign is false, else it's true.";
        }

        @Override
        public boolean isKingsRuleRespected( BehindDoor room1, BehindDoor room2,
            boolean room1sSignIsTrue, boolean room2sSignIsTrue )
        {
            // TODO
            return true;
        }

        @Override
        public final PrisonerSolution whatIsTheSolution()
        {
            // TODO: what do you think the solution is?
            return PrisonerSolution.NO_SOLUTION;
        }
    }

    // Fourth prisoner
    // Room 1's sign reads:
    // "IT WON’T MAKE A DIFFERENCE WHICH DOOR YOU CHOOSE"
    // Room 2's sign reads:
    // "THERE IS A TREASURE IN THE OTHER ROOM"
    // The king says:
    // "If there is a treasure behind the first door, its sign is true, else it's false.
    //  If there is a treasure behind the second door, its sign is false, else it's true."
    public class Prisoner4 implements Prisoner
    {
        @Override
        public final String getRoom1sSign()
        {
            return "IT WON’T MAKE A DIFFERENCE WHICH DOOR YOU CHOOSE";
        }

        @Override
        public boolean isRoom1sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getRoom2sSign()
        {
            return "THERE IS A TREASURE IN THE OTHER ROOM";
        }

        @Override
        public boolean isRoom2sSignTrue( BehindDoor room1, BehindDoor room2 )
        {
            // TODO
            return true;
        }

        @Override
        public final String getKingsRule()
        {
            return "If there is a treasure behind the first door, its sign is true, else it's false."
                + "If there is a treasure behind the second door, its sign is false, else it's true.";
        }

        @Override
        public boolean isKingsRuleRespected( BehindDoor room1, BehindDoor room2,
            boolean room1sSignIsTrue, boolean room2sSignIsTrue )
        {
            // TODO
            return true;
        }

        @Override
        public final PrisonerSolution whatIsTheSolution()
        {
            // TODO: what do you think the solution is?
            return PrisonerSolution.NO_SOLUTION;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public interface Prisoner
    {
        public abstract String getRoom1sSign();

        public abstract boolean isRoom1sSignTrue( BehindDoor room1,
            BehindDoor room2 );

        public abstract String getRoom2sSign();

        public abstract boolean isRoom2sSignTrue( BehindDoor room1,
            BehindDoor room2 );

        public abstract String getKingsRule();

        public abstract boolean isKingsRuleRespected( BehindDoor room1,
            BehindDoor room2, boolean room1sSignIsTrue,
            boolean room2sSignIsTrue );

        public default PrisonerSolution whatIsTheSolution()
        {
            return PrisonerSolution.NO_SOLUTION;
        }
    }

    enum WhichPrisoner
    {
        PRISONER1,
        PRISONER2,
        PRISONER3,
        PRISONER4
    }

    static Prisoner getPrisoner( WhichPrisoner whichPrisoner )
    {
        Lab3HalfCorrected l = new Lab3HalfCorrected();
        switch( whichPrisoner )
        {
        case PRISONER1:
            return l.new Prisoner1();
        case PRISONER2:
            return l.new Prisoner2();
        case PRISONER3:
            return l.new Prisoner3();
        case PRISONER4:
            return l.new Prisoner4();
        default:
            return null;
        }
    }

    static Prisoner getSolution( WhichPrisoner whichPrisoner )
    {
        Lab3HalfCorrected l = new Lab3HalfCorrected();
        switch( whichPrisoner )
        {
        case PRISONER1:
            return l.new Solution1();
        case PRISONER2:
            return l.new Solution2();
        case PRISONER3:
            return l.new Solution3();
        case PRISONER4:
            return l.new Solution4();
        default:
            return null;
        }
    }

    static void testPrisoner( WhichPrisoner whichPrisoner ) throws Exception
    {
        Prisoner prisoner = getPrisoner( whichPrisoner );
        Prisoner solution = getSolution( whichPrisoner );

        System.out.println( prisoner.getRoom1sSign() );
        for( BehindDoor room1 : BehindDoor.values() )
        {
            for( BehindDoor room2 : BehindDoor.values() )
            {
                boolean got = prisoner.isRoom1sSignTrue( room1, room2 );
                boolean expected = solution.isRoom1sSignTrue( room1, room2 );
                String function = whichPrisoner + ".isRoom1sSignTrue( " + room1
                    + ", " + room2 + " )";

                if( got != expected )
                {
                    throw new Exception(
                        function + ":  got " + got + ", expected " + expected );
                }
                System.out.println( function + " = " + got );
            }
        }
        System.out.println( whichPrisoner
            + ":  well done, the sign of the room 1 is implemented!\n" );

        System.out.println( prisoner.getRoom2sSign() );
        for( BehindDoor room1 : BehindDoor.values() )
        {
            for( BehindDoor room2 : BehindDoor.values() )
            {
                boolean got = prisoner.isRoom2sSignTrue( room1, room2 );
                boolean expected = solution.isRoom2sSignTrue( room1, room2 );
                String function = whichPrisoner + ".isRoom2sSignTrue( " + room1
                    + ", " + room2 + " )";

                if( got != expected )
                {
                    throw new Exception(
                        function + ":  got " + got + ", expected " + expected );
                }
                System.out.println( function + " = " + got );
            }
        }
        System.out.println( whichPrisoner
            + ":  well done, the sign of the room 2 is implemented!\n" );

        System.out.println( prisoner.getKingsRule() );
        for( BehindDoor room1 : BehindDoor.values() )
        {
            for( BehindDoor room2 : BehindDoor.values() )
            {
                boolean r1DoesntLie = prisoner.isRoom1sSignTrue( room1, room2 );
                boolean r2DoesntLie = prisoner.isRoom2sSignTrue( room1, room2 );
                boolean got = prisoner.isKingsRuleRespected( room1, room2,
                    r1DoesntLie, r2DoesntLie );
                boolean expected = solution.isKingsRuleRespected( room1, room2,
                    r1DoesntLie, r2DoesntLie );
                String function = whichPrisoner + ".isTheKingsRuleRespected( "
                    + room1 + ", " + room2 + ", " + r1DoesntLie + ", "
                    + r2DoesntLie + " )";

                if( got != expected )
                {
                    throw new Exception(
                        function + ":  got " + got + ", expected " + expected );
                }
                System.out.println( function + " = " + got );
            }
        }
        System.out.println(
            whichPrisoner + ":  well done, the king's rule is implemented!\n" );

        System.out.println( prisoner.getRoom1sSign() );
        System.out.println( prisoner.getRoom2sSign() );
        System.out.println( prisoner.getKingsRule() );

        PrisonerSolution got = prisoner.whatIsTheSolution();
        PrisonerSolution expected = computeTheSolution( prisoner );

        if( got != expected || expected == PrisonerSolution.NO_SOLUTION )
        {
            throw new Exception( whichPrisoner + ".whatIsTheSolution():  got "
                + got + " and it's incorrect :(" );
        }

        System.out.println(
            "Congratulations, you've saved the " + whichPrisoner + "!!!!\n\n" );
    }

    final class Solution1 extends Prisoner1
    {
        @Override
        public final boolean isRoom1sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE && room2 == BehindDoor.TIGER;
        }

        @Override
        public final boolean isRoom2sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 != room2;
        }

        @Override
        public final boolean isKingsRuleRespected( BehindDoor room1,
            BehindDoor room2, boolean room1sSignIsTrue,
            boolean room2sSignIsTrue )
        {
            return room1sSignIsTrue != room2sSignIsTrue;
        }
    }

    final class Solution2 extends Prisoner2
    {
        @Override
        public final boolean isRoom1sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE || room2 == BehindDoor.TREASURE;
        }

        @Override
        public final boolean isRoom2sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TIGER;
        }

        @Override
        public final boolean isKingsRuleRespected( BehindDoor room1,
            BehindDoor room2, boolean room1sSignIsTrue,
            boolean room2sSignIsTrue )
        {
            return room1sSignIsTrue == room2sSignIsTrue;
        }
    }

    final class Solution3 extends Prisoner3
    {
        @Override
        public final boolean isRoom1sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE && room2 == BehindDoor.TREASURE;
        }

        @Override
        public final boolean isRoom2sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE && room2 == BehindDoor.TREASURE;
        }

        @Override
        public final boolean isKingsRuleRespected( BehindDoor room1,
            BehindDoor room2, boolean room1sSignIsTrue,
            boolean room2sSignIsTrue )
        {
            return (room1 == BehindDoor.TREASURE) == room1sSignIsTrue
                && (room2 == BehindDoor.TIGER) == room2sSignIsTrue;
        }
    }

    final class Solution4 extends Prisoner4
    {
        @Override
        public final boolean isRoom1sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == room2;
        }

        @Override
        public final boolean isRoom2sSignTrue( BehindDoor room1,
            BehindDoor room2 )
        {
            return room1 == BehindDoor.TREASURE;
        }

        @Override
        public final boolean isKingsRuleRespected( BehindDoor room1,
            BehindDoor room2, boolean room1sSignIsTrue,
            boolean room2sSignIsTrue )
        {
            return (room1 == BehindDoor.TREASURE) == room1sSignIsTrue
                && (room2 == BehindDoor.TIGER) == room2sSignIsTrue;
        }
    }

    public static void main( String[] args )
    {
        try
        {
            // testTestPrisoner();
            for( WhichPrisoner whichPrisoner : WhichPrisoner.values() )
            {
                testPrisoner( whichPrisoner );
            }
        } catch( Exception e )
        {
            System.err.println( e.getMessage() );
        }
    }

}
