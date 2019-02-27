/**
 * created by Zheng Jiateng on 2019/2/27.
 */

import java.util.ArrayList;

/**
 * 	调整数组顺序使奇数位于偶数前面 : 利用辅助空间，空间换时间
 * 	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 	所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                arrayList2.add(num);
            } else {
                arrayList1.add(num);
            }
        }
        arrayList1.addAll(arrayList2);
        for (int i = 0; i < arrayList1.size(); i++) {
            array[i] = arrayList1.get(i);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        new ReOrderArray().reOrderArray(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
