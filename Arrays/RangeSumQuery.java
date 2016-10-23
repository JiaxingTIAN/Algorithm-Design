public class NumArray {
    private int[] sum;  //In place optimization
    public NumArray(int[] nums) {
        //sum = new int[nums.length + 1];
        for(int i=1; i<=nums.length; i++){
            nums[i] = nums[i-1] + nums[i];  //Padding with 0 elem sum[0] = 0
        }
        sum = nums;
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i-1];
    }
}
