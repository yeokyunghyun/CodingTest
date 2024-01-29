package _02탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _026_DFS와_BFS_프로그램 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(st.nextToken());

        ArrayList[] arr = new ArrayList[N + 1];

        for(int i = 1; i <= N; ++i) {
            arr[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
        boolean visited[] = new boolean[N + 1];

        dfs(arr, visited, startPoint);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(arr, visited, startPoint);
    }

    private static void dfs(ArrayList<Integer> arr[], boolean visited[], int num) {
        visited[num] = true;
        System.out.print(num + " ");
        for(int linkedNum : arr[num]) {
            if(!visited[linkedNum]) {
                dfs(arr, visited, linkedNum);
            }
        }
    }

    private static void bfs(ArrayList<Integer> arr[], boolean visited[], int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while(!queue.isEmpty()) {
            int pollNum = queue.poll();
            System.out.print(pollNum + " ");
            for (int linkedNum : arr[pollNum]) {
                if (!visited[linkedNum]) {
                    queue.add(linkedNum);
                    visited[linkedNum] = true;
                }
            }
        }
    }
}
