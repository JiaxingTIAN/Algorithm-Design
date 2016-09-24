public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int[] c = new int[256];
        for(int i=0; i<s.length(); i++){
            c[s.charAt(i)]++;
            c[t.charAt(i)]--;
        }
        for(int n:c){
            if(n!=0){
                return false;
            }
        }
        return true;
    }
};
