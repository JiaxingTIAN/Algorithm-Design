public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int max = 1, ins = 1, dec = 1;
        if(A == null || A.length == 0)
            return 0;
        int pre = A[0];
        for(int i=1; i<A.length; i++){
            if(A[i] > pre){
                ins++;
                dec=1;
            }else{
                dec++;
                ins=1;
            }
            pre = A[i];
            max = Math.max(Math.max(max, ins), dec);
        }
        return max;
    }
}
