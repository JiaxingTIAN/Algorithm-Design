public class Solution {
    public String addStrings(String num1, String num2) {
        //String a is the longer one
        String a = num1, b = num2;
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length()-1;
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";
        
        while(pb >= 0){
            int sum = (a.charAt(pa) - '0') + (b.charAt(pb) - '0') + carries;
            rst = (sum % 10) + rst;
            carries = sum / 10;
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (a.charAt(pa) - '0') + carries;
            rst = (sum % 10) + rst;
            carries = sum / 10;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;
        return rst;
    }
}
