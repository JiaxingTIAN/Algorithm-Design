#Perfect Rectangle
>Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

Example 1:
```
rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]
```
Return true. All 5 rectangles together form an exact cover of a rectangular region.

**Algorithm**
Check two things
* all the small rectangle sum up to large rectangle
* Finally there is 4 points with x1 x2 y1 y2 exists in the HashSet
```java
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
    //(x1, y1) and (x2, y2) forms the large rectangle
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        //Store the points in a hashset
        Set<String> set = new HashSet<>();
        int area = 0;
        for(int[]rec:rectangles){
            x1 = Math.min(rec[0],x1);
            y1 = Math.min(rec[1],y1);
            x2 = Math.max(rec[2],x2);
            y2 = Math.max(rec[3],y2);
            //Update the total area
            area +=(rec[2] - rec[0]) * (rec[3] - rec[1]);
            String p1 = rec[0] + " " + rec[1];
            String p2 = rec[0] + " " + rec[3];
            String p3 = rec[2] + " " + rec[3];
            String p4 = rec[2] + " " + rec[1];
            //Add if not existed before, otherwise remove
            if(!set.add(p1))    set.remove(p1);
            if(!set.add(p2))    set.remove(p2);
            if(!set.add(p3))    set.remove(p3);
            if(!set.add(p4))    set.remove(p4);
        }
        String p1 = x1 + " " + y1;
        String p2 = x1 + " " + y2;
        String p3 = x2 + " " + y1;
        String p4 = x2 + " " + y2;
        if(!set.contains(p1) || !set.contains(p2) || !set.contains(p3) || !set.contains(p4) || set.size()!=4)
            return false; //return false if point not four
        return area == (y2-y1)*(x2-x1); //Check if total area equals large area
    }
}
```
