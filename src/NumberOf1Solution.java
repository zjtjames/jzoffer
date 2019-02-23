/**
 * created by Zheng Jiateng on 2019/2/22.
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1Solution {
    public int numberOf1(int n) {
        int count = 0;
        while(n != 0){
            if((n&1) == 1){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
