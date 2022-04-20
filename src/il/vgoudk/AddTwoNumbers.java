package il.vgoudk;

public class AddTwoNumbers {


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        addDigit(l1, l2, root, 0);
        return root.next;
    }

    void addDigit(ListNode l1, ListNode l2, ListNode ret, int fromPrevDigit) {
        if (l1 == null && l2 == null) {
            if (fromPrevDigit != 0) {
                ret.next = new ListNode(fromPrevDigit);
            }
            return;
        }

        int sum = fromPrevDigit;
        if (l1 == null) sum += l2.val;
        else if (l2 == null) sum += l1.val;
        else sum += l1.val + l2.val;

        final int thisDigit;
        final int addToNextDigit;
        if (sum > 9) {
            thisDigit = sum - 10;
            addToNextDigit = 1;
        } else {
            thisDigit = sum;
            addToNextDigit = 0;
        }

        ret.next = new ListNode(thisDigit);
        addDigit(l1 == null ? null : l1.next, l2 == null ? null : l2.next, ret.next, addToNextDigit);
    }


    public static class ListNode {
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
    }
}