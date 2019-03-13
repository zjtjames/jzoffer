/**
 * created by Zheng Jiateng on 2019/3/13.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 把字符串转换成整数 :字符转ASCII码 int的负数范围比正数范围大1
 *
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class StrToInt {
    public int StrToInt(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        int sign = 1;
        int len = chars.length;
        if (len == 0) {
            return 0;
        }
        if ((int) chars[0] == 45) {
            sign = -1;
        } else if ((int) chars[0] == 43) {
            sign = 1;
        } else if ((int) chars[0] < 48 || (int) chars[0] > 57) {
            return result;
        } else {
            result += sign * ((int) chars[0] - 48) * Math.pow(10, len - 1);
        }
        for (int i = 1; i < len; i++) {
            if ((int) chars[i] < 48 || (int) chars[i] > 57) {
                return 0;
            } else {
                result += sign * ((int) chars[i] - 48) * Math.pow(10, len - i - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println((int)'-');
//        System.out.println((char)44);
//        System.out.println(new StrToInt().StrToInt("+123456"));
        int result = 0;
        result += 5 * 2.0;
        System.out.println(result);
    }
}
