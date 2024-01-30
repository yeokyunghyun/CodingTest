package _03_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _029_원하는_정수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int findList[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            if (isExist(arr, findList[i])) System.out.println(1);
            else System.out.println(0);
        }

    }

    private static boolean isExist(int[] arr, int findNum) {
        int lo = 0;
        int hi = arr.length - 1;

        int mid = 0;

        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == findNum) {
                return true;
            } else if (arr[mid] > findNum) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
