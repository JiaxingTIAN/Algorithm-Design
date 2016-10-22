public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        //Time O(MN)
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] hp = new int[n+1][m+1];
        //Padding with MAX_VALUE
        for(int i=0; i<n; i++)
            hp[i][m] = Integer.MAX_VALUE;
        for(int j=0; j<m; j++)
            hp[n][j] = Integer.MAX_VALUE;
        hp[n][m-1] = 1;
        hp[n-1][m] = 1; //At least 1 hitpoint to stay alive at last cell
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int hitpoint = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
                hp[i][j] = hitpoint <= 0? 1:hitpoint;
            }
        }
        return hp[0][0];
    }
}
