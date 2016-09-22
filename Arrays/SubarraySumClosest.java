public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int [] ans = new int[2];
        Pair[] sum = new Pair[n+1]; //Padding zero at the start
        sum[0] = new Pair(0, -1);
        for(int i=1; i<=n; i++){
            sum[i] = new Pair(sum[i-1].sum+nums[i-1], i-1);
        }
        //sort in ascending order
        Comparator<Pair> cmp = new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.sum - p2.sum;
            }
        };
        //Sort the prefix sum
        Arrays.sort(sum, cmp);
        int diff = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int d = sum[i].sum - sum[i-1].sum;
            if(d < diff){
                diff = d;
                if(sum[i-1].idx < sum[i].idx){
                    ans[0] = sum[i-1].idx + 1;
                    ans[1] = sum[i].idx;
                }else{
                    ans[0] = sum[i].idx + 1;
                    ans[1] = sum[i-1].idx;
                }
            }
        }
        
        return ans;
    }
    //Class Pair to record sum and index
    class Pair{
        int sum;
        int idx;
        
        public Pair(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
}
