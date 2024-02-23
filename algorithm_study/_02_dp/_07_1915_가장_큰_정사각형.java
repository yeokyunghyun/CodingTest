package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _07_1915_가장_큰_정사각형 {
    private static int map[][];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[y][x];

        for(int i = 0; i < y; ++i) {
            char tmp[] = br.readLine().toCharArray();
            for(int j = 0; j < tmp.length; ++j) {
                map[i][j] = tmp[j] - '0';
            }
        }

        for(int i = 0; i < y; ++i) {
            for(int j = 0; j < x; ++j) {
                if(map[i][j] == 0) {
                    continue;
                }
                if(!isInRange(i - 1, j) || !isInRange(i, j - 1) || !isInRange(i - 1, j - 1)) {
                    continue;
                }
                map[i][j] = Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1])) + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < y; ++i) {
            for(int j = 0; j < x; ++j) {
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.println(max * max);
    }



    private static boolean isInRange(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0;
    }
}
