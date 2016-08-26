public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        
        Queue<Tuples> heap = new PriorityQueue();
        for(int i=0;i<arrays.length;i++){
            Arrays.sort(arrays[i]);
            if(arrays[i].length>0){
                heap.offer(new Tuples(i, arrays[i].length-1, arrays[i][arrays[i].length-1]));
            }
        }
        for(int i=0;i<k-1; i++){
            Tuples t = heap.poll();
            if(t.c>0)
                heap.offer(new Tuples(t.r, t.c-1, arrays[t.r][t.c-1]));
        }
        return heap.poll().val;
    }
    
    public class Tuples implements Comparable<Tuples>{
        int r, c, val;
        public Tuples(int row, int col, int value){
            this.r = row;
            this.c = col;
            this.val = value;
        }
       
        public int compareTo(Tuples that){
            return that.val - this.val;
        }
    }
}
