public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        long[]sum = new long[n+1];    //sum[i] is the prefix sum up to ith elements
        for(int i=1; i<=nums.length; i++)
            sum[i] = sum[i-1] + nums[i-1];
        return mergeCount(sum, 0, n, lower, upper);
    }
    
    public int mergeCount(long[]nums, int lo, int hi, int lower, int upper){
        if(lo >= hi){
            return 0;
        }
        int mid = lo + (hi - lo)/2;
        //Further Divide
        int count = mergeCount(nums, lo, mid, lower, upper);
        count += mergeCount(nums, mid + 1, hi, lower, upper);
        //Merge
        int l = lo, r = mid + 1, idx = 0;   //idx for merge
        int left = mid + 1, right = mid + 1;    //idx for find the bound
        long[]tmp = new long[hi - lo + 1];
        for(; l <= mid; l++){   
            //Find the left and right boundary in right half
            while(left <= hi && nums[left] - nums[l] < lower)
                left++;
            while(right <= hi && nums[right] - nums[l] <= upper)
                right++;
            count += right - left;  //Update the count
            while(r <= hi && nums[r] < nums[l])
                tmp[idx++] = nums[r++];   //Put the smaller value first
            tmp[idx++] = nums[l];
        }
        System.arraycopy(tmp, 0, nums, lo, r-lo);
        return count;
    }

}
