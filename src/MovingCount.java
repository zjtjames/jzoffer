/**
 * created by Zheng Jiateng on 2019/4/3.
 */

/**
 * 机器人的运动范围: 回溯法 递归
 * 也要要用一个布尔型的矩阵来标识是否已经进入了每个格子
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    boolean[][] visited;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col) {
        int count = 0;
        if (check(threshold, rows, cols, row, col)) {
            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col)
                    + movingCountCore(threshold, rows, cols, row, col - 1)
                    + movingCountCore(threshold, rows, cols, row + 1, col)
                    + movingCountCore(threshold, rows, cols, row, col + 1);
        }
        return count;
    }

    // check函数用来判断机器人能否进入坐标（row,col）的方格
    private boolean check(int threshold, int rows, int cols, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && countDigitSum(row) + countDigitSum(col) <= threshold &&
                !visited[row][col]) {
            return true;
        }
        return false;
    }

    // 计算个位数组 用%10即可
    private int countDigitSum(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
