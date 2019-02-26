/**
 * created by Zheng Jiateng on 2019/2/26.
 */

import java.util.Arrays;

/**
 * 重建二叉树:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return treeNode;
        } else {
            int root = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == treeNode.val) {
                    root = i;
                }
            }
//            int[] preLeft = {};
//            System.arraycopy(pre, 1, preLeft, 0, root);
//            int[] preRighit = {};
//            System.arraycopy(pre, root + 1, preRighit, 0, pre.length - root - 1);
//            int[] inLeft = {};
//            System.arraycopy(in, 0, inLeft, 0, root);
//            int[] inRight = {};
//            System.arraycopy(in, root + 1, inRight, 0, in.length - root - 1);
            int[] preLeft = Arrays.copyOfRange(pre, 1, root);
            int[] preRighit = Arrays.copyOfRange(pre, root + 1, pre.length);
            int[] inLeft = Arrays.copyOfRange(in, 0, root - 1);
            int[] inRight = Arrays.copyOfRange(in, root + 1, in.length);
            treeNode.left = reConstructBinaryTree(preLeft, inLeft);
            treeNode.right = reConstructBinaryTree(preRighit, inRight);
            return treeNode;
        }
    }
}
