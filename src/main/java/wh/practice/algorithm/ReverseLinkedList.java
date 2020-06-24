package wh.practice.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wanghuan
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node node = Node.builder(a);
        System.out.println(node);
        System.out.println(reverse(node));
    }

    static Node reverse(Node head){
        Deque<Node> stack = new LinkedList<>();
        while (head != null) {
            stack.addFirst(head);
            head = head.next;
        }
        head = stack.peekFirst();
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            node.next = stack.peekFirst();
        }
        return head;
    }

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public static Node builder(int[] values) {
            Node head = new Node(values[0]);
            Node node = head;
            for (int i=1; i<values.length; i++) {
                node.next = new Node(values[i]);
                node = node.next;
            }
            return head;
        }

        @Override
        public String toString() {
            return value + "," + next;
        }
    }
}

