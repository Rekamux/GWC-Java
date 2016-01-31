import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MapSet
{
    // Create a HashSet with these names:
    // Amanda
    // Ann
    // Claudia
    // Veronica
    // Scout
    // Sati
    // ... and return it
    public static HashSet<String> createNames()
    {
        HashSet<String> names = new HashSet<String>();

        names.add( "Amanda" );
        // TODO:  add the missing

        return names;
    }

    // Create a HashMap with these entries:
    // Amanda -> 15
    // Ann -> 17
    // Claudia -> 16
    // Veronica -> 18
    // Scout -> 15
    // Sati -> 21
    // ... and return it
    public static HashMap<String, Integer> createNamesAndAges()
    {
        HashMap<String, Integer> namesAndAges = new HashMap<String, Integer>();

        namesAndAges.put( "Amanda", 15 );
        // TODO:  add the missing entries

        return namesAndAges;
    }

    // Create a HashMap with these entries:
    // Amanda -> Spot
    // Ann -> Sierra
    // Claudia -> Felix
    // Veronica -> Socks
    // Scout -> Thumper
    // Sati -> Rover
    // ... and return it
    public static HashMap<String, String> createNamesAndPets()
    {
        // TODO:  add the missing entries
        return null;
    }

    // Find all the keys linked to an age of 15 and return them in a list
    public static ArrayList<String>
        getWhoIs15( HashMap<String, Integer> namesAndAges )
    {
        ArrayList<String> whoIs15 = new ArrayList<String>();
        Set<String> names = namesAndAges.keySet();

        for( String name : names )
        {
            // TODO:  test if that name is 15 with namesAndAges.get() and add it to the list!
        }

        return whoIs15;
    }

    // Find add the names that start with an A
    public static ArrayList<String> getWhoStartsWithAnA( HashSet<String> names )
    {
        String example = "Berthe";
        if( example.startsWith( "B" ) )
        {
            System.out.println( example + " starts with a 'B'!" );
        }

        // TODO:  create an ArrayList and populate it!

        return null;
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

    public static void main( String[] args ) throws Exception
    {
        {
            String n[] =
                { "Amanda", "Ann", "Claudia", "Veronica", "Scout", "Sati" };
            HashSet<String> names = new HashSet<String>( Arrays.asList( n ) );
            HashSet<String> res = createNames();
            if( names.equals( res ) )
            {
                System.out
                    .println( "createNames has been correctly implemented!" );
            }
            else
            {
                throw new Exception(
                    "createNames:  expected " + names + " got " + res );
            }
        }

        {
            HashMap<String, Integer> namesAndAges =
                new HashMap<String, Integer>();
            namesAndAges.put( "Amanda", 15 );
            namesAndAges.put( "Ann", 17 );
            namesAndAges.put( "Claudia", 16 );
            namesAndAges.put( "Veronica", 18 );
            namesAndAges.put( "Scout", 15 );
            namesAndAges.put( "Sati", 21 );
            HashMap<String, Integer> res = createNamesAndAges();
            if( namesAndAges.equals( res ) )
            {
                System.out.println(
                    "createNamesAndAges has been correctly implemented!" );
            }
            else
            {
                throw new Exception( "createNamesAndAges:  expected "
                    + namesAndAges + " got " + res );
            }
        }

        {
            HashMap<String, String> namesAndPets =
                new HashMap<String, String>();
            namesAndPets.put( "Amanda", "Spot" );
            namesAndPets.put( "Ann", "Sierra" );
            namesAndPets.put( "Claudia", "Felix" );
            namesAndPets.put( "Veronica", "Socks" );
            namesAndPets.put( "Scout", "Thumper" );
            namesAndPets.put( "Sati", "Rover" );
            HashMap<String, String> res = createNamesAndPets();
            if( namesAndPets.equals( res ) )
            {
                System.out.println(
                    "createNamesAndPets has been correctly implemented!" );
            }
            else
            {
                throw new Exception( "createNamesAndPets:  expected "
                    + namesAndPets + " got " + res );
            }
        }

        {
            HashMap<String, Integer> namesAndAges =
                new HashMap<String, Integer>();
            namesAndAges.put( "Amanda", 15 );
            namesAndAges.put( "Ann", 17 );
            namesAndAges.put( "Claudia", 16 );
            namesAndAges.put( "Veronica", 18 );
            namesAndAges.put( "Scout", 15 );
            namesAndAges.put( "Sati", 21 );
            String n[] = { "Amanda", "Scout" };
            ArrayList<String> names =
                new ArrayList<String>( Arrays.asList( n ) );
            ArrayList<String> res = getWhoIs15( namesAndAges );
            if( names.equals( res ) )
            {
                System.out
                    .println( "getWhoIs15 has been correctly implemented!" );
            }
            else
            {
                throw new Exception(
                    "getWhoIs15:  expected " + names + " got " + res );
            }
        }

        {
            String n[] =
                { "Amanda", "Ann", "Claudia", "Veronica", "Scout", "Sati" };
            HashSet<String> names = new HashSet<String>( Arrays.asList( n ) );
            String n2[] = { "Amanda", "Ann" };
            HashSet<String> na = new HashSet<>( Arrays.asList( n2 ) );
            HashSet<String> res = new HashSet<>( getWhoStartsWithAnA( names ) );
            if( na.equals( res ) )
            {
                System.out.println(
                    "getWhoStartsWithAnA has been correctly implemented!" );
            }
            else
            {
                throw new Exception(
                    "getWhoStartsWithAnA:  expected " + na + " got " + res );
            }
        }

        System.out.println( "YOU ARE AWESOME!" );
    }
}
