public class NumMatrix {
    int[][]bit;
    int[][]nums;
    int n, m;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        n = matrix.length;
        m = matrix[0].length;
        bit = new int[n+1][m+1];
        nums = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i=row+1; i<=n; i += (i&-i)){
            for(int j=col+1; j<=m; j += (j&-j)){
                bit[i][j] += diff;
            }
        }
    }
    
    public int getSum(int r, int c){
        int res = 0;
        for(int i=r+1; i>0; i -= (i&-i))
            for(int j=c+1; j>0; j -= (j&-j))
                res += bit[i][j];
        return res;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1-1) - getSum(row1-1, col2) + getSum(row1-1, col1-1);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
