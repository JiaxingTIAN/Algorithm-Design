public class Solution {
    public String removeKdigits(String num, int k) {
        //Use Stack 
        if(num == null || num.length() == 0){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<num.length(); i++){
            while(!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k-- > 0)    stack.pop();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        String res = sb.reverse().toString();
        int i = 0;
        while(i < res.length() && res.charAt(i) == '0') i++;
        return i==res.length()? "0":res.substring(i);
    }
    public String removeKdigits2(String num, int k) {
        if(num == null || num.length() == 0)
            return num;
        int n = num.length();
        int idx = 0;
        while(idx < num.length() && k>0){
            if(idx < 0) idx = 0;
            if(idx == num.length() - 1){
                num = num.substring(0, idx--);
                k--;
            }else{
                int cur = num.charAt(idx) - '0';
                int next = num.charAt(idx + 1) - '0';
                if(next >= cur){
                    idx++;
                }else{
                    num = num.substring(0, idx) + num.substring(idx+1);
                    idx--;
                    k--;
                }
            }
        }
        int i = 0;
        for(;i < num.length() && num.charAt(i) == '0'; i++);    //Remove heading zeros 
        return num.length() == i? "0":num.substring(i);
    }
}
