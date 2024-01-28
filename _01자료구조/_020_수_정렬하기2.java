package _01자료구조;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _020_수_정렬하기2 {

    static int tmp[];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        tmp = new int[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, N - 1);
        for(int i = 0; i < N; ++i) {
            System.out.println(arr[i]);
        }
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
            if(tmp[left] < tmp[right]) {
                arr[startIdx++] = tmp[left++];
            } else{
                arr[startIdx++] = tmp[right++];
            }
        }

        while(left <= m) arr[startIdx++] = tmp[left++];
        while(right <= e) arr[startIdx++] = tmp[right++];
    }
}
