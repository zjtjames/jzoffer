/**
 * created by Zheng Jiateng on 2019/3/12.
 */

/**
 * 左旋转字符串:
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public String leftRotateString(String str, int n) {
        char[] chars1 = str.toCharArray();
        if (chars1.length == 0) {
            return str;
        }
        char[] chars2 = new char[chars1.length];
        for (int i = n; i < chars1.length; i++) {
            chars2[i - n] = chars1[i];
        }
        for (int i = 0; i < n; i++) {
            chars2[i + chars1.length - n] = chars1[i];
        }
        return String.copyValueOf(chars2);
    }

    public static void main(String[] args) {
        System.out.println(new LeftRotateString().leftRotateString("",6));
    }
}
