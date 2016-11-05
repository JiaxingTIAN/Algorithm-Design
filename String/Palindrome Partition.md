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
