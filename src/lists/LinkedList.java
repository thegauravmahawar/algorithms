package lists;

import utils.ListNode;

public class LinkedList {

    public ListNode head;

    public <T> LinkedList(T... data) {
        for (T d : data) {
            add(d);
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
        if (head == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        ListNode last = head;
        while (last.next != null) {
            sb.append(last.data).append(", ");
            last = last.next;
        }
        sb.append(last.data);
        System.out.println(sb.toString());
    }

}
