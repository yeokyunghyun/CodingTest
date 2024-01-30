package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _034_수를_묶어서_최댓값_만들기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        int numOfOne = 0;
        int numOfZero = 0;

        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; ++i) {
            int num = Integer.parseInt(br.readLine());
            if(num == 1) ++numOfOne;
            else if(num == 0) ++numOfZero;
            else if(num >= 2) plusPq.add(num);
            else minusPq.add(num);
        }

        while(plusPq.size() >= 2) {
            int first = plusPq.poll();
            int second = plusPq.poll();

            total += first * second;
        }
        if(!plusPq.isEmpty()) total += plusPq.poll();

        while(minusPq.size() >= 2) {
            int first = minusPq.poll();
            int second = minusPq.poll();

            total += first * second;
        }
        if(!minusPq.isEmpty()) {
            if(numOfZero == 0) total += minusPq.poll();
        }

        int result = total + numOfOne;

        System.out.println(result);


    }

}
