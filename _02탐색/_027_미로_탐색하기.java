package _02탐색;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _027_미로_탐색하기 {

    private static int N;
    private static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean maze[][] = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                if(row[j] == '1') maze[i][j] = true;
            }
        }

        boolean visited[][] = new boolean[N][M];
        int result = bfs(maze, visited);
        System.out.println(result);
    }

    private static int bfs(boolean maze[][], boolean visited[][]) {
        /*처음 타겟 Node로 초기화*/
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 0, 1);
        visited[0][0] = true;
        queue.add(node);
        /*동서남북 탐색 하면서 visited해줌 + 하면서 [N - 1][M - 1] 나오면 return 해줌*/
        while(!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int y = pollNode.y;
            int x = pollNode.x;
            int count = pollNode.count;

            if(y == N - 1 && x == M - 1) {
                return count;
            }
            /*동*/
            if(x + 1 >= 0 && x + 1 < M) {
                if(maze[y][x + 1] && !visited[y][x + 1]) {
                    queue.add(new Node(y, x + 1, count + 1));
                    visited[y][x + 1] = true;
                }
            }
            /*남*/
            if(y + 1 >= 0 && y + 1 < N) {
                if(maze[y + 1][x] && !visited[y + 1][x]) {
                    queue.add(new Node(y + 1, x, count + 1));
                    visited[y + 1][x] = true;
                }
            }
            /*서*/
            if(x - 1 >= 0 && x - 1 < M) {
                if(maze[y][x - 1] && !visited[y][x - 1]) {
                    queue.add(new Node(y, x - 1, count + 1));
                    visited[y][x - 1] = true;
                }
            }
            /*북*/
            if(y - 1 >= 0 && y - 1 < N) {
                if(maze[y - 1][x] && !visited[y - 1][x]) {
                    queue.add(new Node(y - 1, x, count + 1));
                    visited[y - 1][x] = true;
                }
            }
        }

        return 0;
    }
    private static class Node {
        int y;
        int x;
        int count;

        public Node(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
