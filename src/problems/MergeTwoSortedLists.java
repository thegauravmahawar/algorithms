package problems;

import lists.LinkedList;
import utils.ListNode;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 */
public class MergeTwoSortedLists {

    public static void main(String... args) {

        LinkedList l1 = new LinkedList(1, 2, 4);
        LinkedList l2 = new LinkedList(1, 3, 4);
        LinkedList op1 = mergeTwoLists(l1, l2);
        op1.print();

        LinkedList l3 = new LinkedList();
        LinkedList l4 = new LinkedList();
        LinkedList op2 = mergeTwoLists(l3, l4);
        op2.print();

        LinkedList l5 = new LinkedList();
        LinkedList l6 = new LinkedList(0);
        LinkedList op3 = mergeTwoLists(l5, l6);
        op3.print();

        LinkedList l7 = new LinkedList(3);
        LinkedList l8 = new LinkedList(1, 5);
        LinkedList op4 = mergeTwoLists(l7, l8);
        op4.print();

        LinkedList l9 = new LinkedList(1, 3);
        LinkedList l10 = new LinkedList(5);
        LinkedList op5 = mergeTwoLists(l9, l10);
        op5.print();

        LinkedList l11 = new LinkedList(5, 8);
        LinkedList l12 = new LinkedList(6);
        LinkedList op6 = mergeTwoLists(l11, l12);
        op6.print();

        LinkedList l13 = new LinkedList(2, 2, 2, 2);
        LinkedList l14 = new LinkedList(2);
        LinkedList op7 = mergeTwoLists(l13, l14);
        op7.print();

        LinkedList l15 = new LinkedList(2, 4, 6, 8, 8);
        LinkedList l16 = new LinkedList(1, 3, 5, 7, 9);
        LinkedList op8 = mergeTwoLists(l15, l16);
        op8.print();
    }

    /**
     * @param l1
     * @param l2
     * @return LinkedList
     * <p>
     * This code is slightly modified compared to the original question. This uses LinkedList as parameters instead of ListNode.
     */
    private static LinkedList mergeTwoLists(LinkedList l1, LinkedList l2) {
        LinkedList list = new LinkedList();
        ListNode<Integer> ln1 = l1.head;
        ListNode<Integer> ln2 = l2.head;
        while (ln1 != null || ln2 != null) {
            if (ln1 == null) {
                list.add(ln2.data);
                ln2 = ln2.next;
            } else if (ln2 == null) {
                list.add(ln1.data);
                ln1 = ln1.next;
            } else {
                if (ln1.data <= ln2.data) {
                    list.add(ln1.data);
                    ln1 = ln1.next;
                } else {
                    list.add(ln2.data);
                    ln2 = ln2.next;
                }
            }
        }
        return list;
    }
}
