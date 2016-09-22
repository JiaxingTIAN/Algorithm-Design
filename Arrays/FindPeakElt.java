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
        // Search for the first peak elt -> O(n)
        for(int i=0; i<A.length-1; i++){
            if(A[i] > A[i+1])
                return i;
        }
        
        return -1;
    }
}


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
        
        int i = 0;
        int j = A.length-1;
        // Binary Search -> O(logn)
        while(i < j){
            int mid = i + (j-i)/2;
            
            if(A[mid] < A[mid+1]){
                //mid cannot be peak
                i = mid + 1;
            }else{
                //mid can still be peak
                j = mid;
            }
        }
        
        return i;
    }
}
