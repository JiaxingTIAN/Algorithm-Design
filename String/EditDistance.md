# Edit Distance 

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

* Algorithm

```
f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.

f(i, j) = f(i - 1, j - 1)
Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper

f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
f(i, j - 1) represents insert operation
f(i - 1, j) represents delete operation
f(i - 1, j - 1) represents replace operation
Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to j - 1 characters of word2. Same goes for other 2 operations as well.

Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same as delete operation in other. So, we could choose any direction.

Above equations become the recursive definitions for DP.

Base Case:

f(0, k) = f(k, 0) = k
```

```java
public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][]cost = new int [n+1][m+1];
        for(int i = 0; i <= n; i++){
            cost[i][0] = i;
        }
        for(int j = 0; j <= m; j++){
            cost[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cost[i][j] = cost[i-1][j-1];    //Match move both forward
                else{
                    int l1 = cost[i-1][j];  //delete one character
                    int l2 = cost[i][j-1];  //insert one character
                    int l3 = cost[i-1][j-1];    //replace one character
                    cost[i][j] = Math.min(l1, Math.min(l2, l3)) + 1;
                }
            }
        }
        return cost[n][m];
    }
}
```
