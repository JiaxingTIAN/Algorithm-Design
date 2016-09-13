public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        String ans = "";
        if(source == null||source.length() == 0)
            return ans;
            
        int[] ch = new int[256];
        int len = Integer.MAX_VALUE;
        for(char c:target.toCharArray())
            ch[c]++;
        
        for(int i=0, j=0; i<source.length(); i++){
            while(j < source.length() && !valid(ch)){
                ch[source.charAt(j++)]--;
            }
            if(valid(ch) && len > (j-i)){
                len = j-i;
                ans = source.substring(i, j);
            }
            ch[source.charAt(i)]++;
        }
        return ans;
    }
    
    public boolean valid(int[] ch){
        for(int n:ch)
            if(n > 0)   return false;
        return true;
    }
}
