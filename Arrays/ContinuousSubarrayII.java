public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null || A.length == 0){
            return ans;
        }
        int total = A[0];      //Total sum of the array
        int local = A[0];   //local max
        int global = A[0];  //global max
        int[] res = new int[2];
        int start = 0, end = 0; //two pointer indicate the index
        //Min the max value in the middle of the array
        for(int i=1; i<A.length; i++){
            total += A[i];
            if(local < 0){
                local = A[i];
                start = end = i;
            }else{
                local += A[i];
                end = i;
            }
            if(local > global){
                global = local;
                res[0] = start;
                res[1] = end;
            }
        }
        //Find the min value in the middle of the array
        // max  = Total sim - min in middle
        local = A[0];
        start = end = 0;
        for(int i=1; i<A.length; i++){
            if(local > 0){
                local = A[i];
                start = end = i;
            }else{
                local += A[i];
                end = i;
            }
            if(start == 0 || end == A.length-1) 
                continue;
            if(total - local > global){
                global = total - local;
                res[0] = end + 1;
                res[1] = start -1;
            }
        }
        ans.add(res[0]);
        ans.add(res[1]);
        return ans;
    }
}
