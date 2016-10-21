public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1){
            return res;
        }
        dfs(res, new ArrayList<>(), n, 2, n);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int n, int start, int target){
        if(n == 1){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start; i<=n; i++){
            if(n%i == 0 && i < target){
                list.add(i);
                dfs(res, list, n/i, i, target);
                list.remove(list.size()-1);
            }
        }
    }
}
