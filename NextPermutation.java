public class Solution{
  public void nextPermutation(int[] nums){
    int i=nums.length-1;
    int j=nums.length-1;
    while(i>0&&nums[i-1]>=nums[i]) i--;
    i--;
    if(i>=0){
      while(nums[j]<=nums[i]) j--;
      swap(nums, i, j);
    }
    for(int start=i+1, end = nums.length-1;start<end;start++,end--)
      swap(nums,start,end);
  }
  public void swap(int[]nums, int i, int j){
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
