public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums==null||nums.length==0||k<=0) return false;
        TreeSet<Integer> tree = new TreeSet();
        //Maintain a window of k integers by a BST, retrive time logK
        for(int i=0;i<nums.length;i++){
            Integer floor = tree.floor(nums[i] + t);    //largest number in the tree smaller than nums[i]+t
            Integer ceil = tree.ceiling(nums[i] - t);   //smallest number in the tree larger than nums[i]-t
            if(floor!=null && floor>=nums[i])
                return true;
            if(ceil!=null && ceil<=nums[i])
                return true;
            tree.add(nums[i]);
            if(i>=k)
                tree.remove(nums[i-k]);
        }
        return false;
    }
}
