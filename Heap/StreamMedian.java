public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        int[] ans = new int[nums.length];
        if(nums==null||nums.length==0)
            return ans;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length,Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i=0;
        for(int num:nums){
            // Add the element to the heap
            if(maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);
            // Balance the max min heap
            if(minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
            if(maxHeap.size() > minHeap.size()+1)
                minHeap.offer(maxHeap.poll());
            ans[i++] = maxHeap.peek();
        }
        return ans;
    }
}
