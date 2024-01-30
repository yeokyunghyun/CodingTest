package _01_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _013_카드_게임 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; ++i) {
            deque.addLast(i);
        }

        while(deque.size() > 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        System.out.println(deque.removeFirst());
    }
}
