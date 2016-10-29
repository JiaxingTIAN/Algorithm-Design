public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][]sum = new int[n+1][m+1];
        //Prefix sum
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int c=0; c<m; c++){
                    int cur = sum[j+1][c+1] - sum[i][c+1];
                    Integer ceil = set.ceiling(cur - k);
                    if(ceil != null)
                        max = Math.max(cur - ceil, max);
                    set.add(cur);
                }
            }
        }
        return max;
    }
}
