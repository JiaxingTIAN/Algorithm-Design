/*
Problem Description:

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

The final sorted nums needs to satisfy two conditions:

If i is odd, then nums[i] >= nums[i - 1];
If i is even, then nums[i] <= nums[i - 1];
*/
//Coding
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        for(int i=1; i<nums.length; i++){
            if(((i&1) == 1 && nums[i] < nums[i-1]) || ((i&1) == 0 && nums[i] > nums[i-1]))
                swap(nums, i, i-1);
        }
    }
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
