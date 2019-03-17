/**
 * created by Zheng Jiateng on 2019/3/16.
 */

import base.TreeNode;


/**
 * 对称的二叉树: 递归算法：左右结点值相等，且对称子树left.left， right.right; left.right,right.left也对称
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical__ {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return core(pRoot.left, pRoot.right);
    }

    private boolean core(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return core(left.left, right.right) && core(left.right, right.left);
    }
}
