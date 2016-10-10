public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    public void quickSort(int[]nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int left = lo, right = hi;
        int pivot = nums[(lo + hi)/2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(nums, left++, right--);
            }
        }

        quickSort(nums, lo, right);
        quickSort(nums, left, hi);
    }
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
