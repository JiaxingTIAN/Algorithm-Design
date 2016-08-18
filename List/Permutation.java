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
}
