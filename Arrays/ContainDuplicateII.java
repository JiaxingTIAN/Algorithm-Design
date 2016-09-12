public class Solution {
    //Sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
            
        }
        return false;
    }
    /*
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            //No duplicate Key, duplicate key will return the previous value
            Integer duplicate = map.put(nums[i],i); 
            if(duplicate!=null&&i-duplicate<=k) return true;
        }
        return false;
    }
    */
}
