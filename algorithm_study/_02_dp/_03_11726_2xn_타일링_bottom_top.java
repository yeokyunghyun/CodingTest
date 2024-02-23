package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_11726_2xn_타일링_bottom_top {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer[] = new long[N + 1];
        answer[0] = 1;
        answer[1] = 1;

        for(int i = 2; i <= N; ++i) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 10007;
        }

        System.out.println(answer[N]);
    }
}
