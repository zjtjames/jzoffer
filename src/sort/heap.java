/**
 * created by Zheng Jiateng on 2019/7/23.
 */
package sort;


/**
 * 堆排序
 *
 * 对于完全二叉树，从0开始编号，假设一个父节点编号为k，则左子节点为2k+1，右子节点为2k+2
 * k的父结点是(k - 1) / 2
 */
public class heap {
    public static void heapSort(int[] nums) {
        // 最后一个元素索引
        int last = nums.length - 1;
        //从中间开始到左 用sink()构建堆
        for (int i = (last - 1) / 2; i >= 0; i--) {
            sink(nums, i, last);
        }
        // 堆排序 把堆顶元素与last元素交换 last减1 sink()
        while (last > 0) {
            exchange(nums, 0, last--);
            sink(nums, 0, last);
        }
    }

    private static void sink(int[] nums, int k, int last) {
        while (2 * k + 1 <= last) {
            int j = 2 * k + 1;
            if(j < last && nums[j] < nums[j+1]) j++; // j < length - 1这个条件不要漏
            if(nums[k] >= nums[j]) break;
            exchange(nums, k, j);
            k = j; // 这一行不要忘了 交换完要继续到下一层判断是否sink() 直到最后一层
        }
    }

    private static void exchange(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 6, 7, 8, 1, 0};
        heapSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
