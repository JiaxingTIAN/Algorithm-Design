public class Solution {
    int[] arr;
    Random rand;
    public Solution(int[] nums) {
        arr = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int idx = -1;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target && rand.nextInt(++count) == 0){
                idx = i;
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
