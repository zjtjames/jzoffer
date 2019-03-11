/**
 * created by Zheng Jiateng on 2019/3/11.
 */

/**
 * 数字在排序数组中出现的次数: 二分查找后统计
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int index = bs(array, k);
        if (index == -1) {
            return 0;
        }
        int count = 0;
        int iter = index;
        while (iter >= 0 && array[iter] == k) {
            count++;
            iter--;
        }
        iter = index + 1;
        while (iter < array.length && array[iter] == k) {
            count++;
            iter++;
        }
        return count;
    }

    //二分查找
    private int bs(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4, 6, 8, 8, 10};
        System.out.println(new GetNumberOfK().getNumberOfK(array, 1));
    }
}
