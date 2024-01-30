package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _032_동전_개수의_최솟값_구하기 {

    public static int totalCoin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(arr, N - 1, total, 0);
        System.out.println(totalCoin);
    }

    private static void dfs(int arr[], int index, int total, int coinNum) {
        if(index == -1) return;
        if(total == 0) {
            if(totalCoin > coinNum) totalCoin = coinNum;
        }

        for(int i = index; i >= 0; --i) {
            if(total / arr[i] >= 1) {
                int plusCoin = total / arr[i];
                int minusMoney = plusCoin * arr[i];
                dfs(arr, index - 1, total - minusMoney, coinNum + plusCoin);
            }
        }
    }
}
