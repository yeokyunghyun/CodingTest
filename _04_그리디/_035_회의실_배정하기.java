package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _035_회의실_배정하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfConference = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start; //(1,2) (2,2) 두개가 나온 경우에는 (1,2) -> (2,2)가 돼야지 (2,2) -> (1,2)는 불가능 하기 때문에 이 코드가 필수이다.
            } else {
                return o1.end - o2.end;
            }
        }));

        for(int i = 1; i <= numOfConference; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Node(start, end));
        }

        int count = 0;
        int currEnd = -1;
        while(!pq.isEmpty()) {
            Node pollPq = pq.poll();
            int start = pollPq.start;
            int end = pollPq.end;

            if(start >= currEnd) {
                currEnd = end;
                ++count;
            }
        }
        System.out.println(count);

    }

    private static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
