/**
 * created by Zheng Jiateng on 2019/2/26.
 */

import java.util.Arrays;

/**
 * 重建二叉树: 递归。前序是根左右，中序是左右根。pre[0]就是根，在in中找到pre[0],左边是左，右边是右，再根据长度在pre中切出左和右，然后递归。
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
        }
        else {
            int root = 0;
            for (int i = 0; i < in.length; i++) {
                if (in[i] == treeNode.val) {
                    root = i;
                    break;
                }
            }
            if (root > 0) { // 否则没有左子树
                int[] preLeft = Arrays.copyOfRange(pre, 1, root+1);
                int[] inLeft = Arrays.copyOfRange(in, 0, root);
                treeNode.left = reConstructBinaryTree(preLeft, inLeft);
            }
            if (root < pre.length - 1) { // 否则没有右子树
                int[] preRighit = Arrays.copyOfRange(pre, root + 1, pre.length);
                int[] inRight = Arrays.copyOfRange(in, root + 1, in.length);
                treeNode.right = reConstructBinaryTree(preRighit, inRight);
            }
            return treeNode;
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4};
        int b[] = {4, 2, 3, 1};
        System.out.println(new ReConstructBinaryTree().reConstructBinaryTree(a, b));
//        int c[] = Arrays.copyOfRange(a, 0, 1);
//        for (int i = 0; i < c.length; i++) {
//            System.out.println(c[i]);
//        }
//        int d[] = {2, 3, 4};
//        int c[] = Arrays.copyOfRange(d, 1, 2);
//        for (int num : c) {
//            System.out.println(num);
//        }
    }
}
