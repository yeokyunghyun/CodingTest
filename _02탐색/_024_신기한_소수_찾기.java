package _02탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _024_신기한_소수_찾기 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int digit = 1;
        for (int i = 1; i <= N; ++i) {
            digit *= 10;
        }

        boolean[] primeNum = new boolean[digit];

        getPrimeNum(digit, primeNum);
        /*false인게 primeNum*/

        for (int i = 1; i <= 9; ++i) {
            if (primeNum[i]) continue;
            dfs(primeNum, i, 1);
        }
    }

    private static void getPrimeNum(int digit, boolean[] primeNum) {
        primeNum[0] = true;
        primeNum[1] = true;

        for (int i = 2; i <= Math.sqrt(digit); ++i) {
            if (primeNum[i]) continue;
            for (int j = i + i; j < digit; j += i) {
                primeNum[j] = true;
            }
        }
    }

    private static void dfs(boolean primeNum[], int num, int digit) {
        /*digit이 N이면 출력하고 return*/
        if (digit == N) {
            System.out.println(num);
            return;
        }
        /*1, 3, 7, 9 돌리면서 덧붙인게 primeNum이면 다음껄로 dfs 재귀*/
        num *= 10;

        if (!primeNum[num + 1]) {
            dfs(primeNum, num + 1, digit + 1);
        }
        if (!primeNum[num + 3]) {
            dfs(primeNum, num + 3, digit + 1);
        }
        if (!primeNum[num + 7]) {
            dfs(primeNum, num + 7, digit + 1);
        }
        if (!primeNum[num + 9]) {
            dfs(primeNum, num + 9, digit + 1);
        }

    }
}
