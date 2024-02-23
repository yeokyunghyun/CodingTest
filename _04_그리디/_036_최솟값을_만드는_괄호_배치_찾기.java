package _04_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _036_최솟값을_만드는_괄호_배치_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine();

        String splitByMinus[] = arr.split("-");
        int total = 0;
        for (int i = 0; i < splitByMinus.length; i++) {
            if(i == 0) {
                total += getSum(splitByMinus[i]);
            } else {
                total -= getSum(splitByMinus[i]);
            }
        }
        System.out.println(total);
    }
    private static int getSum(String splitByMinus) {
        String arr[] = splitByMinus.split("\\+");
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += Integer.parseInt(arr[i]);
        }
        return result;
    }
}
