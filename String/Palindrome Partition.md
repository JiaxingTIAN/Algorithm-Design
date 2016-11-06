#Palindrome Partition

>Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return
```
[
  ["aa","b"],
  ["a","a","b"]
]
```
Recursion with backtrack 
check for part of the string, check for the rest part of string

Time complexity O(2^n) for the worst case 'aaaaaaaa'
```
Tn  = Tn-1 + Tn-2 + Tn-3 + ... T1
Tn-1 = Tn-2 + Tn-3 + ...
Tn = Tn-1 + Tn-1
Tn = 2Tn-1
Tn = O(2^n)
```

```java
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> cur, String s, int start){
        if(start == s.length()){  //reach end added all partition
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(!valid(s, start, i)) //if not palindrome continue search
                continue;
            cur.add(s.substring(start, i+1));
            dfs(res, cur, s, i+1);  //if palindrome then continue solve for rest part of problem
            cur.remove(cur.size()-1);
        }
    }
    
    public boolean valid(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
```
##Palindrome Partition II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

**Alogrithm**
use cut[i] to record the min cut from 0 to i
pali(i, j) = true if from i to j form a palindrome
```
a   b   a   |   c  c
                j  i
       j-1  |  [j, i] is palindrome
   cut(j-1) +  1
```
This can be solved by two points:

* cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
* If  [j + 1, i - 1] is palindrome, and c[j] == c[i] =>> [j, i] is palindrome,

```java
public class Solution {
    public int minCut(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[]dp = new int[n];
        boolean[][]pali = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=0; j<=i; j++){
                if(ch[i] == ch[j] && (j+1 > i-1 || pali[j+1][i-1])){  
                    //Valid palindrome
                    min = j==0?0:Math.min(min, dp[j-1]+1);
                    pali[j][i] = true;
                }
            }
            dp[i] = min;
        }
        return dp[n-1];
    }
}
```
