package wh.practice.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wanghuan
 */
public class TravelBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println(dfs(node));
    }

    static List<Integer> dfs(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(node);
        while (!stack.isEmpty()) {
            Node node1 = stack.removeFirst();
            list.add(node1.value);
            if (node1.right != null) {
                stack.addFirst(node1.right);
            }
            if (node1.left != null) {
                stack.addFirst(node1.left);
            }
        }
        return list;
    }

    static class Node {
        Node(int value) {
            this.value = value;
        }
        int value;
        Node left;
        Node right;
    }
}

