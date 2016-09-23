public class Solution {
    /*
Suppose there are N elements in the array, the min value is min and the max value is max. Then the maximum gap will be no smaller than 
ceiling[(max - min ) / (N - 1)].

Let gap = ceiling[(max - min ) / (N - 1)]. We divide all numbers in the array into n-1 buckets, where k-th bucket contains all numbers 
in [min + (k-1)gap, min + k*gap). Since there are n-2 numbers that are not equal min or max and there are n-1 buckets, at least one of 
the buckets are empty. We only need to store the largest number and the smallest number in each bucket.
In that way, the maximum gap wont happen within the bucket
After we put all the numbers into the buckets. We can scan the buckets sequentially and get the max gap.
*/

    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        
        int max = nums[0], min = nums[0];
        for(int i=1; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        int n = nums.length;
        Bucket[] bucket = new Bucket[n];
        
        for(int i=0; i<n; i++){
            bucket[i] = new Bucket();
        }
        
        int gap = (int)Math.ceil((double)(max - min)/(n-1));
        if(gap == 0)
            return 0;
        //Put numbers in the bucket
        for(int i=0; i<n; i++){
            int idx = (nums[i]-min)/gap;
            if(bucket[idx].min == -1){
                bucket[idx].min = nums[i];
                bucket[idx].max = nums[i];
            }else{
                bucket[idx].max = Math.max(bucket[idx].max, nums[i]);
                bucket[idx].min = Math.min(bucket[idx].min, nums[i]);
            }
        }
        
        int maxGap = 0;
        int pre = bucket[0].max;
        for(int i=1; i<n; i++){
            if(bucket[i].min != -1){ //Not empty
                maxGap = Math.max(maxGap, bucket[i].min - pre);
                pre = bucket[i].max;
            }
        }
        return maxGap;
    }
    
    class Bucket{
        int min;
        int max;
        public Bucket(){
            min = -1;
            max = -1;
        }
    }
}
