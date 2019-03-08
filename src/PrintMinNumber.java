/**
 * created by Zheng Jiateng on 2019/3/8.
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 把数组排成最小的数: 可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，
 * 应该比较的是 S1+S2 和 S2+S1 的大小，如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = "" + o1 + o2;
                String str2 = "" + o2 + o1;
                return str1.compareTo(str2);
            }
        });
        String result = "";
        for (int num : list) {
            result += num;
        }
        return result;
    }
}
