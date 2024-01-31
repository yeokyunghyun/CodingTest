package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _036_최솟값을_만드는_괄호_배치_찾기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();

        boolean isMinus = false;

        int signIdx = -1;
        Queue<Integer> nums = new LinkedList<>();
        Queue<Character> signs = new LinkedList<>();

        for (int i = 0; i < arr.length(); i++) {
            if(arr.charAt(i) == '-' || arr.charAt(i) == '+') {
                signs.add(arr.charAt(i));
                nums.add(Integer.parseInt(arr.substring(signIdx + 1, i)));
                signIdx = i;
            }
        }

        nums.add(Integer.parseInt(arr.substring(signIdx + 1, arr.length())));

        int total = nums.poll();

        while(!signs.isEmpty() && !nums.isEmpty()) {
            char sign = signs.poll();
            int num = nums.poll();

            if(sign == '-') isMinus = true;

            if(isMinus) {
                total -= num;
            }
            else{
                total += num;
            }
        }

        System.out.println(total);

    }
}
