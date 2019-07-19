/**
 * created by Zheng Jiateng on 2019/3/28.
 */
package sort;


/**
 * 快速排序： O(nlogn) 分治 原地排序 不需要辅助空间
 * 当两个子数组都有序时数组也就自然有序了，递归发生在处理整个数组（partition）之后
 *
 */
public class Quick {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // 每次partition会排定一个元素，所以至少数组要有两个元素才能partition 所以sort中递归终止条件为lo >= hi
    // 一般先选择a[lo]作为切分元素，即那个将会被排定的元素
    private static int partition(int[] a, int lo, int hi) {
        int i = lo; // 扫描左指针
        int j = hi + 1; // 扫描右指针
        int v = a[lo];
        while (true) {
            while (a[++i] < v) { // 直到左边一个比v大的
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) { // 直到右边一个比v小的
                if (j == lo) {
                    break;
                }
            }
            if (j <= i) {
                break;
            }
            int tmp = a[i]; // 交换左边大右边小的两个元素 使得循环结束时，排定的元素左边都比该元素小，右边都比该元素大
            a[i] = a[j];
            a[j] = tmp;
        }
        int tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        return j; // a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 8, 1, 2, 3, 4};
        sort(a);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
