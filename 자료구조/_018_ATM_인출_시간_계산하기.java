package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _018_ATM_인출_시간_계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i < arr.length; ++i) {
            int tempIdx = 0;
            for (int j = i; j > 0; --j) {
                if (arr[j - 1] <= arr[i]) {
                    tempIdx = j;
                    break;
                }
            }
            int temp = arr[i];
            goRight(arr, tempIdx, i - 1);
            arr[tempIdx] = temp;
        }

        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            result += arr[i];
        }

        System.out.println(result);
    }

    private static void goRight(int[] arr, int start, int end) {
        for (int i = end; i >= start; --i) {
            arr[i + 1] = arr[i];
        }
    }
}
