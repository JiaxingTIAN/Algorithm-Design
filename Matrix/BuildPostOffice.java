public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int dist = Integer.MAX_VALUE;
        //Add all the houses
        List<House> house = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    house.add(new House(i, j));
                }
            }
        }
        //Traverse for all the cell in the board
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) continue;
                int d = 0;
                for(int k = 0; k < house.size(); k++){
                    d += Math.abs(house.get(k).x - i) + Math.abs(house.get(k).y - j);
                }
                dist = Math.min(d, dist);
            }
        }
        
        return dist;
    }
    
    class House{
        int x, y;
        public House(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

//Time Complextiy O(nmk)
//Optimized with Binary Search and prefix sum
//Time complexity O(klogk + nmlogk)
