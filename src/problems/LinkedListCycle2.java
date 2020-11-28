package problems;

import lists.LinkedList;
import utils.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</a>
 */
public class LinkedListCycle2 {

    public static void main(String... args) {

        LinkedList linkedList = new LinkedList();
        ListNode llHead = linkedList.add(3);
        System.out.println(detectCycle(llHead));

        LinkedList linkedList1 = new LinkedList();
        ListNode ll1Head1 = linkedList1.add(3);
        ListNode ll1Node1 = linkedList1.add(5);
        ll1Node1.next = ll1Head1;
        System.out.println(detectCycle(ll1Head1).data);

        LinkedList linkedList2 = new LinkedList();
        ListNode ll2Head2 = linkedList2.add(3);
        ListNode ll2Node1 = linkedList2.add(2);
        ListNode ll2Node2 = linkedList2.add(0);
        ListNode ll2Node3 = linkedList2.add(-4);
        ll2Node3.next = ll2Node1;
        System.out.println(detectCycle(ll2Head2).data);

    }

    /**
     * @param head
     * @return
     */
    private static ListNode detectCycle(ListNode head) {

        ListNode last = head;
        Map<Integer, ListNode> seenNodesMap = new HashMap<>();

        while (last != null) {
            if (seenNodesMap.containsKey(last.hashCode())) return seenNodesMap.get(last.hashCode());
            seenNodesMap.put(last.hashCode(), last);
            last = last.next;
        }

        return null;
    }
}
