package wh.practice.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author wanghuan
 */
public class MinimumTotal {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        System.out.println(reverse(node, 1, 5));
    }

    public static Node reverse(Node head, int left, int right) {
        int i = 0;
        Node node = new Node(0);
        node.next=head;
        Node node3 = node;
        while( i < left-1) {
            node3 = node3.next;
            i++;
        }//循环至node.next 开始反转

        Node node1 = node3.next;
        i++;
        Deque<Node> stack = new LinkedList<>();
        while(i >= left && i <= right) {
            stack.offerLast(node1);
            node1 = node1.next;
            i++;
        }
        node1 = stack.pollLast();
        assert node1 != null;
        Node node2 = node1.next;
        node3.next = node1;
        while(!stack.isEmpty()) {
            node1.next = stack.pollLast();
            node1 = node1.next;
        }
        node1.next = node2;
        return node.next;
    }

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "," + next;
        }
    }



    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] ints = new int[triangle.get(triangle.size() - 1).size()];

        for (List<Integer> list : triangle) {
            int temp = ints[0]+list.get(0);
            int i=1;
            for (; i<list.size(); i++) {
                int t = Math.min(ints[i-1], ints[i])+list.get(i);
                ints[i-1] = temp;
                temp = t;
            }
        }
        int min = ints[0];
        for (int a : ints) {
            min = Math.min(a, min);
        }
        return min;
    }
}
