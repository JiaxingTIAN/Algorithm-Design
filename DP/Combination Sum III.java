public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n <= 0)  return null;
        if(k > 9)   k = 9;
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    //DFS with backtrack O(2^9)
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
