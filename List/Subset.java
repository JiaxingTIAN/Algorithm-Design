public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        findSub(res, new LinkedList<Integer>(), nums, 0);
        return res;
    }
    
    public void findSub(List res, List sub, int[] nums, int start){
        res.add(new LinkedList(sub));
        for(int i=start; i<nums.length; i++){
            sub.add(nums[i]);
            findSub(res, sub, nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}
