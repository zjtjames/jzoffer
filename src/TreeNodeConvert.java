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
public class TreeNodeConvert {
    public TreeNode convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrderTraversal(pRootOfTree, list);
        if (list.size() == 0) {
            return null;
        }
        for (int i = 1; i < list.size(); i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i - 1).right = list.get(i);
        }
        return list.get(0);
    }

    public void inOrderTraversal(TreeNode root, ArrayList<TreeNode> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root);
            inOrderTraversal(root.right, list);
        }
    }
}
