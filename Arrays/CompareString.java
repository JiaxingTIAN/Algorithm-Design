public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(B == null || B.length() == 0)
            return true;
        
        if(A == null || A.length() == 0)
            return false;
            
        int[] ch = new int[26];
        for(char a:A.toCharArray()){
            ch[a - 'A']--;
        }
        for(char b:B.toCharArray()){
            ch[b - 'A']++;
        }
        for(int n:ch){
            if(n > 0)
                return false;
        }
        return true;
    }
}
