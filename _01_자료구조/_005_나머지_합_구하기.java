package _01_자료구조;
import java.util.Scanner;

public class _005_나머지_합_구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        long arr[] = new long[N];
        long sum[] = new long[M+1];

        long num = 0;

        for(int i = 1; i <= M; i++) {
            num = sc.nextLong();
            sum[i] = sum[i-1] + num;
        }

        //구간합끼리 빼서 3의배수가 나온다는것은 숫자가 같으면 두개의 수를 빼면 3의배수가 나온다는 뜻이다.

        for(int i = 1; i<= M; i++) {
            sum[i]%=(long)N;
            arr[(int)sum[i]]++;
        }

        long count = 0;

        count += arr[0];

        for(int i = 0; i < N; i++ ) {
            if(arr[i] == 0) continue;
            else {
                count += arr[i]*(arr[i]-1)/2;
            }

        }

        System.out.print(count);
    }
}