package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _004_비밀번호_찾기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        HashMap<String, String> siteAndPassword = new HashMap<>();

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            siteAndPassword.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < question; ++i) {
            String answer = br.readLine();
            if(siteAndPassword.containsKey(answer)) {
                System.out.println(siteAndPassword.get(answer));
            }
        }
    }
}
