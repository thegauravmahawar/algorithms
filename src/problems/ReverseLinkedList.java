package problems;

import lists.LinkedList;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 */
public class ReverseLinkedList {


    public static void main(String... args) {

        LinkedList l1 = new LinkedList(1, 2, 3, 4, 5);
        l1.reverse();
        l1.print();
    }
}
