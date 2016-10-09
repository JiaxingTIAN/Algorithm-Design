public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if((sum & 1) == 1){
            return false;
        }
        //Similar to backpack
        boolean[][] canPartition = new boolean[sum/2 + 1][nums.length+1];
        for(int i=0; i<=nums.length; i++){
            canPartition[0][i] = true;
        }
        for(int i=1; i<=sum/2; i++){
            for(int j=1; j<=nums.length; j++){
                canPartition[i][j] = canPartition[i][j-1];
                if(i >= nums[j-1]){
                    canPartition[i][j] = canPartition[i - nums[j-1]][j-1] || canPartition[i][j];
                }
            }
        }
        return canPartition[sum/2][nums.length];
    }
}
