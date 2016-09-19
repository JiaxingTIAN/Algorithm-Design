class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length == 0)
            return new int[k];
        if(k > nums.length)
            k = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int num: nums){
            if(heap.size()<k){
                heap.offer(num);
            }else if(num > heap.peek()){
                heap.poll();
                heap.offer(num);
            }
        }
        
        int[] ans = new int[k];
        for(int i=k-1; i>=0; i--){
            ans[i] = heap.poll();
        }
        
        return ans;
    }
};
