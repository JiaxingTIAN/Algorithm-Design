public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        char[] c = s.toCharArray();
        int [] count = new int[256];
        for(char ch:c){
            count[ch]++;
        }
        boolean odd = false;
        for(int n:count){
            if(n%2 != 0 && odd)
                return false;
            if(n%2 != 0)
                odd = true;
        }
        return true;
    }
}


public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        Set<Character> set = new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
