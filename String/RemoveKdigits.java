public class Solution {
    public String removeKdigits(String num, int k) {
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
        for(;i < num.length() && num.charAt(i) == '0'; i++);
        return num.length() == i? "0":num.substring(i);
    }
}
