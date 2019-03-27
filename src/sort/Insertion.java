/**
 * created by Zheng Jiateng on 2019/3/26.
 */
package sort;

/**
 * 插入排序 ：O(n方) 初级排序算法
 * 将a[i]与a[0]到a[i-1]中比它大的所有元素依次有序地交换。
 *
 * 插入排序对部分有序的数组十分高效，也很适合小规模数组
 * 插入排序需要交换的次数与数组中的逆序对数量相等
 */
public class Insertion {
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 5, 4, 7, 8};
        sort(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
