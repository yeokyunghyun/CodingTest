package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/* a도 idx1부터 할 수는 없는가 ?*/
/* A라는 배열을 굳이 정의할 필요는 없다 */

public class _003_구간_합_구하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int [] s = new int[numCnt + 1];

        for(int i = 1; i <= numCnt; ++i) {
            int aValue = Integer.parseInt(st.nextToken());
            s[i] = s[i - 1] + aValue;
        }

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int firstRange = Integer.parseInt(st.nextToken());
            int lastRange = Integer.parseInt(st.nextToken());

            int result = s[lastRange] - s[firstRange - 1];

            System.out.println(result);
        }
    }
}
