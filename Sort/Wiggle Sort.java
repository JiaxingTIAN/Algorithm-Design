/*
Problem Description:

Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

The final sorted nums needs to satisfy two conditions:

If i is odd, then nums[i] >= nums[i - 1];
If i is even, then nums[i] <= nums[i - 1];
*/
//Coding
class Solution {
public: 
    void wiggleSort(vector<int>& nums) {
        int n = nums.size();
        for (int i = 1; i < n; i++)
            if (((i & 1) && nums[i] < nums[i - 1]) || (!(i & 1) && nums[i] > nums[i - 1]))
                swap(nums[i], nums[i - 1]);
    }
};
