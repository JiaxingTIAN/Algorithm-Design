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

**Algorithm using backtrack and recursion**

Sort the array first to terminate when target is smaller than 0

Time complexity is O(target^length)

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
# Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
```
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```
** Similar to previous but ignore same index **
Skip when idx > start and candidates[idx] == candidates[idx - 1] to avoid duplication
Time complexity 2^N
```java
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
    //DFS with backtrack O(2^n) 
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
            if(i > idx && cands[i] == cands[i-1])
                continue;
            list.add(cands[i]);
            dfs(res, list, cands, target, sum+cands[i], i+1);   //Each value use once, next iteration start with i+1
            list.remove(list.size()-1);
        }
    }
}
```

# Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

```
Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
```

```java
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n <= 0)  return null;
        if(k > 9)   k = 9;
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    //DFS with backtrack
    public void dfs(List<List<Integer>> res, List list, int k, int n, int idx){
        if(n == 0 && list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        if(n <= 0 || list.size() >= k){
            return;
        }
        for(int i=idx; i<10; i++){
            list.add(i);
            dfs(res, list, k, n - i, i + 1);
            list.remove(list.size()-1);
        }
    }
}
```
