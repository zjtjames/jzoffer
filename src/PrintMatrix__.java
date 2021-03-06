/**
 * created by Zheng Jiateng on 2019/2/28.
 */

import java.util.ArrayList;

/**
 * 顺时针打印矩阵：把矩阵想象成若干个圈，每次打印一个圈，每个圈的左上角行标列标相同，为(start, start)
 *
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix__ {
    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        // 让循环继续的条件是start * 2 < rows 并且 start * 2 < columns
        while (start * 2 < rows && start * 2 < columns) {
            printMatrixInCircle(matrix, rows, columns, start++);
        }
        return result;
    }

    private void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {
        // 仔细分析打印时每一步的前提条件
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        // 第一步 从左到右打印一行 第一步总是无条件需要的
        for (int i = start; i <= endX ; i++) {
            result.add(matrix[start][i]);
        }

        // 第二步 从上到下打印一列 第二步的前提条件是终止行号大于起始行号
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }

        // 第三步 从右到左打印一行 第三步的前提条件是圈内至少有两行两列
        if (endY > start && endX > start) {
            for (int i = endX -1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }

        // 第四步 从下到上打印一列 第四步的前提条件是圈内至少有三行两列
        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
}
