package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01_1463_1로_만들기_bottom_top {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        arr[1] = 0;

        for(int i = 2; i <= N; ++i) {
            arr[i] = arr[i - 1] + 1;

            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i / 3] + 1, arr[i]);
            }
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
            }
        }

        System.out.println(arr[N]);
    }
}
