/*
For n stairs, each time you can clime 2 or 3 steps, how many solutions to reach n.

Brute Force: O(2^n) for each step - choose 2 or 3 total n/2 steps hence 2^n

DP: think from the end point
dp(10) = dp(7) + dp(8) 
dp(i) = dp(i-2) + dp(i-3)
Program from the start 
*/
public int climeStair(int n){
  if(n < 0) 
    return -1;
  int []count = new int[n+1];
  count[0] = 1;
  for(int i=0; i<=n; i++){
    if(i>=2) 
      count[i] += count[i-2];
    if(i>=3)
      count[i] += count[i-3];
  }
  return count[n];
}
