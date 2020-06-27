package wh.practice.algorithm;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author wh
 */
public class Travel {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        com.example.demo.Node node = new com.example.demo.Node(1);
        node.left = new com.example.demo.Node(2);
        node.right = new com.example.demo.Node(3);
        node.left.left = new com.example.demo.Node(4);
        node.left.right = new com.example.demo.Node(5);
        node.right.left = new com.example.demo.Node(6);
        node.right.right = new com.example.demo.Node(7);
        bfs(node);
        System.out.println(list);
    }

    static void bfs(com.example.demo.Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            com.example.demo.Node node1 = queue.remove();
            list.add(node1.value);
            if (node1.left != null) {
                queue.add(node1.left);
            }
            if (node1.right != null) {
                queue.add(node1.right);
            }
        }
    }

    static void dfs(com.example.demo.Node node) {
        list.add(node.value);
        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }

    static void dfsByStack(com.example.demo.Node root) {
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            com.example.demo.Node node = stack.removeFirst();
            list.add(node.value);
            if (node.right != null) {
                stack.addFirst(node.right);
            }
            if (node.left != null) {
                stack.addFirst(node.left);
            }
        }
    }
}

class Node {
    Node(int value) {
        this.value = value;
    }
    int value;
    com.example.demo.Node left;
    com.example.demo.Node right;
}
