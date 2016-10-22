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
