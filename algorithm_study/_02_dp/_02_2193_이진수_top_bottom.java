package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_2193_이진수_top_bottom {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long dp[] = new long[N + 1];

        dp[0] = 0;
        dp[1] = 1;

        long result = recursion(dp, N);
        System.out.println(result);
    }

    public static long recursion(long dp[], int N) {
        if(N == 0) {
            return 0;
        }
        if(N == 1) {
            return 1;
        }
        if(dp[N] > 0) {
            return dp[N];
        }

        dp[N] = recursion(dp, N - 1) + recursion(dp, N - 2);

        return dp[N];
    }
}
