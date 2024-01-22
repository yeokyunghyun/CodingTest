package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _011_스택으로_오름차순_수열_만들기 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Character> result = new LinkedList<>();

        boolean isNotValid = false;

        int arrIdx = 0;

        for (int i = 1; i <= N; ++i) {
            stack.push(i);
            result.add('+');

            while (!stack.empty() && arrIdx < N) {
                int peek = stack.peek();
                if (arr[arrIdx] == peek) {
                    result.add('-');
                    ++arrIdx;
                    stack.pop();
                } else if (arr[arrIdx] > peek) {
                    break;
                } else { //이거는 안되는 경우
                    isNotValid = true;
                    break;
                }
            }
        }

        if (isNotValid) System.out.println("NO");
        else {
            while (!result.isEmpty())
                System.out.println(result.poll());
        }

    }
}
