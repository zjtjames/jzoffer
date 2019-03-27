/**
 * created by Zheng Jiateng on 2019/3/26.
 */
package sort;

/**
 * 归并排序： O(nlogn) 需要O(n)的辅助空间 递归 将两个有序的数组归并成一个更大的数组
 * 高效算法设计中分治思想的最典型的一个例子
 * 一定要每次归并都拷贝新的a进辅助数组
 */
public class Merge {
    private static int[] aux; // 归并需要的辅助数组

    public static void sort(int[] a) {
        int n = a.length;
        aux = new int[n]; // 一次性分配空间
        sort(a, 0, n - 1);
    }

    private static void sort(int[] a, int lo, int hi) { // 重载
        // 与二分查找很像
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid); // 将左半边排序
        sort(a, mid + 1, hi); // 将右半边排序
        merge(a, lo, mid, hi); // 归并
    }

    private static void merge(int[] a, int lo, int mid, int hi) { // 进行merge的数组 前一半和后一半分别是有序的
        // 将a[lo..mid]和a[mid+1..hi]归并
        int i = lo; // i的范围：lo~mid
        int j = mid + 1; // j的范围：mid+1~hi
        // 一定要每次归并都拷贝新的a进辅助数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
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
