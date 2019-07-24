/**
 * created by Zheng Jiateng on 2019/3/26.
 */
package sort;

/**
 * 归并排序： O(nlogn) 分治 需要O(n)的辅助空间 递归 将两个有序的数组归并成一个更大的数组
 * 将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序，递归发生在处理整个数组之前
 * 一定要每次归并都拷贝新的a进辅助数组
 */
public class Merge {
    private static int[] aux; // 归并需要的辅助数组

    public static void sort(int[] nums) {
        int n = nums.length;
        aux = new int[n]; // 一次性分配空间
        sort(nums, 0, n - 1);
    }

    private static void sort(int[] nums, int lo, int hi) { // 重载
        // 与二分查找很像
        if (lo < hi) {
            int mid = (lo + hi) / 2;
            sort(nums, lo, mid); // 将左半边排序
            sort(nums, mid + 1, hi); // 将右半边排序
            merge(nums, lo, mid, hi); // 归并
        }
    }

    private static void merge(int[] nums, int lo, int mid, int hi) { // 进行merge的数组 前一半和后一半分别是有序的
        // 将a[lo..mid]和a[mid+1..hi]归并
        int i = lo; // i的范围：lo~mid
        int j = mid + 1; // j的范围：mid+1~hi
        int k = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] < nums[j]) aux[k++] = nums[i++];
            else aux[k++] = nums[j++];
        }
        while (i <= mid) aux[k++] = nums[i++];
        while (j <= hi) aux[k++] = nums[j++];
        for (int l = 0; l < k; l++) {
            nums[lo + l] = aux[l];
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 8, 9, 10, 5, 4, 3, 1, 2, 6};
        sort(a);
        for (int num : a) {
            System.out.print(num);
        }
    }
}
