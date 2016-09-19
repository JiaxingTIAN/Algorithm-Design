public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //Backtracking 
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        findCombine(res,list, 1, n , k);
        return res;
    }
    
    public void findCombine(List res, List list, int start, int n, int k){
        if(k==0){
            res.add(new LinkedList(list));
            return;
        }
        for(int i=start;i<=n-k+1;i++){
            list.add(i);
            findCombine(res, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}
