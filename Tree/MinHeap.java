public class Solution {
    //Time complexity O(n)
    public void heapify(int[] A) {
        // write your code here
        for(int i=A.length/2;i>=0;i--){
            //Start from A.length/2, which is the 2nd last row - bottom up
            //Ensure the top is smallest
            siftdown(A, i);
        }
    }
    
    private void siftdown(int[] A, int k){
        while(k<A.length){
            int smallest = k;
            if(k*2+1<A.length && A[2*k+1] < A[smallest])
                smallest = k*2+1;
            if(k*2+2<A.length && A[2*k+2] < A[smallest])
                smallest = k*2+2;
            if(smallest == k)
                break;
            int tmp = A[smallest];
            A[smallest] = A[k];
            A[k] = tmp;
            k = smallest;
        }
    }
}
