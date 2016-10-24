public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] res = new int[length];
        for(int[]nums:updates){
            int s = nums[0];
            int e = nums[1];
            int val = nums[2];
            res[s] += val;  //Start index with val
            if(e<length-1)  //end + 1 index with -val
                res[e+1] -= val;
        }
        for(int i=1; i<length; i++){    //Sum Up
            res[i] = res[i-1] + res[i];
        }
        return res;
    }
}
