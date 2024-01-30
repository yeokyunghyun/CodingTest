package _01_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _009_DNA_비밀번호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int DNA_Length = Integer.parseInt(st.nextToken());
        int passWordLength = Integer.parseInt(st.nextToken());
        char DnaPassword[] = br.readLine().toCharArray();

        int DnaAlphabetCount[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int alphabet[] = new int[26];

        alphabet[0] = DnaAlphabetCount[0];
        alphabet[2] = DnaAlphabetCount[1];
        alphabet[6] = DnaAlphabetCount[2];
        alphabet[19] = DnaAlphabetCount[3];

        for (int i = 0; i < passWordLength; i++) {
            --alphabet[DnaPassword[i] - 'A'];
        }

        int count = 0;
        if(isValid(alphabet)) ++count;

        for (int i = 0; i < DNA_Length - passWordLength; ++i) {
            ++alphabet[DnaPassword[i] - 'A'];
            --alphabet[DnaPassword[i + passWordLength] - 'A'];
            if(isValid(alphabet)) ++count;
        }

        System.out.println(count);
    }
    private static boolean isValid(int[] alphabet) {
        if(alphabet[0] > 0 || alphabet[2] > 0 || alphabet[6] > 0 || alphabet[19] > 0) return false;
        return true;
    }
}
