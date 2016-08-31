/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
     
    class Point implements Comparable<Point>{
        int time; 
        int flag;
        
        Point(int t, int f){
            this.time = t;
            this.flag = f;
        }
        
        public int compareTo(Point p){
            if(p.time == this.time)
                return this.flag - p.flag;
            else
                return this.time - p.time;
        }
    }
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        List<Point> list = new ArrayList<>();
        for(Interval air:airplanes){
            list.add(new Point(air.start, 1));
            list.add(new Point(air.end, 0));
        }
        Collections.sort(list);
        int count = 0, max = 0;
        for(Point p:list){
            if(p.flag == 1)
                count++;
            else
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
