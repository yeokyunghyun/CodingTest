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
    private static int dir[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int maze[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < row.length; j++) {
                if(row[j] == '1') maze[i][j] = 1;
            }
        }

        boolean visited[][] = new boolean[N][M];
        int result = bfs(maze, visited);
        System.out.println(result);
    }

    private static int bfs(int maze[][], boolean visited[][]) {
        /*처음 타겟 Node로 초기화*/
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 0);
        visited[0][0] = true;
        queue.add(node);
        /*동서남북 탐색 하면서 visited해줌 + 하면서 [N - 1][M - 1] 나오면 return 해줌*/
        while(!queue.isEmpty()) {
            Node pollNode = queue.poll();
            int y = pollNode.y;
            int x = pollNode.x;

            if(y == N - 1 && x == M - 1) {
                return maze[N - 1][M - 1];
            }

            for(int i = 0; i < 4; ++i) {
                int nextY = y + dir[i][0];
                int nextX = x + dir[i][1];
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if(maze[nextY][nextX] != 0 && !visited[nextY][nextX]) {
                        queue.add(new Node(nextY, nextX));
                        maze[nextY][nextX] = maze[y][x] + 1;
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }

        return 0;
    }
    private static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
