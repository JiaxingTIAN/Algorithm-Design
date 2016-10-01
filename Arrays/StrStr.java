class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null){
            return -1;
        }
        if(target.length() == 0)
            return 0;
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        for(int i=0; i<=s.length - t.length; i++){
            int j = 0;
            for(j=0; j<t.length; j++){
                if(s[i + j] != t[j])
                    break;
            }
            if(j == t.length){
                return i;
            }
        }
        return -1;
    }
}
