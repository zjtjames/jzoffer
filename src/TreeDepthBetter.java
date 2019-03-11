/**
 * created by Zheng Jiateng on 2019/3/11.
 */

import base.TreeNode;

/**
 * 二叉树深度：上一个类是自己的方法 太笨了 下面这个递归方法更好
 */
public class TreeDepthBetter {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left); // 左子树深度
        int right = TreeDepth(root.right); // 右子树深度
        return Math.max(left, right) + 1; // 树的深度等于左、右子树更大的深度+1
    }
}
