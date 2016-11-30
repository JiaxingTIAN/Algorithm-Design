# Shortest Palindrome

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

* Algorithm:

Find the longest palindrome substring start from beginning and reverse the rest of string to the front

**Time Complexity O(n^2)**

KMP ALG => O(n)

```java
public class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        char[]c = s.toCharArray();
        while(i < j){
            if(c[i] == c[j]){
                i++;
                j--;
            }else{
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().append(s).toString();
    }
}
```
