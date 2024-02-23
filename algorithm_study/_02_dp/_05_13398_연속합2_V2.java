package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _05_13398_연속합2_V2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = arr[0];

        int answerLeft[] = new int[arr.length];
        answerLeft[0] = arr[0];

        for(int i = 1; i < answerLeft.length; ++i) {
            answerLeft[i] = Math.max(answerLeft[i - 1] + arr[i], arr[i]);
            max = answerLeft[i] > max ? answerLeft[i] : max;
        }

        int answerRight[] = new int[arr.length];
        answerRight[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; --i) {
            answerRight[i] = Math.max(answerRight[i + 1] + arr[i], arr[i]);
        }

        for(int i = 1; i < arr.length - 1; ++i) {
            max = answerLeft[i - 1] + answerRight[i + 1] > max ? answerLeft[i - 1] + answerRight[i + 1] : max;
        }

        System.out.println(max);
    }
}
