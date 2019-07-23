/**
 * created by Zheng Jiateng on 2019/3/28.
 */
package sort;


/**
 * 快速排序： O(nlogn) 分治 原地排序 不需要辅助空间
 * 快速排序,说白了就是给基准数据找其正确索引位置的过程
 *
 */
public class Quick {

    private static void quickSort(int[] nums, int lo, int hi) {

        if (lo < hi) {
            // 找寻基准数据的正确索引
            int index = findIndex(nums, lo, hi);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(nums, lo, index - 1);
            quickSort(nums, index + 1, hi);
        }
    }

    private static int findIndex(int[] nums, int lo, int hi) {
        // 基准数据
        int tmp = nums[lo];
        while (lo < hi) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (lo < hi && nums[hi] >= tmp) hi--;
            // 如果队尾元素小于tmp了,需要将其赋值给low
            nums[lo] = nums[hi];
            // 当队首元素小于等于tmp时,向后挪动low指针
            while (lo < hi && nums[lo] <= tmp) lo++;
            // 当队首元素大于tmp时,需要将其赋值给high
            nums[hi] = nums[lo];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        nums[lo] = tmp;
        return lo; // 返回tmp的正确位置
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 1, 2, 3, 4};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
