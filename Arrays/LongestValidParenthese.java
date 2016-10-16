//Use a stack to record all the location of invalid parenthese
//iterate through the stack for longest length between invalid parenthese
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();   //Keep the invalid parenthese
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //First iterate to locate invalid parenthese location
            if(c == '('){
                stack.push(i);  //push to stack when (
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty())
            return s.length();
        int len = 0, a = s.length(), b = 0; //start from n - stack.peek()
        while(!stack.isEmpty()){
            b = stack.pop();
            len = Math.max(len, a - b - 1);
            a = b;
        }
        len = Math.max(len, a); //for 0 - a
        return len;
    }
}

//Dynamic Programming Version
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int[]dp = new int[s.length()];
        char[] ch = s.toCharArray();
        for(int i=1; i<s.length(); i++){
            if(ch[i] == ')'){
                if(ch[i-1] == '('){
                    dp[i] = (i >= 2)? dp[i-2] + 2: 2;
                }else if(i-dp[i-1]-1 >= 0 && ch[i-dp[i-1]-1] == '('){
                    dp[i] = dp[i-1] + 2;
                    if(i - dp[i-1] - 2 >= 0){
                        dp[i] += dp[i-dp[i-1]-2];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        /*
        Stack<Integer> stack = new Stack<>();   //Keep the invalid parenthese
        for(int i=0; i<s.length(); i++){
            char c = ch[i];
            //First iterate to locate invalid parenthese location
            if(c == '('){
                stack.push(i);  //push to stack when (
            }else{
                if(!stack.isEmpty() && ch[stack.peek()] == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty())
            return s.length();
        int len = 0, a = s.length(), b = 0; //start from n - stack.peek()
        while(!stack.isEmpty()){
            b = stack.pop();
            len = Math.max(len, a - b - 1);
            a = b;
        }
        len = Math.max(len, a); //for 0 - a
        return len;
        */
    }
}
