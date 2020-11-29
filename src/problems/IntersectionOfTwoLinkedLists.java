package problems;

import lists.LinkedList;
import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a>
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String... args) {

        LinkedList la = new LinkedList(4, 1);
        ListNode headA = la.add(4);
        ListNode nodeA = la.add(1);

        LinkedList lb = new LinkedList();
        ListNode headB = lb.add(5);
        ListNode nodeB = lb.add(6);
        ListNode nodeB1 = lb.add(1);

        ListNode intersectingNode1 = new ListNode(8);
        intersectingNode1.next = new ListNode(4);
        intersectingNode1.next.next = new ListNode(5);

        nodeA.next = intersectingNode1;
        nodeB1.next = intersectingNode1;
        System.out.println(getIntersectionNode(headA, headB).data);
    }

    /**
     * @param headA
     * @param headB
     * @return
     */
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Map<Integer, ListNode> seenNodesMap = new HashMap<>();

        ListNode a = headA;
        while (a != null) {
            seenNodesMap.put(a.hashCode(), a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null) {
            if (seenNodesMap.containsKey(b.hashCode())) return b;
            b = b.next;
        }

        return null;
    }
}
