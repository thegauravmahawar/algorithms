package problems;

import lists.LinkedList;
import utils.ListNode;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String... args) {

        LinkedList l1 = new LinkedList(1, 1, 2);
        deleteDuplicates(l1);
        l1.print();

        LinkedList l2 = new LinkedList(1, 1, 2, 3, 3);
        deleteDuplicates(l2);
        l2.print();

        LinkedList l3 = new LinkedList(1, 1, 2, 3, 5, 5, 5);
        deleteDuplicates(l3);
        l3.print();

        LinkedList l4 = new LinkedList(1, 1, 2, 3, 5, 5, 5, 6);
        deleteDuplicates(l4);
        l4.print();
    }

    /**
     * @param linkedList
     */
    private static void deleteDuplicates(LinkedList linkedList) {

        if (linkedList == null || linkedList.head == null) return;

        ListNode<Integer> current = linkedList.head;
        ListNode<Integer> pointer = current;
        while (current.next != null) {
            if (current.data != current.next.data) {
                pointer.next = current.next;
                pointer = pointer.next;
            }
            current = current.next;
        }
        if (pointer != null && pointer.next != null) pointer.next = null;
    }

}
