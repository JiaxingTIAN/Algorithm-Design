public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);  //Sort to make same number next to each other
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(res, new ArrayList<>(), nums, used);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> list, int[]nums, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) //skip if used
                continue;
            if(i>0 && !used[i-1] && nums[i] == nums[i-1])
                continue;   //Skip if previous same and not used
            list.add(nums[i]);  used[i] = true;
            dfs(res, list, nums, used);
            list.remove(list.size()-1); used[i] = false;
        }
    }
}
