package problems;

/**
 * @author Gaurav Mahawar
 * @see <a href="https://leetcode.com/problems/design-linked-list/">Design Linked List</a>
 */
public class DesignLinkedList {

    public static void main(String... args) {

        MyLinkedList obj1 = new MyLinkedList();
        obj1.addAtHead(1);
        obj1.addAtTail(3);
        obj1.addAtIndex(1, 2);
        System.out.println(obj1.get(0) + " " + obj1.get(1) + " " + obj1.get(2));
        obj1.deleteAtIndex(1);
        System.out.println(obj1.get(1));
        System.out.println();

        MyLinkedList obj2 = new MyLinkedList();
        obj2.addAtHead(4);
        System.out.println(obj2.get(0));
        System.out.println(obj2.get(1));
        System.out.println();

        MyLinkedList obj3 = new MyLinkedList();
        obj3.addAtIndex(0, 10);
        System.out.println(obj3.get(0));
        obj3.addAtIndex(0, 20);
        System.out.println(obj3.get(0));
        obj3.addAtIndex(1, 30);
        System.out.println(obj3.get(0));
        System.out.println(obj3.get(1));
        System.out.println();

        MyLinkedList obj4 = new MyLinkedList();
        obj4.addAtHead(0); //[0]
        System.out.println(obj4.get(0));
        obj4.addAtIndex(1, 4); //[0, 4]
        System.out.println(obj4.get(1));
        obj4.addAtTail(8); //[0, 4, 8]
        System.out.println(obj4.get(2));
        obj4.addAtHead(5); //[5, 0, 4, 8]
        System.out.println(obj4.get(0));
        obj4.addAtIndex(4, 3); //[5, 0, 4, 8, 3]
        System.out.println(obj4.get(4));
        obj4.addAtTail(0); //[5, 0, 4, 8, 3, 0]
        obj4.addAtTail(5); //[5, 0, 4, 8, 3, 0, 5]
        obj4.addAtIndex(6, 3); //[5, 0, 4, 8, 3, 0, 3, 5]
        obj4.deleteAtIndex(7); //[5, 0, 4, 8, 3, 0, 3]
        obj4.deleteAtIndex(5); //[5, 0, 4, 8, 3, 3]
        obj4.addAtTail(4);
        System.out.println();
    }

    static class MyLinkedList {

        ListNode head;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = null;
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index > size - 1) return -1;
            int i = 0;
            ListNode last = head;
            while (i++ < index) last = last.next;
            return last.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode last = head;
            head = new ListNode(val);
            head.next = last;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (head == null) {
                addAtHead(val);
                return;
            }
            ListNode last = head;
            while (last.next != null) last = last.next;
            last.next = new ListNode(val);
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
         * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) addAtHead(val);
            else if (index == size) addAtTail(val);
            else if (index > 0 && index < size) {
                int i = 0;
                ListNode last = head;
                while (++i < index) last = last.next;
                ListNode next = last.next;
                ListNode current = new ListNode(val);
                last.next = current;
                current.next = next;
                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index > size - 1) return;
            if (index == 0) {
                head = head.next;
                return;
            }
            int i = 0;
            ListNode last = head;
            while (++i < index) last = last.next;
            last.next = last.next.next;
            size--;
        }

        class ListNode {

            ListNode next;
            int val;

            public ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }
    }
}
