package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최댓값을 구하고 그 최댓값을 나누고 100을 곱한값의 평균을
public class _002_평균_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int numOfSubject = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int subjectScore[] = new int[numOfSubject];
            int idx = 0;
            int maxValue = 0;

            while (st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());
                maxValue = maxValue >= score ? maxValue : score;
                subjectScore[idx++] = score;
            }

            double totalSubjectScore = 0;
            for (int j = 0; j < subjectScore.length; j++) {
                totalSubjectScore += (double) subjectScore[j] / maxValue * 100;
            }

            totalSubjectScore /= numOfSubject;

            System.out.println(totalSubjectScore);
        }
    }
}
