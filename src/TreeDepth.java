/**
 * created by Zheng Jiateng on 2019/3/11.
 */

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 二叉树的深度: 前序遍历 求出每一个路径 记录深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    private ArrayList<Integer> depth = new ArrayList<>();
    private ArrayList<TreeNode> path = new ArrayList<>();

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preTraversal(root);
        Collections.sort(depth);
        return depth.get(depth.size() - 1);
    }

    private void preTraversal(TreeNode root) {
        if (root != null) {
            path.add(root);
            preTraversal(root.left);
            preTraversal(root.right);
            if (root.left == null && root.right == null) {
                depth.add(path.size());
            }
            path.remove(path.size() - 1);
        }
    }
}
