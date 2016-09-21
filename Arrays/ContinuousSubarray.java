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

//DP approach run in O(n) time
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        //[-3, 1, 3, -3, 4]
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null || A.length == 0){
            return ans;
        }
        int n = A.length;
        int sum = A[0];
        int max = A[0];
        int start = 0, end = 0, max_start = 0, max_end = 0;
        for(int i=1; i<n; i++){
            if(A[i] > sum + A[i]){
                sum = A[i]; //sum = 1
                start = i;  //start = 1
                end = i;
            }else{
                sum += A[i];    //sum = 4
                end = i;        //end = 2
            }
            
            if(sum > max){
                max = sum;  //max = 4
                max_start = start;  //max_start = 1
                max_end = end;  //max_end = 2
            }
        }
        ans.add(max_start);
        ans.add(max_end);
        return ans;
    }
}
