public class Solution {
//Time Complexity O(n)
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() ==0){
            return "";
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        int[] ch = new int[256];  //Assume ASCII code
        for(char c:t.toCharArray()){
            ch[c]++;
        }
        //Sliding window i - j
        for(int i=0, j=0; i<s.length(); i++){
            while(j < s.length() && !valid(ch)){
                //continue increase window end while not valid
                ch[s.charAt(j++)]--;    //decrease the count
            }
            //if escape with valid update the result
            if(valid(ch) && j - i < min){
                min = j - i;
                res = s.substring(i, j);
            }
            //move start forward one step
            ch[s.charAt(i)]++;
        }
        return res;
    }
    
    public boolean valid(int[] ch){
        for(int n:ch){
            if(n > 0)
                return false;
        }
        return true;
    }
}
