# Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find 
the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

* Sweep Line extend from center to left and right from each location

Time Complexity => O(n^2)

```java
public class Solution{
    public int maxRectangle(int[]heights){
        int max = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            int l = i, r = i;
            while(l >= 0 && heights[l] >= heights[i])
                l--;
            while(r < n && heights[r] >= heights[i])
                r++;
            max = Math.max(max, heights[i] * (r - l + 1);
        }
        return max;
    }
}
```

* Use a stack to record the height that is larger than or equals to top element and pop the element that larger than height

Time Complexity: O(n)

```java
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < heights.length; i++){
            
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i);  //Push if the height is larger than peek
            }else{
                int top = stack.pop();
                int width = stack.isEmpty()? i:i-stack.peek()-1;
                int area = heights[top] * width;
                max = Math.max(max, area);
                i--;
            }
        }
        //Continue pop all the element out of the stack
        while(!stack.isEmpty()){
            int top = stack.pop();
            int width = stack.isEmpty()? n:n-stack.peek()-1;
            int area = heights[top] * width;
            max = Math.max(max, area);
        }
        return max;
    }
}
```
A more concise version

```java
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i <= heights.length; i++){
            int h = i == n? 0:heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);  //Push if the height is larger than peek
            }else{
                int top = stack.pop();
                int width = stack.isEmpty()? i:i-stack.peek()-1;
                int area = heights[top] * width;
                max = Math.max(max, area);
                i--;
            }
        }
        
        return max;
    }
}
```
