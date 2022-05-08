package il.vgoudk;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if( head == null) return null;
        ListNode ret = swapOnePair( head);
        ListNode current = ret;
        while ( true){
            if( current.next == null) break;
            current = current.next;
            final ListNode prev = current;
            if( current.next == null) break;
            current = current.next;
            current = swapOnePair( current);
            prev.next = current;
        }
        return ret;
    }

    ListNode swapOnePair(ListNode current) {
        final ListNode second = current.next;
        if( second == null) return current;

        final ListNode third = second.next;

        second.next = current;
        current.next = third;
        return second;
    }

}