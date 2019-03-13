/**
 * created by Zheng Jiateng on 2019/3/13.
 */

/**
 * 求1+2+3+...+n : 使用位运算&&的短路特征
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum__ {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean t = sum != 1 && (sum += Sum_Solution(n - 1)) == 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Sum__().Sum_Solution(2));
    }
}
