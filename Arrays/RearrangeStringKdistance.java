public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0)
            return "";
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        int [] count = new int[26];
        int [] pos = new int[26];
        for(char a:str.toCharArray()){
            count[a - 'a']++;
        }
        for(int i=0; i<n; i++){
            int next = findNext(count, pos, i);
            if(next == -1) return "";
            count[next]--;
            pos[next] = i + k;
            sb.append((char)('a'+next));
        }
        return sb.toString();
    }
    
    public int findNext(int[]count, int[]pos, int idx){
        int res = -1;
        int max = 0;
        for(int i=0; i<26; i++){
            if(count[i] > max && pos[i] <= idx){
                res = i;
                max = count[i];
            }
        }
        return res;
    }
}
