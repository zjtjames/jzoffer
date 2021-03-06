/**
 * created by Zheng Jiateng on 2019/3/14.
 */

/**
 * 表示数值的字符串: 直接用正则
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric__ {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[+\\-]?\\d*(\\.\\d+)?([eE][+\\-]?\\d+)?");
    }

    public static void main(String[] args) {
        String string = "";
        char[] chars = string.toCharArray();
        System.out.println(new IsNumeric__().isNumeric(chars));
    }
}
