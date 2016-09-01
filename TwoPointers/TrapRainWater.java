public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights==null || heights.length==0)
            return 0;
        int left = 0, right = heights.length-1;
        int vol = 0;
        int left_h = heights[left], right_h = heights[right];
        
        while(left < right){
            if(left_h > right_h){
                right--;
                if(right_h > heights[right])
                    vol += (right_h - heights[right]);
                else
                    right_h = heights[right];
            }else{
                left++;
                if(left_h > heights[left])
                    vol += (left_h - heights[left]);
                else
                    left_h = heights[left];
            }
        }
        return vol;
    }
}
