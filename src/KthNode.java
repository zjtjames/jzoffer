/**
 * created by Zheng Jiateng on 2019/3/18.
 */

import base.TreeNode;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k个结点：中序遍历二叉搜索树即为从小到大的顺序
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    ArrayList<TreeNode> list = new ArrayList<>();
    int kth;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        kth = k;
        inOrderTra(pRoot);
        if (list.size() < k) {
            return null;
        }
        return list.get(k - 1);
    }

    private void inOrderTra(TreeNode root) {
        if (list.size() < kth && root != null) {
            inOrderTra(root.left);
            list.add(root);
            inOrderTra(root.right);
        }
    }
}
