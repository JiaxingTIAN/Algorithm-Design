public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0 || maxWidth == 0){
            res.add("");
            return res;
        }
            
        for(int i=0, w; i < words.length; i = w){
            int len = -1;   //Skip the space for last word
            //Check for how many words can fit into the line
            for(w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++){
                len += words[w].length() + 1;   //Increaser the length if still valid
            }
            int space = 1, extra = 0;
            if(w != i+1 && w != words.length){  //Not only one word nor the last word
                space = (maxWidth - len)/(w - i - 1) + 1;   //Default is one
                extra = (maxWidth - len)%(w - i - 1);
            }
            StringBuilder sb = new StringBuilder(words[i]);
            for(int j=i+1; j<w; j++){
                for(int k=0; k<space; k++)
                    sb.append(" ");
                if(extra-- > 0)
                    sb.append(" ");
                sb.append(words[j]);
            }
            int remain = maxWidth - sb.length();
            while(remain-- > 0){
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
  
    }
}
