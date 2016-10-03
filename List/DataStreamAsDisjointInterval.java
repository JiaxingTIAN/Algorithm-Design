public class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> map; //Store the start and the interval pair
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    //O(logN) complexity - TreeMap put, remove, lowerKey, higherKey all O(logN) complexity
    public void addNum(int val) {
        //If the val is already a start return
        if(map.containsKey(val)){
            return;
        }
        
        Integer low = map.lowerKey(val);
        Integer high = map.higherKey(val);
        //Case 1: Connect two intervals -> merge two intervals
        if(low != null && high != null && map.get(low).end+1 == val && map.get(high).start == val+1){
            //Merge by extend the lower interval end to be end of high interval and remove high interval
            map.get(low).end = map.get(high).end;
            map.remove(high);
        }else if(low != null && map.get(low).end + 1 >= val){
            //Case 2: val equals the low interval end + 1 => extend the lower interval
            //Case 3: val is smaller or equals to the lower interval end => no need to change
            map.get(low).end = Math.max(map.get(low).end, val);
        }else if(high != null && val + 1 == map.get(high).start){
            //Case 4: val + 1 equals the start of higher interval
            map.put(val, new Interval(val, map.get(high).end));
            map.remove(high);
        }else{
            //Otherwise create a new interval of val
            map.put(val, new Interval(val, val));
        }
        
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
