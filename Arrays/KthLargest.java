class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        //Sort - O(nlogn)
        //Heap - O(n + klogn)
        //QuickSelect - O(n)
        if(k<0 || nums==null || nums.length ==0)
            return -1;
        return quickSelect(k, nums, 0, nums.length-1);
    }
    public int quickSelect(int k, int[] nums, int lo, int hi){
        int l = lo, r = hi, pivot = nums[hi];
        while(l<r){
            if(nums[l++] > pivot) swap(nums, --l, --r);
        }
        swap(nums, hi, l);
        int n = hi - l + 1; //the ranking of pivot
        if(n == k)  return nums[l];
        if(n < k)   return quickSelect(k-n , nums, lo, l-1);
        return quickSelect(k, nums, l+1, hi);
    }
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
};
