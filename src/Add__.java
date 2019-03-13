/**
 * created by Zheng Jiateng on 2019/3/13.
 */

/**
 * 不用加减乘除做加法: 101 + 111 作为例子  二进制数不进位相加 等价于逐位异或
 * step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
 * step2:按位异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果
 * step3:n1&n2是查看有没有进位位了，如果有，需要重复step1、step2；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add__ {
    public int Add(int num1,int num2) {
        int n1 = (num1 & num2) << 1;
        int n2 = num1 ^ num2;
        if ((n1 & n2) != 0) {
            return Add(n1, n2);
        } else {
            return n1 ^ n2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Add__().Add(2,4));
    }
}
