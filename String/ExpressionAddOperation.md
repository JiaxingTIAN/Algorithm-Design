#Expression Add Operators
>Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
```
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
```
**Algorithm**
DFS solution with many corner cases
Try different substring as number each with + - * operation
**Time Complexity**
```
T(n) = 3 * T(n-1) + 3 * T(n-2) + 3 * T(n-3) + ... + 3 *T(1);
T(n-1) = 3 * T(n-2) + 3 * T(n-3) + ... 3 * T(1);
Thus T(n) = 4T(n-1);
O(4^n)
```
Can be optimized with string builder
```java
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    //Multed is used to record previous oprand to restore and multiply if *
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;   //Number cannot start at zero
            long cur = Long.parseLong(num.substring(pos, i + 1));   //Use long to avoid overflow
            if(pos == 0){   //No leading operations
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                //If mul restore the preious number and add the multiply result
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
```
```java
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0)
            return res;
        dfs(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }
    //Time O(4^n)
    public void dfs(String num, int target, List<String> res, StringBuilder sb, long val, long pre, int start){
        if(start == num.length()){    //Reach the end
            if(val == target)   //Add if target equals to val
                res.add(sb.toString());
            return;
        }
        for(int i=start; i<num.length(); i++){
            if(i>start && num.charAt(start) == '0')
                break;  //Skip all subsequence when leading zero
            long cur = Long.parseLong(num.substring(start, i+1));   //Avoid overflow
            int len = sb.length();
            if(start == 0){ //No leading operations
                dfs(num, target, res, sb.append(cur), cur, cur, i+1);
                sb.setLength(len);
            }else{
                dfs(num, target, res, sb.append("+" + cur), val + cur, cur, i+1);
                sb.setLength(len);
                dfs(num, target, res, sb.append("-" + cur), val - cur, -cur, i+1);
                sb.setLength(len);
                dfs(num, target, res, sb.append("*" + cur), val-pre+pre*cur, pre*cur, i+1);
                sb.setLength(len);
            }
        }
    }
}
```
