public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); //Implement with stack LIFO
        char[] c = s.toCharArray();
        for(char p:c){
            if(p == '(' || p == '{' || p == '['){   //left parenthese push to stack
                stack.push(p);
            }else if(!stack.isEmpty()){ //right parenthese and stack not empty
                char l = stack.pop();   //pop one last left parenthese out of the stack
                if((l == '[' && p != ']') || (l == '{' && p != '}') || (l == '(' && p != ')')){
                    return false;   //return false if not match
                }
            }else{  //return false when there is a right parenthese and no left parenthese
                return false;
            }
        }
        //check if any left parenthese unmatched.
        return stack.isEmpty();
    }
}
