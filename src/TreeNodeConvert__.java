/**
 * created by Zheng Jiateng on 2019/3/5.
 */

import base.TreeNode;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表：中序遍历二叉搜索树恰好可以按照从小到大的顺序遍历二叉树的每一个结点
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class TreeNodeConvert__ {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        inOrderTraversal(pRootOfTree);
        return head;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            node.left = pre;
            if (pre != null) {
                pre.right = node;
            }
            pre = node;
            if (node.left == null) {
                head = node;
            }
            inOrderTraversal(node.right);
        }
    }
}
