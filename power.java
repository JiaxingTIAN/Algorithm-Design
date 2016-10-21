//Recursion
public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){  //Invert at the first time => last of recursion
            return 1/myPow(x, -n);
        }
        if(n%2==0){   //Even
            return myPow(x*x, n/2);
        }
        return x*myPow(x, n-1); //Odd
    }
}

public class Solution {
    public double myPow(double x, int n){
        if(n == 0){ //Base case n = 0 return 1
            return 1;
        }
        if(n < 0){  //if n is negative invert x
            x = 1/x;
            n = -n;
        }
        double ans = 1;
        while(n > 0){
            if(n%2 == 1)    //if n is odd
                ans *= x;   //mul the extra x
            x *= x;         //double x
            n >>= 1;        //n = n/2
        }
        return ans;
    }
}
