public class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=str.length-1; i>=0; i--){
            sb.append(str[i] + " ");
        }
        return sb.toString().trim();
    }
    public String reverseWords2(String s){
        String[]str = s.trim().split(" +");
        Collections.reverse(Arrays.asList(str));
        return String.join(" ", str);
    }
}
