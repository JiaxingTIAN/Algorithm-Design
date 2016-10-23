public class NumArray {
    int[]num;
    int[]sum;   //prefix sum good for less update operation
    public NumArray(int[] nums) {   //O(N) build
        num = nums;
        sum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++)
            sum[i] = sum[i-1] + num[i-1];
    }

    void update(int i, int val) {
        //O(N)
        for(int j=i+1; j<sum.length; j++){
            sum[j] = sum[j] + val - num[i];
        }
        num[i] = val;
    }

    public int sumRange(int i, int j) {
        //Constant retrieve
        return sum[j+1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);


public class NumArray {
    //Binary Index Tree
    int[] nums;
    int[] BIT;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n+1];
        for(int i=0;i<n;i++)
            init(i, nums[i]);
    }
    
    public void init(int i, int val){
        i++;
        while(i<=n){
            BIT[i] += val;
            i += (i&-i);
        }
    }
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }
    public int getSum(int i){
        int sum = 0;
        i++;
        while(i>0){
            sum+=BIT[i];
            i-=(i&-i);
        }
        return sum;
    }
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
