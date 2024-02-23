/*
package _0999_Hash_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _010_무한_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[2];
        arr.
        long i = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        String str = new String("- and backend and senior and - 150");
        String arr[] = str.split("and");

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Object> objects = new ArrayList<>();
        objects.

        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        if (map.containsKey(i)) System.out.println(map.get(i));
        else {
            long result = infiniteSequence(i, p, q, map);
            System.out.println(result);
        }
    }

    private static long infiniteSequence(long i, long p, long q, HashMap<Long, Long> map) {
        long a = i / p;
        long b = i / q;

        if (map.containsKey(a)) {
            a = map.get(a);
        } else {
            a = infiniteSequence(a, p, q, map);
        }

        if (map.containsKey(b)) {
            b = map.get(b);
        } else {
            b = infiniteSequence(b, p, q, map);
        }

        map.put(i, a + b);
        return a + b;
    }
}











import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int total = info.length;

        for(int i = 0; i < query.length; ++i) {
            String[] str = query[i].split(" "); //0, 2, 4, 6, 7
            for(int j = 0; j < info.length; ++j) {
                String infoStr[] = info[j].split(" ");
                if(str[0].equals("-")) {

                } else {
                    if(!str[0].equals(infoStr[0])) {
                        set.add(j);
                        continue;
                    }
                }

                if(str[2].equals("-")) {

                } else {
                    if(!str[2].equals(infoStr[1])) {
                        set.add(j);
                        continue;
                    }
                }

                if(str[4].equals("-")) {

                } else {
                    if(!str[4].equals(infoStr[2])) {
                        set.add(j);
                        continue;
                    }
                }

                if(str[6].equals("-")) {

                } else {
                    if(!str[6].equals(infoStr[3])) {
                        set.add(j);
                        continue;
                    }
                }

                if(Integer.parseInt(str[7]) > Integer.parseInt(infoStr[4])) {
                    set.add(j);
                }
            }
            arr.add(total - set.size());
            set.clear();
        }

        int[] answer = new int[arr.size()];
        int index = 0;

        for(int i : arr) {
            answer[index++] = i;
        }

        return answer;
    }
}*/
