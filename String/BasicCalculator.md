# Basic Calculator

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23

* Use Stack to record both the sign and result O(N)

```java
public class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                res += num * sign;
            }
            if(i == s.length())
                return res;
            if(s.charAt(i) == '+')
                sign = 1;
            if(s.charAt(i) == '-')
                sign = -1;
            if(s.charAt(i) == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            if(s.charAt(i) == ')'){
                res = res * stack.pop() + stack.pop();  //End of parenthese 
            }
        }
        return res;
    }
}
```
