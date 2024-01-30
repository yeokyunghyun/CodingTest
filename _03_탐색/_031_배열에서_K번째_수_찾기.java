package _03_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _031_배열에서_K번째_수_찾기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            int total = 0;

            for(int i = 1; i <= N; ++i) {
                total += Math.min(N, mid / i);
            }

            if(total >= k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
