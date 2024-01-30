package _03_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _030_블루레이_만들기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];

        int i = 0;
        int start = 0;
        int end = 0;
        while(st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > start) start = arr[i];
            end += arr[i];
            ++i;
        }

        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for(int j = 0; j < N; ++j) {
                if(sum + arr[j] > mid) {
                    ++count;
                    sum = 0;
                }

                sum += arr[j];
            }

            if(sum != 0) {
                sum = 0;
                ++count;
            }

            if(count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
