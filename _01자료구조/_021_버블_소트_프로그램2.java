package _01자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _021_버블_소트_프로그램2 {

    public static int tmp[];
    public static long count  = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tmp = new int[N];

        mergeSort(arr, 0, N - 1);
        System.out.println(count);
    }

    private static void mergeSort(int arr[], int s, int e) {
        if(s >= e) return;

        int m = s + ((e - s) / 2);

        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        for(int i = s; i <= e; ++i) {
            tmp[i] = arr[i];
        }

        int startIdx = s;
        int left = s;
        int right = m + 1;

        while(left <= m && right <= e) {
            if(tmp[left] > tmp[right]) {
                count += m - left + 1;
                arr[startIdx++] = tmp[right++];
            } else{
                arr[startIdx++] = tmp[left++];
            }
        }

        while(left <= m) arr[startIdx++] = tmp[left++];
        while(right <= e) arr[startIdx++] = tmp[right++];
    }
}
