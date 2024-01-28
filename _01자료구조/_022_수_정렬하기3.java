package _01자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _022_수_정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> sortQueue[] = new LinkedList[10];
        for (int i = 0; i < 10; ++i) {
            sortQueue[i] = new LinkedList<>();
        }
        Queue<Integer> store = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;

        int digit = 1;
        //i)
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sortQueue[(num % (digit * 10)) / digit].add(num);
        }

        digit *= 10;

        /*내가 짠 알고리즘 >>
        i)먼저 내가 입력한 숫자를 (num % (digit * 10)) / digit을 이용해서 sortQueue에 넣는다.

        ii)넣는 걸 빼면서 다음 자릿수가 없는 숫자들은 result에 넣는다
        iii)넣지 않아진 숫자들은 다시 store에 넣는다
        iiii) store안에 있는 숫자들을 (num % (digit * 10)) / digit을 이용해서 다시 sortQueue에 넣는다.
        * */
        while (count < N) {
            for (int i = 0; i < sortQueue.length; ++i) {
                while (!sortQueue[i].isEmpty()) {
                    int removeNum = sortQueue[i].remove();
                    // ii)
                    if (removeNum / digit == 0) {
                        result.add(removeNum);
                        ++count;
                    } else {
                        // iii)
                        store.add(removeNum);
                    }
                }
            }
            //iiii)
            while (!store.isEmpty()) {
                int removeNum = store.remove();
                sortQueue[(removeNum % (digit * 10)) / digit].add(removeNum);
            }
            digit *= 10;
        }
        //내부에 있는 것 전부 store에 넣음 넣는 과정에서 다음 동작이 안될 애들은 result에 넣고 그것이 아니라면

        for (int resultNum : result) {
            System.out.println(resultNum);
        }
    }
}
