/**
 * created by Zheng Jiateng on 2019/3/17.
 */

import base.TreeNode;

import java.util.ArrayList;

/**
 * 把二叉树打印成多行: 与按之字形顺序打印二叉树几乎完全一样 注意4处注释即可
 * 优化： 由于不需要像之字形那样按照层数奇偶来改变入layer正反序 所以可以省一个循环 
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintEveryLayer {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> layers = new ArrayList<>();
        if (pRoot == null) {
            return layers;
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot); // 注意 层序遍历循环开始前要先把根结点加入队列 再开始循环
        while (!queue.isEmpty()) { //注意 循环条件应为队列不为空
            ArrayList<Integer> layer = new ArrayList<>();
//            for (int i = 0; i < queue.size(); i++) {
//                layer.add(queue.get(i).val);
//            }
//            layers.add(new ArrayList<>(layer));
            int cur = 0;
            int size = queue.size();
            while (cur < size) {
                TreeNode node = queue.remove(0);
                layer.add(node.val);
                if (node.left != null) { // 注意此处 要判断左子树不为空才加入队列
                    queue.add(node.left);
                }
                if (node.right != null) { // 注意此处 要判断右子树不为空才加入队列
                    queue.add(node.right);
                }
                cur++;
            }
            layers.add(new ArrayList<>(layer));
        }
        return layers;
    }
}
