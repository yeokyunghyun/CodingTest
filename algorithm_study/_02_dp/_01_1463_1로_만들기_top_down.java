package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_1463_1로_만들기_top_down {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer dp[] = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        int result = recursion(dp, N);
        System.out.println(result);
    }
    public static int recursion(Integer dp[], int N) {
        if(dp[N] == null) {
            if(N % 6 == 0) {
                dp[N] = Math.min(recursion(dp, N / 3), Math.min(recursion(dp, N / 2), recursion(dp, N - 1))) + 1;
            }
            else if (N % 3 == 0) {
                dp[N] = Math.min(recursion(dp, N / 3), recursion(dp, N - 1)) + 1;
            }
            else if (N % 2 == 0) {
                dp[N] = Math.min(recursion(dp, N / 2), recursion(dp, N - 1)) + 1;
            }
            else {
                dp[N] = recursion(dp, N - 1) + 1;
            }
        }
        return dp[N];
    }
}
