package etc;

public class Solution {
    public static String solution(String my_string, String overwrite_string, int s) {

        String answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length(), my_string.length());

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("hello", "ii", 2));
    }
}