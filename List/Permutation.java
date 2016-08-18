public class Solution{
  //Insert one number from the nums to the result each time
  public List<List<Integer>> permute(int[]nums){
    List<List<Integer> ans = new ArrayList();
    if(nums.length==0) return ans;
    List<Integer> list = new ArrayList();
    list.add(nums[0]);
    ans.add(list);
    for(int i=1;i<nums.length;i++){
      List<List<Integer>> new_ans = new ArrayList();
      for(int j=0;j<=i;j++){  //pick the location for insert
        for(List<Integer> n:ans){
          List<Integer> newList = new ArrayList();
          newList.add(j, nums[i]);
          new_ans.add(newList);
        }
      }
      ans = new_ans;
    }
    return ans;
  }
  //DFS

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList();
        if(nums==null||nums.size()==0) return res;
        backTrack(res, new ArrayList<Integer>(),nums);
        return res;
    }
    public void backTrack(List res, List list, List nums){
        if(list.size()==nums.size()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(list.contains(nums.get(i))) continue;
            list.add(nums.get(i));
            backTrack(res, list, nums);
            list.remove(list.size()-1);
        }
    }

}
