package wh.practice.algorithm;

/**
 * @author wanghuan
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.right = new TreeNode(1);
        System.out.println(hasPathSum(node, 18));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return root != null && hasSum(root, sum, 0);
    }

    public static boolean hasSum(TreeNode root, int sum, int currSum) {
        if (root.left == null && root.right== null) {
            return currSum+root.val == sum;
        }
        if (root.left == null) {
            return hasSum(root.right, sum, currSum+root.val);
        }
        if (root.right == null) {
            return hasSum(root.left, sum, currSum+root.val);
        }
        return hasSum(root.right, sum, currSum+root.val) || hasSum(root.left, sum, currSum+root.val);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
