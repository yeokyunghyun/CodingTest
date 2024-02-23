/*
package algorithm_study._02_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _06_9252_LCS2_브루트포스 {
    private static ArrayList<Character> result;
    private static ArrayList<Character> tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr1[] = br.readLine().toCharArray();
        char arr2[] = br.readLine().toCharArray();
        result = new ArrayList<>();
        tmp = new ArrayList<>();

        dfs(arr1, arr2, 0, 0);

        System.out.println(result.size());
        for (Character c : result) {
            System.out.print(c);
        }

        String str = "asd";
        str.charAt
    }

    static void dfs(char arr1[], char arr2[],int index1, int index2) {
        if(tmp.size() > result.size()) {
            result = (ArrayList<Character>)tmp.clone();
        }
        for(int i = index1; i < arr1.length; ++i) {
            for(int j = index2; j < arr2.length; ++j) {
                if(arr1[i] == arr2[j]) {
                    tmp.add(arr1[i]);
                    dfs(arr1, arr2, i + 1, j + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
*/
