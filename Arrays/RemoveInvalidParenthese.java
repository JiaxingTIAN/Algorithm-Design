//Generate all the valid parenthese with DFS/BFS 
//By either keep a parenthese or remove it. 
//Keep a counter increase when ( decrease when ) valid when counter == 0
//Time complexity(2^n)
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        dfs(res, s, "", 0);
        if(res.size() == 0){    //if no valid parenthese add empty string
            res.add("");
        }
        return res;
    }
    
    public void dfs(List<String> res, String s, String cur, int count){
        if(s.length() == 0){
            if(count == 0 && !res.contains(cur))
                res.add(cur);
            return;
        }
        if(s.charAt(0) == '('){
            dfs(res, s.substring(1), cur, count); //remove
            dfs(res, s.substring(1), cur+"(", count+1); //keep increase count
        }else if(s.charAt(0) == ')'){
            if(count > 0){
                dfs(res, s.substring(1), cur + ')', count-1);   //keep decrease count
            }
            dfs(res, s.substring(1), cur, count);
        }else{  //character
            dfs(res, s.substring(1), cur + s.charAt(0), count);
        }
        
    }
}
