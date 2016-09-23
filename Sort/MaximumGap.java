public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            max = Math.max(nums[i], max);
        }
        //Radix sort
        int []output = new int[nums.length];
        for(int exp = 1; max/exp > 0; exp*=10){
            countSort(nums, exp, output);
        }
        int gap = 0;
        
        for(int i=1; i<nums.length; i++){
            gap = Math.max(gap, nums[i] - nums[i-1]);
        }
        return gap;
    }
    public void countSort(int[]nums, int exp, int[]output){
        int[] count = new int[10];
        //Count the number of each digit
        for(int i=0; i<nums.length; i++){
            count[(nums[i]/exp)%10]++;
        }
        //Compute the prefix sum for index
        for(int i=1; i<10; i++){
            count[i] += count[i-1];
        }
        //Start from the end index to maintain order
        for(int i=nums.length-1; i>=0; i--){
            output[--count[(nums[i]/exp)%10]] = nums[i];
        }
        //copy from output to origin array
        for(int i=0; i<nums.length; i++){
            nums[i] = output[i];
        } 
    }
}
