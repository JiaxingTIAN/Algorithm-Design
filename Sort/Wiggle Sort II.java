//O(nlogn) time complexity O(n) space complexity
public class Solution{
    public void wiggleSort(int[] nums){
        if(nums==null || nums.length<2) return;
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];
        int left = (n-1)/2;
        int right = n-1;
        for(int i=0;i<n;i++){
            if(i&1==0){
                temp[i] = nums[left];
                left--;
            }
            else{
                temp[i] = nums[right];
                right--;
            }
        }
        System.arraycopy(temp,0,nums,0,n);
    }
}
//Linear Time Space
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        int n = nums.length;
         
        // Step 1: Find median of the array, return the index of the median
        int median = findMedian(nums, 0, n - 1, (n - 1) / 2);
         
        // Step 2: 3-way sort, put median in the middle, 
        // numbers less than median on the left, 
        // numbers greater than median on the right
        int[] temp = new int[n];
        int left = 0;
        int right = n - 1;
         
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[median]) {
                temp[left] = nums[i];
                left++;
            } else if (nums[i] > nums[median]) {
                temp[right] = nums[i];
                right--;
            }
        }
         
        // add median into the middle
        for (int i = left; i <= right; i++) {
            temp[i] = nums[median];
        }
         
        // Step 3: wiggle sort
        left = (n - 1) / 2;
        right = n - 1;
         
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = temp[left];
                left--;
            } else {
                nums[i] = temp[right];
                right--;
            }
        }
    }
     
    private int findMedian(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return lo;
        }
         
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return pivot;
        }
         
        if (pivot > k) {
            return findMedian(nums, lo, pivot - 1, k);
        } else {
            return findMedian(nums, pivot + 1, hi, k);
        }
    }
     
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
         
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
             
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
             
            if (i <= j) {
                swap(nums, i, j);
            }
        }
         
        swap(nums, lo, j);
         
        return j;
    }
     
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
         
        int n = nums.length;
         
        // Step 1: Find median of the array, return the index of the median
        int median = findMedian(nums, 0, n - 1, (n - 1) / 2);
         
        // Step 2: 3-way partition, put median in the middle, 
        // numbers less than median on the left, 
        // numbers greater than median on the right
        int left = 0;
        int right = n - 1;
        int j = 0;
        while (j <= right) {
            if (nums[j] < nums[median]) {
                swap(nums, j, left);
                j++;
                left++;
            } else if (nums[j] > nums[median]) {
                swap(nums, j, right);
                right--;
            } else {
                j++;
            }
        }
         
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
         
        // Step 3: wiggle sort
        left = (n - 1) / 2;
        right = n - 1;
         
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = temp[left];
                left--;
            } else {
                nums[i] = temp[right];
                right--;
            }
        }
    }
     
    private int findMedian(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return lo;
        }
         
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return pivot;
        }
         
        if (pivot > k) {
            return findMedian(nums, lo, pivot - 1, k);
        } else {
            return findMedian(nums, pivot + 1, hi, k);
        }
    }
     
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo + 1;
        int j = hi;
         
        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }
             
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
             
            if (i <= j) {
                swap(nums, i, j);
            }
        }
         
        swap(nums, lo, j);
         
        return j;
    }
     
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
