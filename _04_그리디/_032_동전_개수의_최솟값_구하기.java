package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _032_동전_개수의_최솟값_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int totalCoin = 0;

        int i = N - 1;
        while(i >= 0 && total > 0) {
            if (total / arr[i] >= 1) {
                int requiredCoin = (total / arr[i]);
                totalCoin += requiredCoin;
                int minusMoney = requiredCoin * arr[i];
                total -= minusMoney;
            }
            --i;
        }

        if(total > 0) System.out.println("불가능");
        else {
            System.out.println(totalCoin);
        }
    }
}
