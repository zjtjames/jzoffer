/**
 * created by Zheng Jiateng on 2019/3/12.
 */

import java.util.ArrayList;

/**
 * 和为S的两个数字: 上一个类的O(n)解法 左端右端各一指针
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSumBetter {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                result.add(array[i]);
                result.add(array[j]);
                break;
                // 和小与sum 说明太小了 左端右移
            } else if (array[i] + array[j] < sum) {
                i++;
                //和大于sum说明太大了 右端左移
            } else {
                j--;
            }
        }
        return result;
    }
}
