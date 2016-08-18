public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public boolean stringPermutation(String A, String B) {
        // Write your code here
        int[] c = new int[256];
        for(int i=0;i<A.length();i++){
            int ch = (int)A.charAt(i);
            c[ch]++;
        }
        for(int i=0;i<B.length();i++){
            int x = (int)B.charAt(i);
            c[x]--;
        }
        for(int i=0;i<c.length;i++){
            if(c[i]!=0) return false;
        }
        return true;
    }
}
