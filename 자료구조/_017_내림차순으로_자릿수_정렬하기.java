package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _017_내림차순으로_자릿수_정렬하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();

        for (int i = 0; i < arr.length - 1; ++i) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if(arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }

            swap(arr, i, maxIdx);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void swap(char arr[], int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
