public class Solution {
    
    PriorityQueue<Integer> minHeap;
    int size;
    public Solution(int k) {
        // initialize your data structure here.
        minHeap = new PriorityQueue<>();
        size = k;
    }

    public void add(int num) {
        // Write your code here
        if(minHeap.size() < size)
            minHeap.offer(num);
        else if(num > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here

        ArrayList<Integer> ans = new ArrayList<>();
        for(Integer n:minHeap){
            ans.add(n);
        }
        Collections.sort(ans, Collections.reverseOrder());
        return ans;
    }
};
