public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for(int x:nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
