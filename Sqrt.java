public class Solution{
  public int sqrt(int x){
    if(x==0) return 0;
    int low = 1, high = x;
    while(high-low>1){  //prevent dead loop for 1,2 
      int mid = low + (high - low)>>1;  //prevent int overflow
      if(mid>x/mid) high = mid;
      else low = mid;
    }
    return low;
  }
}
