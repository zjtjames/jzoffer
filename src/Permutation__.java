/**
 * created by Zheng Jiateng on 2019/3/5.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 字符串的排列 : 交换 回溯法 不是很理解 多看几遍背过吧
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation__ {
    private ArrayList<String> result = new ArrayList<>();


    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        permutation_1(chars, 0);
        Collections.sort(result);
        return result;
    }

    public void permutation_1(char[] chars, int i) {
        if (i == chars.length - 1) { //边界条件要记住
            if (!result.contains(new String(chars))) {
                result.add(new String(chars));
            }
            return;
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                permutation_1(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }



    public static void main(String[] args) {
    }
}
