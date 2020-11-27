package problems;

import lists.LinkedList;
import utils.ListNode;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 */
public class LinkedListCycle {

    public static void main(String... args) {

        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.add(3);
        System.out.println(hasCycle(head));

        LinkedList linkedList1 = new LinkedList();
        ListNode head1 = linkedList1.add(3);
        ListNode node1 = linkedList1.add(5);
        node1.next = head1;
        System.out.println(hasCycle(head1));

    }

    /**
     * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}
