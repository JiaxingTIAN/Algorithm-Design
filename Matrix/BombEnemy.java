/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill 
using one bomb.The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall
is too strong to be destroyed.
0 E 0 0
E 0 W E
0 E 0 0

*/
public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] col = new int[m]; //number of kills of current col
        int row = 0;            //number of kills of current row
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //Calculate the kills when start of row or after wall
                if(j == 0 || grid[i][j-1] == 'W'){
                    row = 0;
                    for(int r=j; r<m && grid[i][r]!='W'; r++){
                        if(grid[i][r] == 'E')
                            row++;
                    }
                }
                //Calculate the kills for col when start of col or after wall
                if(i == 0 || grid[i-1][j] == 'W'){
                    col[j] = 0;
                    for(int c=i; c<n && grid[c][j] != 'W'; c++){
                        if(grid[c][j] == 'E')
                            col[j]++;
                    }
                }
                if(grid[i][j] == '0')
                    max = Math.max(max, col[j] + row);
            }
        }
        
        return max;
    }
}
