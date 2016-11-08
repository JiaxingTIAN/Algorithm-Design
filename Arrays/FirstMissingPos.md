#Find the first missing positive number
Given an unsorted integer array, find the first missing positive integer.

For example,
```
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
```
Your algorithm should run in O(n) time and uses constant space.

**ALG**

The key here is to use swapping to keep constant space and also make use of the length of the array.
There can be at most n positive integers. So each time we encounter an valid integer, find its correct position and swap. 
Otherwise we continue.

```java
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(nums[i] > 0 && nums[i] < n && nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }
        int i=0;
        while(i < n && nums[i] == i+1)
            i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
```
