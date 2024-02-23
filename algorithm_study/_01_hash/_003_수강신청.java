package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _003_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int possibleNum = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 1; i <= N; ++i) {
            //입력한 순서 유지 + 탐색 용이(중복된 것 탐지)
            String studentId = br.readLine();
            if (set.contains(studentId)) {
                set.remove(studentId);
                set.add(studentId);
            } else {
                set.add(studentId);
            }
        }

        Iterator<String> iter = set.iterator();
        for(int i = 0; i < possibleNum; ++i) {
            if(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }
    }
}
