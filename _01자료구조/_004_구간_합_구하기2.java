package _01자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _004_구간_합_구하기2 {
    private static int getValue(int[][] a, int[][] s, int i, int j) {
        return a[i - 1][j - 1] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tryNum = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int s[][] = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < n + 1; j++) {
                s[i][j] = getValue(a, s, i, j);
            }
        }

        for (int i = 0; i < tryNum; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 =  Integer.parseInt(st.nextToken());
            int x1 =  Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int result = s[y2][x2] - s[y1 - 1][x2] - s[y2][x1 -1] + s[y1 - 1][x1 - 1];
            System.out.println(result);
        }

    }
}
