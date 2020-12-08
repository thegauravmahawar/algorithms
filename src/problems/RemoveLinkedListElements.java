package problems;

import lists.LinkedList;
import utils.ListNode;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/">Remove Linked List Elements</a>
 */
public class RemoveLinkedListElements {

    public static void main(String... args) {

        LinkedList l1 = new LinkedList(1, 2, 6, 3, 4, 5, 6);
        l1.head = removeElements(l1.head, 6);
        l1.print();

        LinkedList l2 = new LinkedList(1);
        l2.head = removeElements(l2.head, 1);
        l2.print();

        LinkedList l3 = new LinkedList(1);
        l3.head = removeElements(l3.head, 2);
        l3.print();

        LinkedList l4 = new LinkedList(1, 1, 2);
        l4.head = removeElements(l4.head, 1);
        l4.print();

        LinkedList l5 = new LinkedList(1, 1, 1);
        l5.head = removeElements(l5.head, 1);
        l5.print();

        LinkedList l6 = new LinkedList(1, 2, 2, 1);
        l6.head = removeElements(l6.head, 2);
        l6.print();
    }

    /**
     * @param head
     * @param val
     * @return
     */
    private static ListNode removeElements(ListNode<Integer> head, int val) {

        if (head == null) return null;

        while (head != null && head.data == val) head = head.next;

        ListNode<Integer> previous = null;
        ListNode<Integer> current = head;
        ListNode<Integer> next = current == null ? null : current.next;

        while (current != null) {
            if (current.data == val && previous != null) previous.next = next;
            else previous = current;
            current = next;
            next = current == null ? null : current.next;
        }

        return head;
    }
}
