#Sparse Matrix Mul
>Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:
```
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
```
**Basic Matrix Mul revert order to make use of sparse check zero first**
```java
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = A[0].length, b = B[0].length;
        int[][] c = new int[n][b];
        for(int i=0; i<n; i++){
            for(int k=0; k<m; k++){
                if(A[i][k] == 0)    continue;
                for(int j=0; j<b; j++){
                    if(B[k][j] == 0)    continue;
                    c[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return c;
    }
}
```
