package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _001_회사에_있는_사람 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<String> ts = new TreeSet<>();

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String message = st.nextToken();

            if(message.startsWith("e")) {
                ts.add(name);
            } else {
                ts.remove(name);
            }
        }

        Iterator<String> iter = ts.descendingIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
