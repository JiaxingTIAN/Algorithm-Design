public class Solution{
  public List<String> restore(String s){
    int len = s.length();
    List<String> res = new LinkedList();
    for(int i=1;i<4 && i<len-2;i++){
      for(int j=i+1;j<i+4 && j<len-1;j++){
        for(int k=j+1;k<j+4 && k<len;K++){
          String s1=s.substring(0,i), s2=s.substring(i,j), s3 = s.substring(j,k),s4=s.substring(k,len);
          if(valid(s1)&&valid(s2)&&valid(s3)&&valid(s4))
            res.add(s1+"."+s2+"."+s3+"."+s4);
        }
      }
    }
    return res;
  }
  public boolean valid(String s){
    if(s.length()>3||s.length==0||(s.charAt(0)=='0'&&s.length>1)||Integer.parseInt(s)>255)
      return false;
    return true;
  }
}
//DFS
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList();
        dfs(s,res,"",0,0);
        return res;
    }
    public void dfs(String s, List res, String str, int idx, int count){
        if(count==4 && idx==s.length()){
            res.add(str);
            return;
        }
        if(count>3) return;
        for(int i=1;i<4;i++){
            if(idx+i>s.length()) break;
            String add = s.substring(idx,idx+i);
            if((add.charAt(0)=='0'&& add.length()>0)||Integer.parseInt(add)>255) continue;
            dfs(s, res, str+add+(count==3?"":"."),idx+i,count+1);
        }
    }
}
