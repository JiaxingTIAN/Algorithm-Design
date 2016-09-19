class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(S == null || S.size() == 0){
            return ans;
        }
        Collections.sort(S);
        findSubsets(S, ans, list, 0);
        return ans;
    }
    
    public void findSubsets(ArrayList s, ArrayList ans, ArrayList list, int k){
        ans.add(new ArrayList(list));
        for(int i=k; i<s.size(); i++){
            if(i > k && s.get(i) == s.get(i-1))
                continue;
            list.add(s.get(i));
            findSubsets(s, ans, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
