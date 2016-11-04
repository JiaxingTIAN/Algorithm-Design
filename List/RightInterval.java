/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return new int[]{-1};
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<intervals.length; i++){
            map.put(intervals[i].start, i);
        }
        for(int i=0; i<intervals.length; i++){
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key == null ? -1 : map.get(key);
        }  
        return res;
    }
}
