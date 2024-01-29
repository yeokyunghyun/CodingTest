package _02탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _025_친구_관계_파악하기 {
    public static boolean hasRelation = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList[] arr = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        boolean visited[] = new boolean[N];

        for(int i = 0; i < N; ++i) {
            if(!hasRelation) {
                visited[i] = true;
                getRelation(arr, visited, i, 1);
                visited[i] = false;
            }
        }

        if(hasRelation) System.out.println(1);
        else System.out.println(0);
    }

    private static void getRelation(ArrayList<Integer> arr[], boolean visited[], int i, int depth) {
        if(depth == 5 || hasRelation) {
            hasRelation = true;
            return;
        }

        for(int friend : arr[i]) {
            if(!visited[friend]) {
                visited[friend] = true;
                getRelation(arr, visited, friend, depth + 1);
                visited[friend] = false;
            }
        }
    }
}
