public class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0){
            return false;
        }
        return dfs(stones, 0, 1);
    }
    
    public boolean dfs(int[] stones, int idx, int step){
        if(idx == stones.length-1){
            return true;
        }
        int i = idx + 1;
        boolean flag = false;
        for(i=idx+1; i<stones.length; i++){
            if(stones[i] == stones[idx] + step)
                if(dfs(stones, i, step-1) || dfs(stones, i, step) || dfs(stones, i, step+1))
                    return true;
        }
        return false;
    }
}


public class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0){
            return false;
        }
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();   //Store the stone location and step pair
        for(int stone:stones){
            map.put(stone, new HashSet<>());    //Initialize stone location
        }
        map.get(0).add(1);  //first step start at 0 with 1
        for(int i=0; i<n-1; i++){   //No need to calculate for last stone
            for(int step:map.get(stones[i])){   //try each step from stone
                int reach = stones[i] + step;
                if(reach == stones[n-1])    //See if reach final location
                    return true;
                if(map.get(reach) == null)  //If not a stone continue
                    continue;
                for(int s = step+1; s>0 && s>=step-1; s--){
                    map.get(reach).add(s);  //Add steps for reachable stone
                }
            }
        }
        return false;
    }
    
}
