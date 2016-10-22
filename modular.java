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
    private static final int M = 1337;

    public int normalPow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0)
                result = result * a % M;
            a = a * a % M;
            b /= 2;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        a %= M;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % M;
            a = normalPow(a, 10);
        }
        return result;
    }
}
