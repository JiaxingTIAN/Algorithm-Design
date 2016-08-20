public class Solution{
  public String mulString(String num1, String num2){
    int l1 = num1.length(), l2 = num2.length();
    int[] res = new int[l1+l2];
    for(int i=l1-1;i>=0;i--){
      for(int j=l2-1;j>=0;j--){
        int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        int sum = mul + res[i+j+1];
        res[i+j] += sum/10;
        res[i+j+1] = sum%10;
      }
    }
    StringBuilder str = new StringBuilder();
    for(int i:res)
      if(!(i==0&&str.length==0))
        str.append(i);
    return str.length()==0? "0" : str.toString();
  }
}
