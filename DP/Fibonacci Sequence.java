import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by star on 10/15/16.
 */
public class Solution {
    public static void main(String[] args){
        System.out.println("You can do it.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number:");
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(fib(n));
        System.out.println(fibIterate(n));
        System.out.println(naiveFib(n));
    }

    public static int fib(int n){   //Memoization
        //Time Complexity O(N); Space Complexity O(N) implicit stack comsuption => maximum recursion tree
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        return findFib(n, dp);
    }

    public static int findFib(int n, int[]dp){
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = findFib(n - 1, dp) + findFib(n - 2, dp);
        return dp[n];
    }

    public static int fibIterate(int n){
        //Time Complexity O(N); Space Complexity O(1)
        if(n <= 1)
            return n;
        int pre0 = 0;
        int pre1 = 1;
        int cur = 0;
        for(int i=2; i<=n; i++){
            cur = pre0 + pre1;
            pre0 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public static int naiveFib(int n){
        if(n <= 1)
            return n;
        return naiveFib(n - 1) + naiveFib(n - 2);
    }
    /********** Recursion *************
     *
     *                main()
     *                  |
     *                __5___
     *              /       \
     *             4_       3
     *            /  \     / \
     *           3   2    2  1
     *          / \ / \  / \
     *         2  11  0 1  0
     *        / \
     *       1  0
     *      Running Time Tn = T(n-1) T(n-2)
     *          Tn < 2T(n-1)
     *          Tn < 4T(n-2)
     *          Tn < 2^k T(n-k)  => k=n: T(0) = 1
     *          Tn < 2^n
     *      Time Complexity O(2^n)
     */
}

