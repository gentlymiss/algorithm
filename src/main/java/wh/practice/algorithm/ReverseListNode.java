package wh.practice.algorithm;

/**
 * @author wanghuan
 * @date of submit 2020/03/03
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        System.out.println(l);
        System.out.println(reverseListRecursion(l));
        System.out.println(l);
    }

    /**
     * from LeetCode
     * 反转链表, 迭代方法
     * @param head 初始链表(会被破坏)
     * @return 反转后的链表
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * from LeetCode
     * 反转链表, 递归方法
     * @param head 初始链表
     * @return 反转后的链表
     */
    public static ListNode reverseListRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return l;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "{" + val +
                    ", " + next +
                    '}';
        }
    }
}
