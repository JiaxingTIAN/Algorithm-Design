public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        //Use regex in java => O(N) time
        // Turn he12ow3 to he.{12}ow.{3} capture the integer turn into count of .
        
        //return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}")); //Cannot start with 0 "[1-9]\d*" => ".{$0}"
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()){
            //Case 1: abbr have the same character both forward one
            if(word.charAt(i) == abbr.charAt(j)){
                i++;
                j++;
                continue;
            }
            //Case 2: Not same character and abbr is not digit or start with 0, return false
            if(abbr.charAt(j) <= '0' || abbr.charAt(j) > '9'){
                return false;
            }
            //Case 3: abbr contains digits convert to count
            int start = j;
            while(j < abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j) <='9'){
                j++;
            }
            int count = Integer.parseInt(abbr.substring(start, j)); //Integer.valueOf(abbr.substring(start, j))
            i += count; //i forward by the count
        }
        return i == word.length() && j == abbr.length();
    }
}
