package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _06_9252_LCS2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr1[] = br.readLine().toCharArray();
        char arr2[] = br.readLine().toCharArray();

        int map[][] = new int[arr2.length + 1][arr1.length + 1];

        for(int i = 1; i < map.length; ++i) {
            for(int j = 1; j < map[0].length; ++j) {
                if(arr2[i - 1] == arr1[j - 1]) {
                    map[i][j] = Math.max(map[i - 1][j - 1] + 1, Math.max(map[i - 1][j], map[i][j - 1]));
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        Stack<Character> result = new Stack<>();
        int endNumber = map[map.length - 1][map[0].length - 1];
        int y = map.length - 1;
        int x = map[0].length - 1;

        while(endNumber != 0) {
            if(arr2[y - 1] == arr1[x - 1]) {
                result.add(arr1[x - 1]);
                y = y - 1;
                x = x - 1;
                endNumber -= 1;
            } else {
                if(map[y][x] == map[y][x -1]) {
                    x = x - 1;
                } else {
                    y = y - 1;
                }
            }
        }

        System.out.println(result.size());
        while(!result.empty()) {
            System.out.print(result.pop());
        }

    }
}
