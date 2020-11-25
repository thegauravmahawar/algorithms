## Lists

<h3>Basics</h3>

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String... args) {

        List<Integer> v1 = new ArrayList<>(); //initialize list
        List<Integer> v2; //v2 == null

        //Cast array to a list
        int[] a = new int[]{1, 2, 3, 4, 5};
        v2 = new ArrayList<>(Arrays.asList(a));

        //Make copy
        List<Integer> v3 = v2; //another reference to v2
        List<Integer> v4 = new ArrayList<>(v2); //make actual copy of v2

        //Sort
        Collections.sort(v2);

        //Add new elements
        v2.add(6);
        v2.add(7);

        //Modify list
        v2.set(0, 3); //change value at first index.

        //Delete element
        v2.remove(v2.size() - 1); //delete element at last index.

    }

}
```

<h3>Linked List</h3>

Similar to the array, the linked list is also a `linear` data structure. Here is an example:

![LinkedList 1](../../assets/LinkedList_1.png)

Each element in the linked list is actually a separate object while all the objects are **linked together by the reference field** in each element.

There are two types of linked list: **singly linked list** and **doubly linked list**. The example above is a singly linked list and here is an example of doubly linked list:

![LinkedList 2](../../assets/LinkedList_2.png)

<h4>Singly Linked List</h4>

Each node in a singly-linked list contains not only the value but also **a reference field** to link to the next node. By this way, the singly-linked list organizes all the nodes in a sequence.

```java
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}
```

In most cases, we will use the `head` node (the first node) to represent the whole list.

> Unlike the array, we are not able to access a random element in a singly-linked list in constant time. If we want to get the i<sup>th</sup> element, 
> we have to traverse from the head node one by one. It takes us `O(N)` time on average to `visit an element by index`, where `N` is the length of the linked list.

**Two-pointer technique**

Let's start with a problem:

> Given a linked list, determine if it has a cycle in it.

Imagine there are two runners with different speed. If they are running on a straight path, the fast runner will first arrive at the destination. 
However, if they are running on a circular track, the fast runner will catch up with the slow runner if they keep running.

- If there is no cycle, the fast pointer will stop at the end of the linked list.
- If there is a cycle, the fast pointer will eventually meet with the slow pointer.

> What should be the proper speed for the two pointers?
  
It is a safe choice to move the slow pointer `one step` at a time while moving the fast pointer `two steps` at a time. 

```java
public class Main {

    private boolean isCyclic() {

        // Initialize slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;
        /**
         * Change this condition to fit specific problem.
         * Attention: remember to avoid null-pointer error
         **/
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;           // move slow pointer one step each time
            fast = fast.next.next;      // move fast pointer two steps each time
            if (slow == fast) {         // change this condition to fit specific problem
                return true;
            }
        }
        return false;   // change return value to fit specific problem
    }
}
```

- Always examine if the node is null before you call the next field.
- Carefully define the end conditions of your loop.

> It is easy to analyze the space complexity. If you only use pointers without any other extra space, the space complexity 
> will be O(1). However, it is more difficult to analyze the time complexity. In order to get the answer, we need to analyze 
> how many times we will run our loop .
> 
> In our previous finding cycle example, let's assume that we move the faster pointer 2 steps each time and move the slower pointer 1 step each time.
>  
> - If there is no cycle, the fast pointer takes N/2 times to reach the end of the linked list, where N is the length of the linked list.
> - If there is a cycle, the fast pointer needs M times to catch up the slower pointer, where M is the length of the cycle in the list.

<h4>Doubly Linked List</h4>

A node in a singly linked list has the value field, and a "next" reference field to link nodes sequentially.

The doubly linked list works in a similar way but has one more reference field which is known as the "prev" field. 
With this extra field, you are able to know the previous node of the current node.

```java
// Definition for doubly-linked list.
class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int x) {val = x;}
}
```

Similar to the singly linked list, we will use the head node to represent the whole list.

> We are not able to access a random position in constant time.
> We have to traverse from the head to get the `i-th` node we want.
> The time complexity in the worse case will be `O(N)`, where `N` is the length of the linked list. 

