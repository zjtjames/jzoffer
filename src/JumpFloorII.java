/**
 * Created by Zheng Jiateng on 2019/2/23.
 */

/**
 * 变态跳台阶：递归
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else {
            int sum = 0;
            for (int i = 1; i < target; i++) {
                sum += JumpFloorII(i);
            }
            // +1是因为可以直接跳到最后一级
            return sum + 1;
        }
    }
}
