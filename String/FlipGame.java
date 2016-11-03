public class Solution {
    public boolean canWin(String s) {
        return win(s);
    }
    public boolean win(String s){
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == '+' && s.charAt(i) == '+'){
                String tmp = s.substring(0, i-1) + "--" + s.substring(i+1);
                if(!win(tmp))
                    return true;
            }
        }
        return false;
    }
}
