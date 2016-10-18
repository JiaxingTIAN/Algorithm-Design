public class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //Sum is between [max, sum]
        long max = 0, sum = 0;
        for(int num:nums){
            max = Math.max(max, num);
            sum += num;
        }
        long l = max, r = sum;  //Overflow
        while(l <= r){
            long mid = (l + r)/2;
            if(valid(nums, m, mid)){
                l = mid + 1;    //too small increase target
            }else{
                r = mid - 1;
            }
        }
        return (int)l;
    }
    public boolean valid(int[]num, int m, long target){
        int count = 1;
        long sum = 0;
        for(int n:num){
            sum += n;
            if(sum > target){
                sum = n;  //Closet to target but smaller
                count++;
            }
            if(count > m){  //Dont use up all elements 
                return true;    //can be divide into more than m subarray, target too small
            }
        }
        return false;   //use up all elem => Cannot divide into more than m subarray, target is too large
    }
}
