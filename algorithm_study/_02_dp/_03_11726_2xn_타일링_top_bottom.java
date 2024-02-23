package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_11726_2xn_타일링_top_bottom {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long answer[] = new Long[N + 1];
        answer[0] = 1L;
        answer[1] = 1L;

        long result = dp(answer, N);
        System.out.println(result);
    }

    public static long dp(Long answer[], int N) {
        if(answer[N] == null) {
            answer[N] = (dp(answer, N - 1) + dp(answer, N - 2)) % 10007;
        }
        return answer[N];
    }
}
