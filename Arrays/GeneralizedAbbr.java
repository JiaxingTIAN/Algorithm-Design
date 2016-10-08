public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        dfs(res, word, "", 0, 0);
        return res;
    }
    // Each character can be abbrevatied or kept => 2^N total result
    // Keep a count of current abbrevate number, reset when choose to keep the character
    // pos is the idx of current character in the string
    public void dfs(List<String> res, String word, String cur, int pos, int count){
        if(pos == word.length()){   //Reach the end of the string
            if(count > 0){          //If previous has abbrevations not added
                cur += count;  //Append to the string
            }
            res.add(cur);
            return;
        }
        //Abbrevate the character increase the count keep cur
        dfs(res, word, cur, pos+1, count+1);
        //Keep the character, append the count and character to the cur
        if(count > 0){  //if previous count > 0 add the count
            dfs(res, word, cur + count + word.charAt(pos), pos + 1, 0);
        }else{
            dfs(res, word, cur + word.charAt(pos), pos + 1, 0);
        }
    }
}
