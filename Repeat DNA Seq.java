public class Solution{
  public int encode(String s){
    int sum = 0;
    for(int i=0;i<s.length;i++){
      if(s.charAt(i)=='A') sum *= 4;
      else if(s.charAt(i)=='C') sum = sum*4+1;
      else if(s.charAt(i)=='G') sum = sum*4+2;
      else sum=sum*4+3;
    }
    return sum;
  }
  public List<String> findRepeatDnaSequences(String s){
    HashSet<Integer> hash = new HashSet<Integer>();
    HashSet<String> dna = new HashSet();
    for(int i=9;i<s.length;i++){
      String sub = s.substring(i-9,i+1);
      int code = encode(sub);
      if(hash.contains(code)) dna.add(sub);
      else hash.add(code);
    }
    List<String> result = new LinkedList();
    for(String str:dna) result.add(str);
    return result;
  }
