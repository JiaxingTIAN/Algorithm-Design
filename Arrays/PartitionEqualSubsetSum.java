public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            sum /= 2;
            boolean[] can = new boolean[sum + 1];
            can[0] = true;
            for (int num : nums) {
                for (int i = sum; i >= num; i--) {
                    can[i] |= can[i - num];
                }
            }
            return can[sum];
        }
        return false;
    }
}
