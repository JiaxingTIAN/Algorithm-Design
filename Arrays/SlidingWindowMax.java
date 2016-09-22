public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return ans;
            
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        //O(nk) time complexity
        for(int i=0; i<nums.length; i++){
            heap.offer(nums[i]);
            if(i >= k){
                //O(k) time to remove elt from heap
                heap.remove(nums[i-k]);
            }
            if(i >= k-1){
                //O(logk)
                ans.add(heap.peek());
            }
        }
        return ans;
    }
}

//Optimization with deque -> O(n) time complexity
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public void inQueue(Deque<Integer> deque, int num){
        while(!deque.isEmpty() && num > deque.peekLast()){
            deque.pollLast();
        }
        deque.offerLast(num);
    }
    public void outQueue(Deque<Integer> deque, int num){
        if(num == deque.peekFirst())
            deque.pollFirst();
    }
     
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        for(int i=0; i<nums.length; i++){
            inQueue(deque, nums[i]);
            
            if(i >= k-1){
                ans.add(deque.peekFirst());
                outQueue(deque, nums[i-k+1]);
            }
        }
        
        return ans;
    }
}
