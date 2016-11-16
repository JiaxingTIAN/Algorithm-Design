#Meeting Rooms I

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.


```java
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);  
        //Lambda expression, single expression on {} or return needed
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start)
                return false;
        }
        return true;
    }
}

```

#Meeting Room II

>Minimum Number of Meeting rooms required

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.

```
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
```
Sweep Line

```java
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
    class Point{
        int time;
        boolean start;
        public Point(int t, boolean s){
            time = t;
            start = s;
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        List<Point> points = new ArrayList<>();
        for(Interval in:intervals){
            points.add(new Point(in.start, true));
            points.add(new Point(in.end, false));
        }
        Collections.sort(points, (a, b) -> {    //Parameter type for lambda expression is optional
            if(a.time != b.time)
                return a.time - b.time;
            else
                return a.start?1:-1;    //Put the start point behind end point
        });
        int count = 0, max = 0;
        for(Point a:points){
            if(a.start)
                count++;
            else
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
```

#Right Interval

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.

```java
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
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0; i<intervals.length; i++){
            tm.put(intervals[i].start, i);
        }
        int[]res = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            Integer r = tm.ceilingKey(intervals[i].end);
            res[i] = r==null?-1:tm.get(r);
        }
        return res;
    }
}
```
