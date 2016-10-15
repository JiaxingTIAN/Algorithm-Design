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

//To remove minimum number of parenthese 
//Keep a count of maximum left parenthese that is valid 
//Add the result when current left parenthese count == max 
public class Solution {
    int max = 0;
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null){
            return res;
        }
        dfs(res, s, "", 0, 0);

        return res;
    }
    
    public void dfs(List<String> res, String s, String cur, int count, int left){
        if(s.length() == 0){
            if(count == 0){
                max = Math.max(left, max);
                if(left == max && !res.contains(cur))
                    res.add(cur);
            }
            return;
        }
        if(s.charAt(0) == '('){
            dfs(res, s.substring(1), cur+"(", count+1, left+1); //keep increase count, must reach end first to update max
            dfs(res, s.substring(1), cur, count, left); //remove
        }else if(s.charAt(0) == ')'){
            if(count > 0){
                dfs(res, s.substring(1), cur + ')', count-1, left);   //keep decrease count
            }
            dfs(res, s.substring(1), cur, count, left);
        }else{  //character
            dfs(res, s.substring(1), cur + s.charAt(0), count, left);
        }
        
    }
}


//Optimization

public class Solution {
    int max = 0;
    public List<String> removeInvalidParentheses(String s) {
       Set<String> res = new HashSet<>();
    	int rmL = 0, rmR = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') rmL++;
    	    if(s.charAt(i) == ')') {
    	    	if(rmL != 0) rmL--;
    	    	else rmR++;
    	    }
    	}
    	DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);	
    }
    
    public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
        	res.add(sb.toString());
        	return;
        }
        if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) return;
        
        char c = s.charAt(i);
        int len = sb.length();
       
    	if(c == '(') {
    		DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
    		DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c)); 
    		
    	} else if(c == ')') {
    		DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
    		DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
    		
    	} else {
    		DFS(res, s, i + 1, rmL, rmR, open, sb.append(c)); 
    	}
    	
    	sb.setLength(len);
    }
}
