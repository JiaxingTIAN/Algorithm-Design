public static int module(int x, int n, int m){
        if (n == 0)
            return 1;
        if (n%2 == 0){
            int tmp = module(x, n/2, m);
            return tmp * tmp % m;
        }else{
            return (x%m * module(x, n-1, m))%m;
        }
    }

/*
a ^ 1234567 %M = (a^1234560%M * a^7%M) %M = (a^123456%M)^10 %M * a^7%M %M

= (a^10%M)^123456%M * (a^7%M) %M
start from last digit: res * (a^7 %M) %M 
*/

public class Solution {
    private final int m = 1337;
    public int superPow(int a, int[] b) {
        // a^123 %M = (a^120%M * a^3%M)%M = (a^10%M)^12%M * (a^3%M) %M = a1^10%M * (a1^2%M) %M * (a^3%M)%M
        a %= m; //Avoid overflow
        int res = 1;
        for(int i=b.length-1; i>=0; i--){
            res = res * pow(a, b[i])%m;
            a = pow(a, 10);
        }
        return res;
    }
    //pow(a, b) => a^b % M
    //a*b %M = (a%M * b%M) %M
    //a^3 % M => (a%M * a^2%M) %M
    //a^4 % M => (a^2%M * a^2%M) %M %M
    public int pow(int a, int n){
        int res = 1;
        while(n > 0){
            if(n%2 == 1)
                res = res*a%m;
            a = a*a%m;
            n >>= 1;
        }
        return res;
    }
}
