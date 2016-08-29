 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 //Basic Version
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new LinkedList<>();
        if(n<=0 || m<=0 || operators==null || operators.length==0)
            return ans;
        
        int[][] map = new int[n][m];
        int[] root = new int[n*m];
        for(int i=0;i<n*m;i++)
            root[i] = i;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int count = 0;
        
        for(int i=0; i<operators.length; i++){
            count++;
            int px = operators[i].x, py = operators[i].y;
            int id = px * m + py;
            map[px][py] = 1;

            for(int j=0; j<4; j++){
                int x = px + dir[j][0];
                int y = py + dir[j][1];
                if(x>=0&&x<n&&y>=0&&y<m&&map[x][y]==1&&getRoot(root, x*m + y)!=id){
                    root[getRoot(root, x*m + y)] = id;
                    count --;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    //find boss and path compression
    public int getRoot(int[] root, int id){
        if(root[id] == id){
            return id;
        }
        root[id] = getRoot(root, root[id]);
        return root[id];
    }
}
