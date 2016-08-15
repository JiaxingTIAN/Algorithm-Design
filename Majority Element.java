//sort
//O(nlogn) - time; O(1) space
public class Solution{
  public int majorityElement(int[] elements){
    Arrays.sort(elements);
    return elements[elements.length/2];
  }
}
//DP
public class Solution{
  pulic int majorityElement(int[] elements){
    int count = 0;
    int most = elements[0];
    for(int n:elements){
      if(n==most) count++;
      else if(n==0){
        n++;
        most = n;
      }
      else
        n--;
    }
  return most;
}
