class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        for(int i=0; i<A.length-1; i++){
            if(A[i] > A[i+1])
                return i;
        }
        
        return -1;
    }
}
