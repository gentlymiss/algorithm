package wh.practice.algorithm;

/**
 * @author wanghuan
 * @date of submit 2020/03/02
 */
public class Add2Numbers {
    public static void main(String[] args) {
        ListNode l = new ListNode(9);
        l.next = new ListNode(9);
        l.next.next = new ListNode(9);
        System.out.println(l);
        System.out.println(addTwoNumbers(new ListNode(1), l));
    }

    /**
     * 两串相加 递归解法
     * @param l1 未处理串1
     * @param l2 未处理串2
     * @param carry 上一位的进位, 从0开始
     * @return l1, l2的和串
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode sum = new ListNode((l1.val + l2.val + carry)%10);
        if (l1.next != null && l2.next != null) {
            sum.next = addTwoNumbers(l1.next, l2.next, (l1.val+l2.val+carry) / 10);
        } else if (l1.next == null && l2.next != null) {
            sum.next = addTwoNumbers(new ListNode(0), l2.next, (l1.val+l2.val+carry) / 10);
        } else if (l1.next != null) {
            sum.next = addTwoNumbers(l1.next, new ListNode(0), (l1.val+l2.val+carry) / 10);
        } else if ((l1.val+l2.val+carry) / 10 > 0){
            sum.next = new ListNode((l1.val+l2.val+carry) / 10);
        } else {
            sum.next = null;
        }
        return sum;
    }

    /**
     * from LeetCode
     * 两串求和, 非递归解法
     * @param l1 加数串1
     * @param l2 加数串2
     * @return 和串
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
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


