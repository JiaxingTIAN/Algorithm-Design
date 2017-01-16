# Combination Sum


Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
```
[
  [7],
  [2, 2, 3]
]
```
```java
public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] cands, int target) {
        //DFS backtrack approach
        Arrays.sort(cands);
        List<Integer> list = new LinkedList<>();
        findNum(list, cands, 0, target, 0);
        return res;
    }
    
    public void findNum(List nums, int[] candidates, int sum, int target, int start){
        
        if(sum == target) {
            res.add(new LinkedList(nums));
            return;
        }
        if(sum>target){
            return;
        }
        //Skip the rest of candidates when sum is larger than target since sorted
        for(int i = start;i<candidates.length && sum + candidates[i] <= target;i++){
            nums.add(candidates[i]);
            findNum(nums, candidates, sum+candidates[i], target, i);    //pass i since i can be reused
            nums.remove(nums.size()-1);
        }
       
    }
}
```
