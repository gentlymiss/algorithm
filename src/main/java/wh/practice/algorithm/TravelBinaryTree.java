package wh.practice.algorithm;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author wh
 */
public class TravelBinaryTree {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        bfs(node);
        System.out.println(list);
    }

    static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.remove();
            list.add(node1.value);
            if (node1.left != null) {
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }
        }
    }

    static void dfs(Node node) {
        list.add(node.value);
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    static void dfsByStack(Node root) {
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            list.add(node.value);
            if (node.right != null) {
                stack.addFirst(node.right);
            }
            if (node.left != null) {
                stack.addFirst(node.left);
            }
        }
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
