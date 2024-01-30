package _03_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _028_트리의_지름_구하기 {

    public static int Max = 0;
    public static int startPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> arr[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i) {
            arr[i] = new ArrayList<Node>();
        }

        for (int i = 1; i <= N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int e = Integer.parseInt(st.nextToken());
                if (e == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                arr[s].add(new Node(e, distance));
                arr[e].add(new Node(s, distance));
            }
        }

        boolean visited[] = new boolean[N + 1];


        bfs(arr, visited, 2);
        Arrays.fill(visited, false);
        bfs(arr, visited, startPoint);

        System.out.println(Max);
    }

    private static void bfs(ArrayList<Node> arr[], boolean visited[], int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int pollNum = pollNode.node;
            int pollDis = pollNode.distance;


            if (pollDis > Max) {
                Max = pollDis;
                startPoint = pollNum;
            }

            for (Node linkedNode : arr[pollNum]) {
                if (!visited[linkedNode.node]) {
                    queue.add(new Node(linkedNode.node, pollDis + linkedNode.distance));
                    visited[linkedNode.node] = true;
                }
            }

        }
    }

    private static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
