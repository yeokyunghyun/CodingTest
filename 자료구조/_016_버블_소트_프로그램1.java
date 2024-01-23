package 자료구조;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class _016_버블_소트_프로그램1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxLength = 0;

        Node arr[] = new Node[N];
        for(int i = 0; i < N; ++i) {
            arr[i] = new Node(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, (o1, o2) -> o1.value - o2.value);

        for(int i = 0; i < N; ++i) {
            int changeIdx = arr[i].index;
            maxLength = changeIdx - i > maxLength ? changeIdx - i : maxLength;
        }

        System.out.println(maxLength + 1);
    }

    private static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
