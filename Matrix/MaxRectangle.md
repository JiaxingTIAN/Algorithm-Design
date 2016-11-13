#Max Aera of rectangle

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:
```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```

**ALG**

The DP solution proceeds row by row, 
starting from the first row. Let the maximal rectangle area at row i and column j be computed by 
```[right(i,j) - left(i,j)] * height(i,j)``` left is the start index of continous 1 (position to 1)
right most (max) compare with previous row; 
right is end index of continous 1 (position to 0) left most (min) compare with previous row

Preceed row by row update the left[m] right[m] and height[m] of each row
Initalize left[i] to be 0 right[i] to be m and height[i] to be 0 to avoid 
left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
height(i,j) = height(i-1,j) + 1, if matrix[ i ][ j ]=='1';
height(i,j) = 0, if matrix[ i ][ j ]=='0'

```java
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        
        int[] left = new int[m];
        int[] right = new int[m];
        int[] height = new int[m];
        int max = 0;
        Arrays.fill(right, m);
        for(int i = 0; i < n ; i++){
            int l = 0, r = m;
            for(int j = m-1; j >= 0; j--){
                if(matrix[i][j] == '1')
                    right[j] = Math.min(r, right[j]);
                else{
                    right[j] = m;
                    r = j;  //padding at the end
                }
            }
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){   //Update left and height
                    left[j] = Math.max(l, left[j]);
                    height[j]++;
                }
                else{
                    height[j] = 0;
                    left[j] = 0;
                    l = j + 1;
                }
                //System.out.println("L: " + left[j] + "R: " + right[j] + "H: " + height[j]);
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        return max;
    }
}
```
