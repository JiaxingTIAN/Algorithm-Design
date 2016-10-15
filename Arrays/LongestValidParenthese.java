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
