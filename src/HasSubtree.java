/**
 * created by Zheng Jiateng on 2019/2/28.
 */

import java.util.ArrayList;
import java.util.List;
import base.*;

/**
 * 树的子结构：注意前序遍历的写法
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        preTraversal(root1, list1);
        preTraversal(root2, list2);
        if (list1.size() < list2.size()) {
            return false;
        }
        for (int i = 0; i <= list1.size() - list2.size(); i++) {
            if (list2.equals(list1.subList(i, i + list2.size()))) {
                return true;
            }
        }
        return false;
    }

    public void preTraversal(TreeNode root, ArrayList<Integer> list) {
//        if (root != null) {
//            list.add(root.val);
//        }
//        if (root.left != null) {
//            preTraversal(root.left, list);
//        }
//        if (root.right != null) {
//            preTraversal(root.right, list);
//        }
        //前序遍历要这么写 不能像上面那么写
        if (root != null) {
            list.add(root.val);
            preTraversal(root.left, list);
            preTraversal(root.right,list);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        List<Integer> list1 = list.subList(1, 4);
        for (int num : list1) {
            System.out.println(num);
        }
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(0);
//        list2.add(1);
//        list2.add(2);
//        System.out.println(list2.equals(list1));

    }
}
