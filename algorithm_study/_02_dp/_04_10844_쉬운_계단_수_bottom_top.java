package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_10844_쉬운_계단_수_bottom_top {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answers[] = new int[10];

        for(int i = 1; i <= 9; ++i) {
            answers[i] += 1;
        }

        for(int i = 2; i <= N; ++i) {
            int temp[] = answers.clone();

            for(int j = 1; j <= 8; ++j) {
                answers[j] = (temp[j - 1] + temp[j + 1]) % 1000000000;
            }
            answers[0] = temp[1];
            answers[9] = temp[8];
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += answers[i];
            result %= 1000000000;
        }

        System.out.println(result);
    }
}
