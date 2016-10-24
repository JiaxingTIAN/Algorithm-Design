public class Solution {
    public String rearrangeString(String str, int k) {
        if(str == null || str.length() == 0)
            return "";
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        int [] count = new int[26]; //Count of character
        int [] pos = new int[26];   //Next valid position
        for(char a:str.toCharArray()){
            count[a - 'a']++;
        }
        for(int i=0; i<n; i++){
            int next = findNext(count, pos, i);
            if(next == -1) return "";
            count[next]--;
            pos[next] = i + k;  //Update next valid position
            sb.append((char)('a'+next));
        }
        return sb.toString();
    }
    
    public int findNext(int[]count, int[]pos, int idx){
        int res = -1;
        int max = 0;
        for(int i=0; i<26; i++){
            if(count[i] > max && pos[i] <= idx){    //Find the character with most count 
                res = i;                            //And current position >= valid position
                max = count[i];
            }
        }
        return res; //return the character index
    }
}
