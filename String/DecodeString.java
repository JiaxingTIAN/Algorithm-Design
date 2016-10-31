/**
 * Created by star on 10/31/16.
 */
import java.util.*;

public class Decode {
    public String decode(String str){
        if(str == null || str.length() == 0)
            return "";
        String res = "";
        int n = str.length();
        Stack<Integer> countSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        int idx = 0;

        while(idx < n){
            char c = str.charAt(idx);
            if(Character.isDigit(c)){
                int end = str.indexOf('[', idx);
                int count = Integer.valueOf(str.substring(idx, end));
                countSt.push(count);
                idx = end;
            }else if (c == '['){
                strSt.push(res);
                res = "";
                idx++;
            }else if(c == ']'){
                String pre = strSt.pop();
                int count = countSt.pop();
                while(count-- > 0){
                    pre += res;
                }
                res = pre;
                idx++;
            }else{
                res += c;
                idx++;
            }
        }
        return res;
    }

    public static void main(String args[]){
        String code = "ab3[de2[ed]]er3[kl]le";
        Decode de = new Decode();
        System.out.println(de.decode(code));
    }
}
