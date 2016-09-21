public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        //Corner cases
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[][]{{-1, -1},{-1, -1}};
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        //pre-compute the sum of matrix (0,0) -> (i, j)
        int [][]sum = new int[n+1][m+1]; //padding with zero to avoid board cases
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                //left matrix + upper matrix - common part
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        for(int x=0; x<n; x++){ 
            //start from zero x=0 y is the orgin sum without deduction
            for(int y=x+1; y<=n; y++){
                Map<Integer, Integer> map = new HashMap<>();
                for(int k=0; k<=m; k++){
                    int diff = sum[y][k] - sum[x][k];
                    if(map.containsKey(diff)){
                        // top left = x - 1 + 1; bottom left = y - 1
                        // top right = get - 1 + 1;
                        return new int[][]{{x, map.get(diff)},{y-1, k-1}};
                    }else{
                        map.put(diff, k);
                    }
                }
            }
        }
        
        return new int[][]{{-1,-1},{-1,-1}};
    }
}
