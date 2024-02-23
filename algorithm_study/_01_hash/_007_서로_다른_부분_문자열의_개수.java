package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _007_서로_다른_부분_문자열의_개수 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i = 1; i <= str.length(); ++i) {
            for(int j = 0; j < str.length() - i + 1; ++j) {
                set.add(str.substring(j, j + i));
            }
        }

        System.out.println(set.size());
    }
}
