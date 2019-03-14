/**
 * created by Zheng Jiateng on 2019/3/13.
 */

import java.util.ArrayList;

/**
 * 构建乘积数组 : 使用两个辅助数组 保存B[i]之前和之后的乘积 before[i+1]可根据before[i]*A[i]算出来
 * after[i]after[i+1]*A[i+1]算出来
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply__ {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] before = new int[len];
        int[] after = new int[len];
        int[] res = new int[len];
        before[0] = 1;
        after[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            before[i] = before[i - 1] * A[i - 1];
            after[len - 1 - i] = after[len - i] * A[len - i];
        }
        for (int i = 0; i < len; i++) {
            res[i] = before[i] * after[i];
        }
        return res;
    }
}
