// Implement an algorithm to determine if a string has all unique characters.
public class Solution{
  public boolean isUniqueChars(String str){
    //Use a bucket to record of the characters in the string
    if(str.length()>256) 
      return false; //Assuming extended ASCII code
    boolean[] visited = new boolean[256];
    for(int i=0;i<str.length();i++){
      int idx = str.charAt(i);
      if(visited[idx])
        return false;
      visited[idx] = true;
    }
    return true;
  }
}
