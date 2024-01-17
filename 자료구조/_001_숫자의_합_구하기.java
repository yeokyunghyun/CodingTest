package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 1번째 줄에 숫자의 갯수(1<= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.*/

// 문자(문자열말고)를 숫자로 어떻게 바꿀것인가 ?
public class _001_숫자의_합_구하기 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int total = 0;
            total = 1;
            int numberOfNum = Integer.parseInt(br.readLine());
            char[] numberArr = br.readLine().toCharArray(); //br.readLine()은 개행문자까지 읽어옴.

            for (int j = 0; j < numberArr.length; j++) {
                total += Character.getNumericValue(numberArr[j]); // -'0'을 사용해서 할 수도 있음.
            }

            System.out.println(total);
        }

    }

}
