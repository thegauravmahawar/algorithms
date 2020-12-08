package lists;

import utils.ListNode;

public class LinkedList {

    public ListNode head;

    public <T> LinkedList(T... arr) {
        for (T data : arr) {
            add(data);
        }
    }

    public <T> ListNode add(T data) {
        if (head == null) {
            head = new ListNode(data);
            return head;
        }
        ListNode last = head;
        while (last.next != null) last = last.next;
        last.next = new ListNode(data);
        return last.next;
    }

    /**
     * Example: 1 -> 2 -> 3 -> 4 -> 5
     * <p>
     * Initially, previous = null, current = 1, following = 1.
     * <p>
     * Loop 1:
     * - following = following.next, i.e. 2 (2 -> 3 -> 4 -> 5)
     * - current.next = previous, i.e. null (1 -> null)
     * - previous = current, i.e. 1 (1 -> null)
     * - current = following, i.e. 2 (2 -> 3 -> 4 -> 5)
     * <p>
     * Loop 2:
     * - following = following.next, i.e. 3 (3 -> 4 -> 5)
     * - current.next = previous, i.e. 1 (2 -> 1 -> null)
     * - previous - current, i.e. 2 (2 -> 1 -> null)
     * - current = following, i.e. 3 (3 -> 4 -> 5)
     * <p>
     * Loop 3:
     * - following = following.next, i.e. 4 (4 -> 5)
     * - current.next = previous, i.e. 2 (3 -> 2 -> 1 -> null)
     * - previous = current, i.e. 3 (3 -> 2 -> 1 -> null)
     * - current = following, i.e. 4 (4 -> 5)
     * <p>
     * Loop 4:
     * - following = following.next, i.e. 5 (5 -> null)
     * - current.next = previous, i.e. 3 (4 -> 3 -> 2 -> 1 -> null)
     * - previous = current, i.e. 4 (4 -> 3 -> 2 -> 1 -> null)
     * - current = following, i.e. 5 (5 -> null)
     * <p>
     * Loop 5:
     * - following = following.next, i.e. null
     * - current.next = previous, i.e. 4 (5 -> 4 -> 3 -> 2 -> 1 -> null)
     * - previous = current, i.e. 5 (5 -> 4 -> 3 -> 2 -> 1 -> null)
     * - current = following, i.e. null
     * <p>
     * Finally previous is assigned to head.
     */
    public void reverse() {

        ListNode previous = null;
        ListNode current = head;
        ListNode following = head;

        while (current != null) {
            following = following.next;
            current.next = previous;
            previous = current;
            current = following;
        }

        head = previous;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            System.out.println(sb.toString());
            return;
        }
        ListNode last = head;
        while (last.next != null) {
            sb.append(last.data).append(", ");
            last = last.next;
        }
        sb.append(last.data);
        System.out.println(sb.toString());
    }

}
