package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_2193_이친수_bottom_top {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long dp[] = new long[2];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; ++i) {
            long zeroCnt = dp[0];
            long oneCnt = dp[1];

            dp[0] = zeroCnt + oneCnt;
            dp[1] = zeroCnt;
        }

        System.out.println(dp[0] + dp[1]);

       /* int result[] = new int[N + 1];
        result[0] = 0;
        result[1] = 1;

        for(int i = 2; i <= N; ++i) {
            result[i] = result[i - 1] + result[i - 2];
        }

        for(int i = 2; i <= N; ++i) {
            System.out.println("N이" + i + "일 때 답은" + result[i] + "이다");
        }*/
    }
}
