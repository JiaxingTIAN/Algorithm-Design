public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while (index1 >= 0 || index2 >= 0) {
            sum = carry;
            if (index1 >= 0) {
                sum += num1.charAt(index1) - '0';
                index1--;
            }
            if (index2 >= 0) {
                sum += num2.charAt(index2) - '0';
                index2--;
            }
            carry = sum / 10;
            sum = sum % 10;
            res.append(sum);
        }
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
