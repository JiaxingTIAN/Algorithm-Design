public class Solution {

    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //[1,2,3,4,4] is duplicated value counted in the result?
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n-1, 0);
                int right = map.getOrDefault(n+1, 0);
                int sum = left + right + 1; //Combine the left and right
                map.put(n, sum);    //put the value in the map avoid duplicate
                res = Math.max(res, sum);
                // also update the boundary length to be sum
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }
}
