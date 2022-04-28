package il.vgoudk;

import java.util.LinkedList;
import java.util.List;

public class MergeKSortedLists {
    public static List<Integer> flatten(ListNode root) {
        List<Integer> ret = new LinkedList<>();
        ListNode current = root;
        while (current != null) {
            ret.add(current.val);
            current = current.next;
        }
        return ret;


    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) return null;
        final int len = lists.length;
        if (len == 0) return null;


        ListNode dummy = new ListNode();
        ListNode prevOutNode = dummy;

        ListNode[] roots = new ListNode[len];
        for (int i = 0; i < len; i++) {
            roots[i] = lists[i];
        }


        while (true) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                if (roots[i] != null) {
                    min = Math.min(min, roots[i].val);
                }
            }

            if (min == Integer.MAX_VALUE) break;

            for (int i = 0; i < len; i++) {
                if (roots[i] != null && roots[i].val == min) {
                    prevOutNode.next = new ListNode(min);
                    prevOutNode = prevOutNode.next;
                    roots[i] = roots[i].next;
                }
            }
        }
        return dummy.next;
    }
}