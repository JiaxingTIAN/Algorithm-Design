public class Solution {
//String has no heading padding space, each word is separated with one space, inplace reverse
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);    //Reverse the whole string
        int start = 0;
        for(int i=0; i<s.length; i++){
            if(s[i] == ' '){    //reverse each word
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length-1);  //reverse the last word
    }
    public void reverse(char[]s, int l, int r){
        while(l < r){
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }
}
