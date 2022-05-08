package il.vgoudk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(List<Integer> nodeValues) {
        if (nodeValues == null || nodeValues.size() == 0) return null;
        ListNode head = new ListNode(nodeValues.get(0));
        ListNode current = head;
        for (int i = 1; i < nodeValues.size(); i++) {
            current.next = new ListNode(nodeValues.get(i));
            current = current.next;
        }
        return head;
    }

    public static List<Integer> toList(ListNode head){
        //TODO: convert this to double pass: 1st to count, 2nd to fill in
        if( head == null) return  null;
        List<Integer> buffer = new ArrayList<>();
        ListNode current = head;
        buffer.add(current.val);
        while (current.next != null){
            current = current.next;
            buffer.add(current.val);
        }
        return buffer;
    }


    @Override
    public String toString() {
        HashSet<ListNode> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            if( visited.contains( current)) {
                sb.append(" .. cycle on ").append(current.val);
                return sb.toString();
            }
            sb.append(" ").append(current.val);
            visited.add(current);
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}