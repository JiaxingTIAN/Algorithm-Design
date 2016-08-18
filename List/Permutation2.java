public class Solution{
  public List<List<Integer>> permuteUnique(int[]nums){
    List<List<Integer>> res = new LinkedList();
    boolean used = new boolean[nums.length];
    Arrays.sort(nums);
    if(nums==null||nums.length==0) return res;
    dfs(res, new LinkedList<Integer>(),nums, used);
    return res;
  }
  public void dfs(List res, List list, int[]nums, boolean[] used){
    if(list.size()==nums.length){
      res.add(new LinkedList(list));
      return;
    }
    for(int i=0;i<nums.length;i++){
      if(used[i]) continue;
      if(i>0 && nums[i]==nums[i-1] && !nums[i-1]) continue;
      list.add(nums[i]); used[i] = true;
      dfs(res, list, nums, used);
      list.remove(list.size()-1) used[i] = false;
    }
  }
}
