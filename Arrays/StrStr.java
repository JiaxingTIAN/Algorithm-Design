public class Solution{
  public int strStr(String source, String target){
    if(source == null || target == null){
      return -1;
     }
     char[] s = source.toCharArray();
     char[] t = target.toCharArray();
     for(int i=0; i<s.length - t.length; i++){
      int j = 0;
      for(; j<t.length; j++){
        if(s[i+j] != t[j])
          break;
      }
      if(j == t.length)
        return i;
     }
     return -1;
  }
}
