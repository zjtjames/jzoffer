/**
 * created by Zheng Jiateng on 2019/3/2.
 */

import java.util.ArrayList;
import base.*;

/**
 * 二叉树中和为某一值的路径 :注意审题，一定要到一个叶结点才能形成一条路径，叶结点是度为0的结点
 * 输入一颗二叉树的根结点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * （注意: 在返回值的list中，数组长度大的数组靠前）
 */
public class FindPath {

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        findAllPath(root, target, path, result);
        return result;
    }

    public void findAllPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root != null) {
            path.add(root.val);
            findAllPath(root.left, target, path, result);
            findAllPath(root.right, target, path, result);
            // 这一步是精髓 只有到了叶结点才sum
            boolean ifLeaf = root.left == null && root.right == null;
            if (ifLeaf && sumList(path) == target) {
                result.add(path);
            }
            path.remove(path.size() - 1);
        }
    }

    public int sumList(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode12 = new TreeNode(12);
        treeNode10.left = treeNode5;
        treeNode10.right = treeNode12;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode7;
        System.out.println(new FindPath().findPath(treeNode10, 22));
    }
}