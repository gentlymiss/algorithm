package wh.practice.algorithm;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author wanghuan
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return getChildTree(nums, 0, nums.length-1);
    }

    public static TreeNode getChildTree(int[] nums, int start, int end) {
        TreeNode node;
        if (end-start+1>3) {
            node = new TreeNode(nums[(end+start)/2]);
            node.left = getChildTree(nums, start, (end+start)/2-1);
            node.right = getChildTree(nums, (end+start)/2+1, end);
        } else if (end-start+1==3) {
            node = new TreeNode(nums[(end+start)/2]);
            node.left = new TreeNode(nums[start]);
            node.right = new TreeNode(nums[end]);
        } else if (end-start+1==2) {
            node = new TreeNode(nums[end]);
            node.left = new TreeNode(nums[start]);
        } else {
            node = new TreeNode(nums[start]);
        }
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "{" +
                    "val:" + val +
                    ", left:" + left +
                    ", right:" + right +
                    '}';
        }
    }
}
