package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _04_10844_쉬운_계단_수_top_bottom {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer answers[][] = new Integer[N + 1][10];
        answers[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            answers[1][i] = 1;
        }

        int result = 0;
        for(int i = 0; i < 10; ++i) {
            result += dp(answers, N, i);
            result %= 1000000000;
        }

        System.out.println(result);
    }

    public static int dp(Integer answers[][], int digit, int index) {

        if(answers[digit][index] == null) {
            if(index == 0) {
                answers[digit][index] = dp(answers, digit - 1, index + 1);
            }
            else if(index == 9) {
                answers[digit][index] = dp(answers, digit - 1, index - 1);
            }
            else {
                answers[digit][index] = (dp(answers, digit - 1, index - 1) + dp(answers, digit - 1, index + 1)) % 1000000000;
            }
        }

        return answers[digit][index];
    }
}
