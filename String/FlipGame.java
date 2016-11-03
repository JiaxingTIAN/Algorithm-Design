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
//Basic Recursion O(N!!) n * n-2 * n-4 * n-6
//Use a HashMap to store string and reuslt for that string
//<String, Boolean> Pair 
//Total case 2^n hence O(2^n)
public class Solution {
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return win(map, s);
    }
    public boolean win(Map<String, Boolean> map, String s){
        if(map.containsKey(s)) 
            return map.get(s);
        for(int i=0; i<s.length()-1; i++){
            if(s.startsWith("++", i)){
                String tmp = s.substring(0, i) + "--" + s.substring(i+2);
                if(!win(map, tmp)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
