/**
 * created by Zheng Jiateng on 2019/2/27.
 */

/**
 * 数值的整数次方: 代码完整性 注意考虑指数为负数的情况
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }else if (exponent == 1) {
            return base;
        } else if (exponent >= 2) {
            return base * Power(base, exponent - 1);
        } else {
            return 1 / Power(base, 0 - exponent);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Power().Power(2,-2));
    }
}
