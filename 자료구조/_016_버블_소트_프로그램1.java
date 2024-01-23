package 자료구조;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class _016_버블_소트_프로그램1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        int arr[] = new int[N];
        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result[] = arr.clone();
        Arrays.sort(result);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            hashMap.put(result[i], i);
        }

        int max = 0;

        for(int i = 0; i < N; ++i) {
            int dif = i - hashMap.get(arr[i]);
            max = dif > max ? dif : max;
        }

        System.out.println(max + 1);
    }
}
