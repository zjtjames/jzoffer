/**
 * created by Zheng Jiateng on 2019/4/3.
 */

/**
 * 矩阵中的路径: 回溯法 递归
 * 要用一个布尔型的矩阵来标识是否已经进入了每个格子
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class HasPath__ {
    int length;
    boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null || rows < 1 || cols < 1) {
            return false;
        }
        // 由于路径不能重复进入矩阵的格子 用一个布尔型的矩阵来标识是否已经进入了每个格子
        visited = new boolean[rows][cols];
        length = str.length;
        // 标识这是路径的第几个字符
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < cols; column++) {
                if (hasPathCore(matrix, rows, cols, row, column, str, pathLength)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int column, char[] str, int pathLength) {
        if (pathLength == length) { // 注意递归停止条件 不是length-1 而是length
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && column >= 0 && column < cols && matrix[row * cols + column] == str[pathLength] && !visited[row][column]) {
            pathLength++;
            visited[row][column] = true;
            // 三个或 四条路只要有一条走通  hasPath就等于true
            hasPath = hasPathCore(matrix, rows, cols, row, column - 1, str, pathLength) || // 左
                    hasPathCore(matrix, rows, cols, row - 1, column, str, pathLength) || // 上
                    hasPathCore(matrix, rows, cols, row, column + 1, str, pathLength) || // 右
                    hasPathCore(matrix, rows, cols, row + 1, column, str, pathLength); // 下
            // 如果4个相邻的格子都没有匹配字符串中下标为pathLength+1的字符，说明当前字符不对，回溯到前一个字符(pathLength-1)
            if (!hasPath) {
                pathLength--;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }
}
