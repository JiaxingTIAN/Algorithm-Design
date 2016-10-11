
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.


 */

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }
        Comparator<Interval> cmp = new Comparator<Interval>(){
            public int compare(Interval v1, Interval v2){
                return v1.start - v2.start;
            }
        };
        //Sort intervals according to start time
        Arrays.sort(intervals, cmp);    //Time complexity O(NlogN)
        //Return false if time conflict
        for(int i=0; i<intervals.length-1; i++){
            if(intervals[i].end > intervals[i+1].start){
                return false;
            }
        }
        return true;
    }
    
}
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2. 
 */

//Sweep Line


public class Solution {
    class Point implements Comparable<Point>{
        int time;
        int start;  //1 for start, 0 for end
        Point(int time, int start){
            this.time = time;
            this.start = start;
        }
        public int compareTo(Point that){
            if(this.time != that.time){
                return this.time - that.time;
            }else{
                return this.start - that.start; //ends before start
            }
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int count = 0;
        List<Point> points = new ArrayList<>();
        for(Interval v:intervals){  //Add all the points to the list
            points.add(new Point(v.start, 1));
            points.add(new Point(v.end, 0));
        }
        int max = 0;
        //Time Complexity O(nlogn)
        Collections.sort(points);   //sort according to time, ends before another start
        for(Point p:points){
            if(p.start == 1){
                count++;
            }else{
                count--;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
