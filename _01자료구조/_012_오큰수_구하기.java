package _01자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class _012_오큰수_구하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result[] = new int[N];

        Stack<Integer> NGEProcess = new Stack<>();

        NGEProcess.push(0);
        for(int i = 1; i < N; ++i) {
            while(!NGEProcess.empty() && arr[NGEProcess.peek()] < arr[i]) {
                result[NGEProcess.pop()] = arr[i];
            }
            NGEProcess.push(i);
        }

        while(!NGEProcess.empty()) {
            result[NGEProcess.pop()] = -1;
        }

        for(int i = 0; i < N; ++i) {
            System.out.print(result[i] + " ");
        }
    }
}
