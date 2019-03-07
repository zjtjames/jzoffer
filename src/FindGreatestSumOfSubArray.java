/**
 * created by Zheng Jiateng on 2019/3/7.
 */

/**
 * 连续自数列的最大和 : 最大子列和问题 o(n)复杂度 在线处理：在任何一个地方终止输入，算法都能正确给出当前的解
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)。
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int thisSum = 0;
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            thisSum += array[i];
            if (i == 0) {
                maxSum = thisSum;
            }
            if (thisSum > maxSum) { // 发现更大和则更新当前结果
                maxSum = thisSum;
            }
            if (thisSum < 0) { //如果当前子列和为负，则不可能使后面的部分和增大，抛弃之，将子列和置为0
                thisSum = 0;
            }
        }
        return maxSum;
    }
}

