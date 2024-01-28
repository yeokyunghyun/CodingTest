package _02탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class _023_연결_요소의_개수_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr[] = new ArrayList[N + 1];
        for(int i = 1; i <= N; ++i) {
            arr[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        int count = 0;
        /*for문으로 돌면서 dfs확인*/
        for(int i  = 1; i <= N; ++i) {
            if(!visited[i]) {
                dfs(arr, visited, i);
                ++count;
            }
        }
        /*결과 출력*/
        System.out.println(count);
    }

    private static void dfs(ArrayList<Integer>[] arr, boolean[] visited, int i) {
        int startNode = i;

        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visited[startNode] = true;

        while(!stack.empty()) {
            int popNode = stack.pop();
            for(int linkedNode : arr[popNode]) {
                if(!visited[linkedNode]) {
                    visited[linkedNode] = true;
                    stack.add(linkedNode);
                }
            }
        }
    }
}
