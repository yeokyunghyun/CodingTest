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
        int result = 0;
        int divNumber[] = new int[divNum];

        /*N개만큼의 숫자 나열하기*/
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = 0;
        total = arr[0] % divNum;
        ++divNumber[total];

        for (int i = 1; i < arr.length; i++) {
            total = (total + arr[i]) % divNum;
            ++divNumber[total];
        }

        result += divNumber[0];

        for(int i = 0; i < divNum; ++i) {
            result += totalNum(divNumber[i]);
        }

        System.out.println(result);

    }

    private static int totalNum(int i) {
        if(i == 0 || i == 1) return 0;
        return ((i - 1) * (i)) / 2;
    }
}
