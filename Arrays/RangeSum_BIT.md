#Range Sum mutable

Binary Index Tree

Query and update O(logN) 

```java
public class NumArray {
    int[]bit;
    int[]nums;
    int n;
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        bit = new int[n+1];
        for(int i=0; i<n; i++)
            init(i, nums[i]);
    }
    
    public void init(int i, int val){
        i++;
        while(i <= n){
            bit[i] += val;
            i += (i & -i);
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
        while(i > 0){
            sum += bit[i];
            i -= (i & -i);
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
```
