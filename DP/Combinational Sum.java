public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] cands, int target) {
        //DFS backtrack approach
        Arrays.sort(cands);
        List<Integer> list = new LinkedList<>();
        findNum(list, cands, 0, target, 0);
        return res;
        /*
        //DP Approach O(target^2 * N)
        Arrays.sort(cands); //sort the array to avoid duplication
        List<List<List<Integer>>> dp = new ArrayList<>();   //DP [value][all list sum up to value][sum up to value]
        for(int i = 1; i <= target; i++){   //for value 1 to target
            List<List<Integer>> list = new ArrayList<>();   //all the lists sum up to i
            for(int j = 0; j < cands.length && cands[j] <= i; j++){
                if(cands[j] == i)   //single number list
                    list.add(Arrays.asList(cands[j]));
                else for(List<Integer> pre:dp.get(i - cands[j] - 1)){
                    //get result from previous value
                    if(cands[j] >= pre.get(pre.size()-1)){
                        //when the current value is no smaller than the last one add to the list
                        List<Integer> cur = new ArrayList<>();
                        cur.addAll(pre);
                        cur.add(cands[j]);
                        list.add(cur);
                    }
                    
                }
            }
            dp.add(list);
        }
        return dp.get(target - 1);
        */
    }
    //DFS O(target^N)
    public void findNum(List nums, int[] candidates, int sum, int target, int start){
        
        if(sum == target) {
            res.add(new LinkedList(nums));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i = start;i<candidates.length && sum + candidates[i] <= target;i++){
            nums.add(candidates[i]);
            findNum(nums, candidates, sum+candidates[i], target, i);
            nums.remove(nums.size()-1);
        }
       
    }
}
