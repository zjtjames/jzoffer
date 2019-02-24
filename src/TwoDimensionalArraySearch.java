/**
 * created by Zheng Jiateng on 2019/2/22.
 */

/**
 * 二维数组中的查找:每行二分查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 注意：第二列的元素不全都比第一列元素大 所以整个拉成一个一维数组不是有序的
 */
public class TwoDimensionalArraySearch {
    public static boolean find(int target, int [][] array) {
        // 行数m 列数n
        int m = array.length;
        int n = array[0].length;
        for (int i = 0; i < m; i++) {
            int lo = 0;
            int hi = n - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (target == array[i][mid]) {
                    return true;
                } else if (target > array[i][mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(7, a));
    }
}
