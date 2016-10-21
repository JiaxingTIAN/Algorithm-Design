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
