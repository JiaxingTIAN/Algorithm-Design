public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //Brute Force O(N^2) 
        if(nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0, max = 0;
        //Use a hashmap to store the sum-key and index-value(first enconter)
        //subarray sum = cur_sum - pre_sum = k => pre_sum = cur_sum - k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //sum = 0 when no elements
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){    //Only store the first index with sum
                map.put(sum, i);
            }
        }
        return max;
    }
}
