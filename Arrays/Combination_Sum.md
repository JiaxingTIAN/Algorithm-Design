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

Algorithm using backtrack and recursion
```java
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] can, int target, int idx){
        if(target == 0){    //No duplicate, return after reach zero
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return; //Sorted, return when smaller than zero
        }
        for(int i = idx; i < can.length; i++){  
            //Start from idx, since any element can be used unlimited times
            list.add(can[i]);
            dfs(res, list, can, target - can[i], i);
            list.remove(list.size() - 1);
        }
    }
}
```
