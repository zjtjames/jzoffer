/**
 * created by Zheng Jiateng on 2019/3/11.
 */

import base.TreeNode;

/**
 * 平衡二叉树 : 概念：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean left = IsBalanced_Solution(root.left);
            boolean right = IsBalanced_Solution(root.right);
            int leftDepth = treeDepth(root.left);
            int rightDepth = treeDepth(root.right);
            if (left && right && Math.abs(leftDepth - rightDepth) <= 1) {
                return true;
            }
        }
        return false;
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
