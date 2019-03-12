/**
 * created by Zheng Jiateng on 2019/3/12.
 */

import java.util.ArrayList;

/**
 * 和为S的两个数字: a+b=sum,a和b越远乘积越小 所以
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        } else {
            for (int num : array) {
                if (bs(array, sum - num)) {
                    result.add(num);
                    result.add(sum - num);
                    break;
                }
            }
            return result;
        }
    }

    private boolean bs(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == array[mid]) {
                return true;
            } else if (target > array[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(new FindNumbersWithSum().bs(array,11));
    }
}
