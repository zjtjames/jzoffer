/**
 * created by Zheng Jiateng on 2019/3/1.
 */

import java.util.ArrayList;

import base.*;

/**
 * 从上往下打印二叉树 ：层序遍历 用队列实现
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom__ {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove(0);
            result.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return result;
    }
}
