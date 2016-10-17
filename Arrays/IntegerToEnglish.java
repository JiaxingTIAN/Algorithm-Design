public class Solution {
    //Add padding "" for zero
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        //Assume max integer billion
        if(num == 0){
            return "Zero";
        }
        String str = "";
        int thousands = 0;
        while(num > 0){ 
            if(num % 1000 != 0)
                str = helper(num%1000) + THOUSANDS[thousands] + " " + str;
            num /= 1000; //divide into group of 3 digits
            thousands++;
        }
        return str.trim();
    }
    
    public String helper(int num){
        if(num == 0)
            return "";
        if(num < 20)
            return LESS_THAN_20[num] + " ";
        if(num < 100)
            return TENS[num/10] + " " + helper(num%10);
        return LESS_THAN_20[num/100] + " Hundred " + helper(num%100);
    }
}
