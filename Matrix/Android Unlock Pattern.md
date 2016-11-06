#Android Unlock Pattern

>Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.
```
Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
```
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.

**Algorithm**
DFS with backtrack 
The general idea is DFS all the possible combinations from 1 to 9 and skip invalid moves along the way.
We can check invalid moves by using a jumping table. 
e.g. If a move requires a jump and the key that it is crossing is not visited, then the move is invalid. Furthermore, we can utilize symmetry to reduce runtime
```java
public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][]skip = new int[10][10];
        //The skip number between i and j
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean visit[] = new boolean[10];  //visit list for 0-9
        int res = 0;
        for(int i=m; i<=n; i++){    //Search through count m to n
            res += dfs(skip, visit, 1, i-1) * 4; //start from 1, 3, 7, 9 are same times 4
            res += dfs(skip, visit, 5, i-1);
            res += dfs(skip, visit, 2, i-1) * 4; //start from 2, 4, 6, 8 are same times 4
        }
        return res;
    }
    //Start from cur, remain is the step need to dial
    public int dfs(int[][]skip, boolean[]visit, int cur, int remain){
        if(remain < 0)
            return 0;
        if(remain == 0)
            return 1;
        visit[cur] = true;
        int res = 0;
        for(int i=1; i<=9; i++){    //Try for next number vary from 0-9
            if(!visit[i] && (skip[cur][i]==0||visit[skip[cur][i]])){ 
            //Not visited and no skip or skip is visited
                res += dfs(skip, visit, i, remain-1);
            }
        }
        visit[cur] =false;  //Dont forget to restore after search
        return res;
    }
}
```
