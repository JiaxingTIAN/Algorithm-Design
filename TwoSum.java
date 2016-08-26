public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Using Hash Table
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
    //Using two pointer
    public int[] twoSum2(int[] nums, int target) {
        //Using Hash Table
        Arrays.sort(nums);
        int l = 0, r = nums.length;
        while(l<r){
            int sum = nums[l]+nums[r];
            if(sum==target) return new int[]{l, r};
            else if(sum>target) r--;
            else l++;
        }
        return -1;
    }
}
