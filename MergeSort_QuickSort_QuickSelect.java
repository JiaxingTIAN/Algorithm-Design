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

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
    public void mergeSort(int[]nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int mid = lo + (hi - lo)/2;
        //Divide further
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid+1, hi);
        merge(nums, lo, mid, hi);   //merge together
    }
    
    public void merge(int[]nums, int lo, int mid, int hi){
        int l = lo, r = mid+1, idx = lo;
        int[] tmp = new int[nums.length];
        while(l <= mid && r <= hi){
            if(nums[l] < nums[r]){
                tmp[idx++] = nums[l++];
            }else{
                tmp[idx++] = nums[r++];
            }
        }
        while(l <= mid){
            tmp[idx++] = nums[l++];
        }
        while(r <= hi){
            tmp[idx++] = nums[r++];
        }
        for(int i=lo; i<=hi; i++)
            nums[i] = tmp[i];
    }
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
