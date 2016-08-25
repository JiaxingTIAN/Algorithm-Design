public class NumMatrix {

    private[][] sum;
    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            int s = 0;
            for(int j=0;j<matrix[0].length;j++){
                s += matrix[i][j];
                sum[i+1][j+1] = s+sum[i][j+1];
            }
        }
        
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - sum[row1][col2] - sum[row2][col1] + sum[row1][col1];
    }
}
