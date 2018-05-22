
import java.util.HashSet;

public class Main {

    static class Node
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
        }
    }

    private static void printList(Node node) {
        System.out.print(node.val);
        Node current = node.next;
        while(current != null) {
            System.out.print("->");
            System.out.print(current.val);
            current = current.next;
        }
    }

    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removeDuplicate(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }

    private static void removeDuplicate(Node start) {
        HashSet<Integer> history = new HashSet<>();
        Node current = start;
        Node prev = current;

        while (current != null) {
            if (history.contains(current.val)) {
                prev.next = current.next;
                current = current.next;
            } else {
                history.add(current.val);
                prev = current;
            }
        }
    }
}
