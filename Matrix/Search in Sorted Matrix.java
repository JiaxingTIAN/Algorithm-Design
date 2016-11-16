public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) 
            return false;
        
        int col = matrix[0].length-1;
        int row = 0;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) 
                return true;
            else if(matrix[row][col] > target) 
                col--;
            else if(matrix[row][col] < target) 
                row++;
        }
        return false;
    }
}
