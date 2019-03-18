/**
 * created by Zheng Jiateng on 2019/3/17.
 */

import base.TreeNode;


/**
 * 序列化二叉树:  因为先序遍历是从根结点开始的 所以用先序遍历 1,2,4,#,#,#,3,#,6,#,#
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree__ {
    int cur = 0;

    String Serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        preOrderTraversal(root, str);
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.equals("")) {
            return null;
        }
        String[] strings = str.split(",");
        return reConstruct(strings);
    }

    private void preOrderTraversal(TreeNode root, StringBuffer str) {
        if (root == null) {
            str.append("#,");
        } else {
            str.append(root.val).append(",");
            preOrderTraversal(root.left, str);
            preOrderTraversal(root.right, str);
        }
    }

    private TreeNode reConstruct(String[] strings) {
        if (cur < strings.length && !strings[cur].equals("#")) {
            TreeNode treeNode = new TreeNode(Integer.parseInt(strings[cur++]));
            treeNode.left = reConstruct(strings);
            treeNode.right = reConstruct(strings);
            return treeNode;
        } else {
            cur++;
            return null;
        }
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        System.out.println(str.toString().equals(""));
//        str.append("1,2,4,#,#,#,3,#,6,#,#");
//        String[] strings = str.toString().split(",");
//        System.out.println(strings);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node6;
        System.out.println(new SerializeTree__().Serialize(node1));
    }


}
