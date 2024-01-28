package _01자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _019_K번째_수_구하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        pivot(arr, 0, N - 1, K - 1);

        System.out.println(arr[K - 1]);
    }

    private static void pivot(int[] arr, int lo, int hi, int k) {
        if(lo >= hi) return;

        int pivot = (int) (Math.random() * (hi - lo + 1)) + lo;
        swap(arr, lo, pivot);
        int pivotNum = partition(arr, lo, hi);

        if(pivotNum == k) return;
        else if (pivotNum > k) {
            pivot(arr, lo, pivotNum - 1, k);
        }
        else{
            pivot(arr, pivotNum + 1, hi, k);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        if(lo + 1 == hi) {
            if(arr[lo] > arr[hi]) {
                swap(arr, lo, hi);
                return hi;
            }
            return lo;
        }

        int left = lo + 1;
        int right = hi;
        int pivot = arr[lo];

        while(left <= right) {
            while(left <= hi && arr[left] <= pivot) {
                ++left;
            }
            while(right > lo && arr[right] >= pivot) {
                --right;
            }

            if(left < right) {
                swap(arr, left++, right--);
            }
        }
        swap(arr, lo, right);
        return right;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
