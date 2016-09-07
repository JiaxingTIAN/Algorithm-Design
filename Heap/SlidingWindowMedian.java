public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0 || k==0)
            return ans;
        //Max Heap to store upper half of the array, Min heap to store lower half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        for(int i=0;i<nums.length;i++){
            // Add element to the window
            if(maxHeap.isEmpty() || nums[i] < maxHeap.peek())
                maxHeap.offer(nums[i]);
            else
                minHeap.offer(nums[i]);
            // Remove the last element
            if(i>=k){
                if(nums[i-k] <= maxHeap.peek())
                    maxHeap.remove(nums[i-k]);
                else
                    minHeap.remove(nums[i-k]);
            }
            // Keep the heap balance
            while(minHeap.size() >= maxHeap.size()+1)
                maxHeap.offer(minHeap.poll());
            while(maxHeap.size() > minHeap.size()+1)
                minHeap.offer(maxHeap.poll());
            if(i >= k-1)
                ans.add(maxHeap.peek());
        }
        return ans;
    }
}
