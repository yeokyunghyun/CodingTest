package 자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _005_나머지_합_구하기 {
    public static void main(String[] args)throws IOException {
        /*N과 M적기*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int divNum = Integer.parseInt(st.nextToken());
        /*N개만큼의 숫자 나열하기*/
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        for(int i = 1; i <= arr.length; ++i) {
            
        }
    }
}
