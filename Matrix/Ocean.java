public class Solution {
    private void dfs(int[][] matrix, boolean[][] map, int height, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if (map[row][col] || height > matrix[row][col]) {
            return;
        }
        map[row][col] = true;
        int[] shift = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            dfs(matrix, map, matrix[row][col], row + shift[i], col + shift[i + 1]);
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<int[]>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        boolean[][] pacific = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
        }
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }
}
