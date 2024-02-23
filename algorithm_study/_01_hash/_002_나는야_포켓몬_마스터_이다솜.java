package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _002_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numberKey = new HashMap<>();
        HashMap<String, Integer> pokemonKey = new HashMap<>();

        for(int i = 1; i <= N; ++i) {
            String poketmonName = br.readLine();
            numberKey.put(i, poketmonName);
            pokemonKey.put(poketmonName, i);
        }

        for(int i = 1; i <= M; ++i) {
            String question = br.readLine();
            char firstLetter = question.charAt(0);
            if(firstLetter >= '0' && firstLetter <= '9') {
                System.out.println(numberKey.get(Integer.parseInt(question)));
            } else {
                System.out.println(pokemonKey.get(question));
            }
        }
    }
}
