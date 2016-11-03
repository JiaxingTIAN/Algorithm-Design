public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while(idx1 >= 0 || idx2 >= 0){  //Any of the string still have digits
            sum = carry;    //add the carry from previous sum
            if(idx1 >= 0){
                sum += num1.charAt(idx1--) - '0';
            }
            if(idx2 >= 0){
                sum += num2.charAt(idx2--) - '0';
            }
            carry = sum / 10;
            sum = sum % 10;
            str.append(sum);
        }
        //Final check if there still has remaining carry
        if(carry > 0){
            str.append(carry);
        }
        return str.reverse().toString();
    }
}
