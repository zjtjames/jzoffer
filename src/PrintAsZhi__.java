/**
 * created by Zheng Jiateng on 2019/3/17.
 */

import base.TreeNode;

import java.util.*;

/**
 * 按之字形顺序打印二叉树: 跟层序遍历思路差不多 也是用队列 cur这个游标是精髓
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintAsZhi__ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> layers = new ArrayList<>();
        if (pRoot == null) {
            return layers;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        int depth = 0;
        while (!queue.isEmpty()) { // 每次循环是一层
            depth++;
            ArrayList<Integer> layer = new ArrayList<>();
            if (depth % 2 == 0) { // 如果是偶数层 倒序入layer
                for (int i = queue.size()-1; i >=0 ; i--) {
                    layer.add(queue.get(i).val);
                }
            } else { // 如果是奇数层 正序入layer
                for (int i = 0; i < queue.size(); i++) {
                    layer.add(queue.get(i).val);
                }
            }
            layers.add(new ArrayList<>(layer));
            int cur = 0;
            int size = queue.size();
            while (cur < size) { // 这个游标是精髓 它保证了每次把这一层的元素全部出队 把下一层的元素全部入队
                TreeNode node = queue.remove(0);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cur++;
            }
        }
        return layers;
    }
}
