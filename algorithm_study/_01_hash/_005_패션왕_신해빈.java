package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _005_패션왕_신해빈 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testcase; ++t) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, ArrayList<String>> collection = new HashMap<>();

            for(int i = 1; i <= N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();

                if(!collection.containsKey(key)) {
                    collection.put(key, new ArrayList<>());
                    collection.get(key).add(value);
                } else {
                    collection.get(key).add(value);
                }
            }
            int total = 1;

            for(String key : collection.keySet()) {
                total *= collection.get(key).size() + 1;
            }

            System.out.println(total - 1);
        }
    }
}
