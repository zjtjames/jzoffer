/**
 * created by Zheng Jiateng on 2019/3/26.
 */
package sort;

/**
 * 选择排序：O(n方) 初级排序算法
 * 不断 选择 剩余元素中最小者与当前游标交换位置
 *
 */
public class Selection {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3, 7};
        sort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
