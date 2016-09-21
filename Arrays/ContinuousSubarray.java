public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    //Basic using 2 for loops -> O(n^2)
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        int[] ans = new int[2];
        if(A == null || A.length == 0){
            return new ArrayList<>();
        }
        int n = A.length;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += A[j];
                if(sum > max){
                    max = sum;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(ans[0]);
        res.add(ans[1]);
        return res;
    }
    

}
