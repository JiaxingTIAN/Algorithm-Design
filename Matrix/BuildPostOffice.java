/*
Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), find the place to build a post office, 
the distance that post office to all the house sum is smallest. Return the smallest distance. Return -1 if it is not possible.
0 1 0 0
1 0 1 1
0 1 0 0
you can walk through house and empty, you can only build at empty.
*/
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
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
    // Write your code here
        int n = grid.length;
        if (n == 0)
            return -1;

        int m = grid[0].length;
        if (m == 0)
            return -1;

        List<Integer> sumx = new ArrayList<Integer>();
        List<Integer> sumy = new ArrayList<Integer>();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
        
        Collections.sort(x);
        Collections.sort(y);

        int total = x.size();

        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= total; ++i) {
            sumx.add(sumx.get(i-1) + x.get(i-1));
            sumy.add(sumy.get(i-1) + y.get(i-1));
        }

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 0) {
                    int cost_x = get_cost(x, sumx, i, total);
                    int cost_y = get_cost(y, sumy, j, total);
                    if (cost_x + cost_y < result)
                        result = cost_x + cost_y;
                }

        return result;
    }

    public int get_cost(List<Integer> x, List<Integer> sum, int pos, int n) {
        if (n == 0)
            return 0;
        if (x.get(0) > pos)
            return sum.get(n) - pos * n;

        int l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (x.get(mid) <= pos)
                l = mid;
            else
                r = mid - 1;
        }
        
        int index = 0;
        if (x.get(r) <= pos)
            index = r;
        else
            index = l;
        return sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) + 
               (index + 1) * pos - sum.get(index + 1);
    }
}
