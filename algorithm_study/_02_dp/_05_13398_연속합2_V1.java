package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _05_13398_연속합2_V1 {
    //빼는 거는 플러스일수는 없고 무조건 마이너스를 빼야 됨.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arrLength = arr.length;

        int answers[][] = new int[2][arrLength];

        answers[0][0] = 0;
        answers[1][0] = arr[0];

        int max = answers[1][0];
        for (int i = 1; i < arrLength; ++i) {
            answers[0][i] = Math.max(answers[0][i - 1] + arr[i], answers[1][i - 1]);
            answers[1][i] = Math.max(answers[1][i - 1] + arr[i], arr[i]);
            max = Math.max(max, Math.max(answers[0][i], answers[1][i]));
        }
        System.out.println(max);
    }
}
