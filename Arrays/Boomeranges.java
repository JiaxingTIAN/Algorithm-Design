public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        int n = points.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    continue;
                int d = getDist(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0)+1);
            }
            for(int count:map.values()){
                res += count*(count - 1);
            }
            map.clear();
        }
        
        return res;
    }
    
    public int getDist(int[]p1, int[]p2){
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx*dx + dy*dy;
    }
}
