public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        //Sort the array first for optimization and skip duplicate values
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    //DFS with backtrack O(2^n) for each item either use once or not used
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] cands, int target, int sum, int idx){
        if(sum == target){  //Base case add to list when equal
            res.add(new ArrayList(list));
            return;
        }
        //Terminae when sum is larget than target
        if(sum > target){
            return;
        }
        //Skip value when sum + cands[i] is larger than target
        for(int i = idx; i < cands.length && sum + cands[i] <= target; i++){
            list.add(cands[i]);
            dfs(res, list, cands, target, sum+cands[i], i+1);   //Each value use once, next iteration start with i+1
            while(i+1 < cands.length && cands[i+1] == cands[i]) 
                i++;    //Skip same value to avoid duplicate list
            list.remove(list.size()-1);
        }
    }
}
