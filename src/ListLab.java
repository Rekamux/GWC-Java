import java.util.Random;

public class ListLab
{
    static class ListNode
    {
        int value;
        ListNode next;

        ListNode( int value )
        {
            this.value = value;
        }
    }

    public static void main( String args[] ) throws Exception
    {
        test_append();
        test_insert();
        test_delete();
    }

    /**
     * Append the newValue to the list tail
     *
     * @param newValue
     *            A new number to be inserted in the list
     * @param head
     *            The head node of the list
     * @return The head of the list who has appended the newValue
     */
    public static ListNode append( int newValue, ListNode head )
    {
        if( head == null )
        {
            return new ListNode( newValue );
        }
        //        head.next = new ListNode( newValue );
        //        return head;
        ListNode last = head;
        while( last.next != null )
        {
            last = last.next;
        }
        last.next = new ListNode( newValue );
        return head;
    }

    /**
     * Insert the newValue into the sorted list and make sure it's still sorted
     *
     * @param newValue
     *            A new number to be inserted in the list
     * @param head
     *            The head node of the list
     * @return The head of the list who has inserted the newValue
     */
    public static ListNode insert( int newValue, ListNode head )
    {
        if( head == null )
        {
            return append( newValue, null );
        }
        if( head.value > newValue )
        {
            ListNode newHead = new ListNode( newValue );
            newHead.next = head;
            return newHead;
        }
        ListNode ptr = head;
        while( ptr.next != null && ptr.next.value < newValue )
        {
            ptr = ptr.next;
        }

        ListNode next = ptr.next;
        ptr.next = new ListNode( newValue );
        ptr.next.next = next;
        return head;
    }

    /**
     * Find the target value in the list and delete it from the list
     *
     * @param targetValue
     *            A number to be looked up in the list
     * @param head
     *            The head node of the list
     * @return The head of the list who has removed the targetValue
     */
    public static ListNode delete( int targetValue, ListNode head )
    {
        ListNode ptr = head;

        if( head == null )
        {
            return null;
        }

        if( head.value == targetValue )
        {
            return head.next;
        }

        while( ptr.next != null && ptr.next.value != targetValue )
        {
            ptr = ptr.next;
        }
        if( ptr.next != null )
        {
            ListNode nextnext = ptr.next.next;
            ptr.next = nextnext;
        }
        return head;
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

    public static void test_append() throws Exception
    {

        ListNode head1 = new ListNode( 0 );
        ListNode result1 = append( 1, head1 );
        if( !assertValues( result1, "0, 1, " ) || result1 != head1 )
        {
            throw new Exception(
                "Woopoos! Something went wrong for append. Please check again." );
        }

        ListNode head2 = null;
        ListNode result2 = append( 1, head2 );
        if( !assertValues( result2, "1, " ) )
        {
            throw new Exception(
                "Woopoos! Something went wrong for append. Please check again." );
        }

        ListNode head3 = head1;
        ListNode result3 = append( 2, head3 );
        if( !assertValues( result3, "0, 1, 2, " ) || result3 != head3 )
        {
            throw new Exception(
                "Woopoos! Something went wrong for append. Please check again." );
        }

        println( "Well done! append is implemented!" );
    }

    public static void test_insert() throws Exception
    {
        ListNode head = new ListNode( 1 );
        ListNode result = insert( 0, head );
        if( !assertValues( result, "0, 1, " ) || result.next != head )
        {
            throw new Exception(
                "Woopoos! Something went wrong for insert. Please check again." );
        }

        ListNode head2 = new ListNode( 1 );
        ListNode n = new ListNode( 3 );
        head2.next = n; // 1->3
        ListNode result2 = insert( 2, head2 );
        if( !assertValues( result2, "1, 2, 3, " ) || result2 != head2 )
        {
            throw new Exception(
                "Woopoos! Something went wrong for insert. Please check again." );
        }

        println( "Well done! insert is implemented!" );
    }

    public static void test_delete() throws Exception
    {
        ListNode head1 = new ListNode( 1 );
        ListNode n = new ListNode( 3 );
        head1.next = n; // 1->3
        ListNode result1 = delete( 3, head1 );
        if( !assertValues( result1, "1, " ) || head1 != result1 )
        {
            throw new Exception(
                "Woopoos! Something went wrong for delete. Please check again." );
        }

        ListNode head2 = new ListNode( 1 );
        ListNode n2 = new ListNode( 2 );
        head2.next = n2; // 1->2
        ListNode result2 = delete( 1, head2 );
        if( !assertValues( result2, "2, " ) || head2.next != result2 )
        {
            throw new Exception(
                "Woopoos! Something went wrong for delete. Please check again." );
        }

        println( "Well done! delete is implemented!" );
    }

    private static void println( String s )
    {
        System.out.println( s );
    }

    private static ListNode listGenerator( int l )
    {
        Random r = new Random();

        ListNode fakeH = new ListNode( -1 );
        ListNode current = fakeH;

        for( int i = 0; i < l; i++ )
        {
            ListNode n = new ListNode( r.nextInt( 100 ) );
            current.next = n;
            current = current.next;
        }

        return fakeH.next;
    }

    private static boolean assertValues( ListNode head, String s2 )
    {
        return toString( head ).equals( s2 );
    }

    private static String toString( ListNode head )
    {
        String s = "";
        while( head != null )
        {
            s += head.value;
            s += ", ";
            head = head.next;
        }
        return s;
    }
}
