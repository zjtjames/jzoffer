/**
 * created by Zheng Jiateng on 2019/3/2.
 */

import java.util.Arrays;

/**
 * 二叉搜索树的后序遍历序列：
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST__ {
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        int root = sequence[sequence.length - 1];
        int sep = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] > root) {
                sep = i;
                break;
            }
            //如果没有右子树 这个很重要 一开始没考虑到
            sep = i;
        }
        int[] left = Arrays.copyOfRange(sequence,0, sep);
        int[] right = Arrays.copyOfRange(sequence, sep, sequence.length - 1);
        for (int num : left) {
            if (num > root) {
                return false;
            }
        }
        for (int num : right) {
            if (num < root) {
                return false;
            }
        }
        if (left.length > 1) { // 这是递归结束条件 很重要 一开始漏了
            verifySquenceOfBST(left);
        }
        if (right.length > 1) { // 这是递归结束条件 很重要 一开始漏了
            verifySquenceOfBST(right);
        }
        return true;
    }
}
