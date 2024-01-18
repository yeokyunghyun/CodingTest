package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//모든 2개의 경우의 수를 세는 방법은 아님
public class _007_주몽의_명령 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int stockArr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(stockArr);

        int left = 0;
        int right = N - 1;
        int count = 0;
        while(left != right) {
            int total = stockArr[left] + stockArr[right];
            if(total == M) {
                ++count;
                --right;
            } else if(total < M) {
                ++left;
            } else {
                --right;
            }
        }
        System.out.println(count);
    }
}
