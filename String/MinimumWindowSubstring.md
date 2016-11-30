# Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

* Use Sliding Window => Time Complexity O(n)
```java
public class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if(s == null || t == null || s.length() == 0 || t.length() == 0)
            return res;
        int n = s.length(), m = t.length();
        int min = Integer.MAX_VALUE;

        int[]count = new int[256];  //Store the count for character in t
        for(char c:t.toCharArray())
            count[c]++;

        for(int i = 0, j = 0; j < n; j++){   //Sliding window i to j, forward j each time
            if(count[s.charAt(j)]-- > 0)     //Character in t will be > 0, not in t will be = 0
                m--;    //Character  not in t will be smaller than 0
            while(m == 0){  //Move i forward
                if(j - i + 1 < min){
                    res = s.substring(i, j + 1);
                    min = j - i + 1;
                }
                if(count[s.charAt(i++)]++ == 0)
                    m++;
            }
        }
        return res;
    }
}
```
            
