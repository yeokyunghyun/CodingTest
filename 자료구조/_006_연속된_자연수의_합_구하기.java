package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _006_연속된_자연수의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 0;
        int right = 1;

        int count = 0;

        int sum[] = new int[N];
        for (int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1] + i;
        }

        int compareNum = 0;

        /*compareNum을 먼저계산해야 오류가 안남*/
        while (right < N) {
            compareNum = sum[right] - sum[left];

            if (compareNum < N) {
                ++right;
            } else if (compareNum == N) {
                ++count;
                ++right;
            } else {
                ++left;
            }
        }

        System.out.println(count + 1);
    }
}
