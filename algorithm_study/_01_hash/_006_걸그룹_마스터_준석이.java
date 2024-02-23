package algorithm_study._01_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _006_걸그룹_마스터_준석이 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        HashMap<String, ArrayList<String>> teamToMember = new HashMap<>();
        HashMap<String, String> memberToTeam = new HashMap<>();

        for(int i = 0; i < N; ++i) {
            String teamName = br.readLine();
            int memberNum = Integer.parseInt(br.readLine());

            teamToMember.put(teamName, new ArrayList<>());
            String memberName = br.readLine();
            teamToMember.get(teamName).add(memberName);
            memberToTeam.put(memberName, teamName);
            for(int j = 1; j < memberNum; ++j) {
                memberName = br.readLine();
                teamToMember.get(teamName).add(memberName);
                memberToTeam.put(memberName, teamName);
            }
        }

        for(int i = 0; i < question; ++i) {
            String answer = br.readLine();
            int typeOfQuestion = Integer.parseInt(br.readLine());

            if(typeOfQuestion == 0) {
                Collections.sort(teamToMember.get(answer));
                for(String member : teamToMember.get(answer)) {
                    System.out.println(member);
                }
            } else {
                System.out.println(memberToTeam.get(answer));
            }
        }
    }
}
