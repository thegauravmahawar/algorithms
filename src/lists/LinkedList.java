package lists;

import utils.ListNode;

public class LinkedList {

    public ListNode head;

    public <T> LinkedList(T... arr) {
        for (T data : arr) {
            add(data);
        }
    }

    public <T> void add(T data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode last = head;
        while (last.next != null) last = last.next;
        last.next = new ListNode(data);
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
