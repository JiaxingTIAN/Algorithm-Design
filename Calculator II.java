public class Solution {
    public int calculate(String s) {
        //Using a stack to calculate the * and / first and store the result in the stack
        //Sum up all the number in the stack
        if(s.length()==0||s==null) return 0;
        Stack<Integer> stack = new Stack();
        char[] str = s.toCharArray();
        int len = s.length();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(str[i]))
                num = num*10 + str[i];
            if((!Character.isDigit(str[i]) && str[i]!=' ')||i==len-1){
                if(sign=='+') stack.push(num);
                else if(stack=='-') stack.push(-num);
                else if(stack=='*') stack.push(stack.pop()*num);    
                else if(stack=='/') stack.push(stack.pop()/num);
                sign = str[i];
                num=0;
            }
        }
        int res = 0;
        for(int i:stack) res+=i;
        return res;
    }
}
