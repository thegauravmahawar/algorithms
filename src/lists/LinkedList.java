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

    public void reverse() {

        ListNode previous = null;
        ListNode current = head;
        ListNode following = head;

        while(current != null) {
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
