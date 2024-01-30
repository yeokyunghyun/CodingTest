package _01_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _008_좋은수_구하기 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goodNumberCandidate[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(goodNumberCandidate);
        int count = 0;
        //0,1은 안되고 2부터 가능
        for(int i = 0; i < N; ++i) {
            int left = 0;
            int right = N - 1;

            while(left < right) {
                int total = goodNumberCandidate[left] + goodNumberCandidate[right];
                if(total == goodNumberCandidate[i]) {
                    if(left != i && right != i) {
                        ++count;
                        break;
                    } else if(left == i) {
                        ++left;
                    } else{
                        --right;
                    }

                } else if(total < goodNumberCandidate[i]) {
                    ++left;
                }
                else{
                    --right;
                }
            }
        }

        System.out.println(count);
    }
}
