package 자료구조;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _010_최솟값_찾기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sizeOfSlid = Integer.parseInt(st.nextToken());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Node> deque = new LinkedList<>();

        for(int i = 0; i < N; ++i) {
            while(!deque.isEmpty() && deque.peekFirst().index <= i - sizeOfSlid) {
                deque.removeFirst();
            }

            Node addNode = new Node(i, arr[i]);
            while(!deque.isEmpty() && addNode.value < deque.peekLast().value) {
                deque.removeLast();
            }
            deque.addLast(addNode);

            System.out.print(deque.peekFirst().value + " ");
        }
    }

    private static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
