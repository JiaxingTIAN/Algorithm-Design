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

