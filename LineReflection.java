public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0)
            return true;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[]p:points){
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        int line = min + max;
        for(int[]p:points){
            if(!map.containsKey(line - p[0]) || !map.get(line - p[0]).contains(p[1]))
                return false;
        }
        return true;
    }
}
