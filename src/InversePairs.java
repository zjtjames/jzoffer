/**
 * created by Zheng Jiateng on 2019/3/25.
 */


import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 数组中的逆序对: 排序过程实际上就是归并排序 o(nlogn)
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */

public class InversePairs {
    private int count;
    private int[] aux;

    public int InversePairs(int [] array) {
        int n = array.length;
        aux = new int[n]; // 一次性分配充足的辅助空间
        int lo = 0;
        int hi = n - 1;
        sort(array, lo, hi);
        return count;
    }

    private void sort(int[] array, int lo, int hi) { // 归并排序
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(int[] array, int lo, int mid, int hi) { // 归并 并计数
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                count += (mid + 1 - i); // 这一行是统计逆序对的数量的关键
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3,4,1,2,5};
        System.out.println(new InversePairs().InversePairs(a));
        for (int num : a) {
            System.out.println(num);
        }
    }

}



