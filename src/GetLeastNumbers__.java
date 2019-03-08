/**
 * created by Zheng Jiateng on 2019/3/7.
 */


import java.util.ArrayList;

/**
 * 最小k个数：很明显是优先队列 用堆排序的一部分 先构建最小堆（小顶堆） 在删除4次最小元素 因为堆排序的数组不用第0个位置 所以涉及数组的时候下标都要减1
 * 正确解法是构建一个大小为k的最大堆，如果后面的元素比最大堆顶元素都大，就跳过，否则替换堆顶元素并sink到合适位置
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers__ {
    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length) {
            return result;
        }
        //先构建最小堆 后一半元素不用动
        int n = input.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(input, i, n);
        }
        for (int i = 0; i < k; i++) {
            exchange(input, 1, n--);
            sink(input, 1, n);
        }
        for (int i = input.length - 1; i >= input.length - k; i--) {
            result.add(input[i]);
        }
        return result;
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

    // 下沉
    private void sink(int[] a, int k, int n) {
        while (2 * k <= n) { // 2*k是此结点的左子结点
            int j = 2 * k;
            if (j < n && a[j-1] > a[j]) { //j<n才能保证右边有结点
                j++;
            }
            if (a[k-1] <= a[j-1]) {
                break;
            }
            exchange(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        System.out.println(1 == 0);
    }
}

