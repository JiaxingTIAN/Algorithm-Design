public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        //Rolling array
        long[] rob = new long[2];
        rob[1] = A[0];
        for(int i=2;i<=A.length;i++){
            rob[i%2] = Math.max(rob[(i-1)%2], rob[(i-2)%2] + A[i-1]);
        }
        return rob[(A.length)%2];
    }
}
