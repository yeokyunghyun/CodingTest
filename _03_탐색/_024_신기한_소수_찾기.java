package _03_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _024_신기한_소수_찾기 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int digit) {
        /*digit이 N이면 출력하고 return*/
        if (digit == N) {
            System.out.println(num);
            return;
        }
        /*1, 3, 7, 9 돌리면서 덧붙인게 primeNum이면 다음껄로 dfs 재귀*/
        num *= 10;

        if (isPrime(num + 1)) {
            dfs(num + 1, digit + 1);
        }
        if (isPrime(num + 3)) {
            dfs(num + 3, digit + 1);
        }
        if (isPrime(num + 7)) {
            dfs(num + 7, digit + 1);
        }
        if (isPrime(num + 9)) {
            dfs(num + 9, digit + 1);
        }
    }

    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); ++i) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
