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
    		DFS(res, s, i + 1, rmL - 1, rmR, open, sb); //Remove firset
    		DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c));   //Keep
    		
    	} else if(c == ')') {
    		DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
    		DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
    		
    	} else {    //Normal character append 
    		DFS(res, s, i + 1, rmL, rmR, open, sb.append(c)); 
    	}
    	//Rest for futher backtrack
    	sb.setLength(len);
    }
}

//Iterate two times 
//From left to right to remove ), if count left < 0 iterate through last remove index to current and try every possible solution
//From right to left to remove (
public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[]{'(', ')'});
    return ans;
}

public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
    for (int stack = 0, i = last_i; i < s.length(); ++i) {
        if (s.charAt(i) == par[0]) stack++;
        if (s.charAt(i) == par[1]) stack--;
        if (stack >= 0) continue;
        for (int j = last_j; j <= i; ++j)
            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
        return;
    }
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') // finished left to right
        remove(reversed, ans, 0, 0, new char[]{')', '('});
    else // finished right to left
        ans.add(reversed);
}

//For one valid solution
   public static String removeParenthese(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        //from left to right to remove )
        for(char c:s.toCharArray()){
            if (c == '('){
                left++;
                sb.append(c);
            }else if(c == ')'){ //skip ) when left == 0
                if(left > 0){
                    left--;
                    sb.append(c);
                }
            }else {
                sb.append(c);
            }
        }
        //From right to left to remove (
        if(left == 0) {
            return sb.toString();
        }
        s = sb.toString();
        sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == ')') {
                right++;
                sb.append(c);
            }else if(c == '('){
                if(right > 0){
                    right--;
                    sb.append(c);
                }
            }else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
