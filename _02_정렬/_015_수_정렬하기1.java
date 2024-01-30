package _02_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _015_수_정렬하기1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N - 1; ++i) {
            boolean hasSwap = false;
            for(int j = 0; j < N - 1 - i; ++j) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    hasSwap = true;
                }
            }
            if(!hasSwap) break;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
