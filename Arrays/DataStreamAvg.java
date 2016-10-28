public class MovingAverage {

    /** Initialize your data structure here. */
    Deque<Integer> cache;
    int size;
    long sum;
    public MovingAverage(int size) {
        cache = new LinkedList<>();
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        cache.offerLast(val);
        int pre = 0;
        if(cache.size() > size){
            pre = cache.pollFirst();
        }
        sum += val - pre;
        return (double)sum/cache.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
