package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _033_카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;

        if (N == 1) {
            System.out.println(0);
        } else {
            while (pq.size() >= 2) {
                int firstCard = pq.poll();
                int secondCard = pq.poll();

                total += firstCard + secondCard;

                pq.add(firstCard + secondCard);
            }
            System.out.println(total);
        }
    }
}
//10 20 40
//