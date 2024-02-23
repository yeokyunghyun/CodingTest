package _04_그리디;

import java.util.ArrayList;
import java.util.HashSet;

public class Practice {
    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

        ArrayList<ArrayList<Integer>> storeUnique = new ArrayList<>();

        int answer = 0;

        for (int i = 1; i < relation[0].length + 1; ++i) {
            ArrayList<Integer> arr = new ArrayList<>();
            answer += findCandidateKey(relation, storeUnique, arr, i, 0);
        }

        System.out.println(answer);
    }

    public static int findCandidateKey(String[][] relation, ArrayList<ArrayList<Integer>> storeUnique, ArrayList<Integer> arr, int size, int idx) {
        if (arr.size() == size) {
            if(isUnique(relation, arr)) {
                if(isValid(storeUnique, arr)) {
                    storeUnique.add((ArrayList<Integer>)arr.clone());
                    return 1;
                }
            }
            return 0;
        }

        int count = 0;

        for (int i = idx; i < relation[0].length; ++i) {
            arr.add(i);
            count += findCandidateKey(relation, storeUnique, arr, size,i + 1);
            arr.remove(arr.size() - 1);
        }
        return count;
    }

    public static boolean isUnique(String [][] relation, ArrayList<Integer> arr) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < relation.length; ++i) {
            String str = "";
            for(int j : arr) {
                str += relation[i][j];
            }
            set.add(str);
        }

        if(relation.length == set.size()) return true;
        return false;
    }
    public static boolean isValid(ArrayList<ArrayList<Integer>> storeUnique, ArrayList<Integer> arr) {

        for(ArrayList<Integer> compareArr : storeUnique) {
            int count = 0;
            for(int i : arr) {
                for(int j : compareArr) {
                    if(i == j) ++count;
                }
            }
            if(count == compareArr.size()) return false;
        }
        return true;
    }

}


