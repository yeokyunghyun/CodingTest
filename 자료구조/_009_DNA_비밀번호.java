package 자료구조;

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
        for (int i = 0; i < passWordLength; i++) {
            if(DnaPassword[i] == 'A') --DnaAlphabetCount[0];
            else if(DnaPassword[i] == 'C') --DnaAlphabetCount[1];
            else if(DnaPassword[i] == 'G') --DnaAlphabetCount[2];
            else --DnaAlphabetCount[3];
        }

        int count = 0;
        if(isValid(DnaAlphabetCount)) ++count;

        for (int i = 0; i < DNA_Length - passWordLength; ++i) {
            if(DnaPassword[i] == 'A') ++DnaAlphabetCount[0];
            else if(DnaPassword[i] == 'C') ++DnaAlphabetCount[1];
            else if(DnaPassword[i] == 'G') ++DnaAlphabetCount[2];
            else ++DnaAlphabetCount[3];

            if(DnaPassword[i + passWordLength] == 'A') --DnaAlphabetCount[0];
            else if(DnaPassword[i + passWordLength] == 'C') --DnaAlphabetCount[1];
            else if(DnaPassword[i + passWordLength] == 'G') --DnaAlphabetCount[2];
            else --DnaAlphabetCount[3];

            if(isValid(DnaAlphabetCount)) ++count;
        }

        System.out.println(count);
        
    }

    private static boolean isValid(int[] DnaAlphabetCount) {
        for (int i = 0; i < DnaAlphabetCount.length; i++) {
            if(DnaAlphabetCount[i] > 0) return false;
        }

        return true;
    }
}
