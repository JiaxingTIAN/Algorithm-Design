public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0)
            return 0;
        int max = 0;
        int l = 0, r = heights.length-1;
        while(l < r){
            int area = Math.min(heights[l], heights[r])*(r-l);
            //System.out.println(area);
            max = Math.max(max, area);
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return max;
    }
}
