Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

**ALG**

3way partition
low pointer for 0
high pointer for 2
another iterate through the array
when enconter 0 swap with low -> both increase
when enconter 2 swap with high -> high decrease


```java
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        for(int k = 0; k <= j; ){
            if(nums[k] == 0){
                swap(nums, i++, k++);
            }else if(nums[k] == 2){
                swap(nums, j--, k);
            }else{
                k++;
            }
        }
    }
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```
