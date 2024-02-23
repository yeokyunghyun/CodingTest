package etc;

import java.awt.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String command[] = new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 1 2 2", "MERGE 1 2 2 2", "UNMERGE 2 2", "PRINT 2 2"};
        String []result = solution(command);
        for (String s : result) {
            System.out.println(s);
        }
    }
    public static String[] solution(String[] commands) {
        ArrayList<String> result = new ArrayList<>();

        Point map[][] = new Point[51][51];
        String arr[][] = new String[51][51];

        for(int i = 1; i < 51; ++i) {
            for(int j = 1; j < 51; ++j) {
                map[i][j] = new Point(i, j);
            }
        }

        for(String command : commands) {
            String splitCommand[] = command.split(" ");

            if(command.startsWith("M")) {
                int r1 = Integer.parseInt(splitCommand[1]);
                int c1 = Integer.parseInt(splitCommand[2]);
                int r2 = Integer.parseInt(splitCommand[3]);
                int c2 = Integer.parseInt(splitCommand[4]);

                Point firstPoint = getUnion(map, r1, c1);
                Point secondPoint = getUnion(map, r2, c2);

                if(arr[firstPoint.r][firstPoint.c] != null)  {
                    map[secondPoint.r][secondPoint.c] = new Point(firstPoint.r, firstPoint.c);
                }
                else if(arr[secondPoint.r][secondPoint.c] != null) {
                    map[firstPoint.r][firstPoint.c] = new Point(secondPoint.r, secondPoint.c);
                } else {
                    map[secondPoint.r][secondPoint.c] = new Point(firstPoint.r, firstPoint.c);
                }
            } //merge r1 c1 r2 c2
            else if(command.startsWith("UP")) {
                if(splitCommand.length == 4) {
                    int r = Integer.parseInt(splitCommand[1]);
                    int c = Integer.parseInt(splitCommand[2]);

                    Point point = getUnion(map, r, c);
                    arr[point.r][point.c] = splitCommand[3];
                } //r c value
                else {
                    for(int i = 1; i < 3; ++i) {
                        for(int j = 1; j < 3; ++j) {
                            if(arr[i][j] == splitCommand[1]) arr[i][j] = splitCommand[2];
                        }
                    }
                } // value1 value2
            }
            else if(command.startsWith("U")) {
                int r = Integer.parseInt(splitCommand[1]);
                int c = Integer.parseInt(splitCommand[2]);

                Point point = getUnion(map, r, c);
                String arrStr = arr[point.r][point.c];

                int rootR = point.r;
                int rootC = point.c;

                Point copy[][] = new Point[51][51];
                for (int i = 0; i < map.length; i++) {
                    copy[i] = Arrays.copyOf(map[i], map[i].length);
                }

                for(int i = 1; i < 3; ++i) {
                    for(int j = 1; j < 3; ++j) {
                        Point mapPoint = getUnion(map, i, j);
                        if(mapPoint.r == rootR && mapPoint.c == rootC) {
                            copy[i][j] = new Point(i, j);
                            arr[i][j] = null;
                        }
                    }
                }

                for(int i = 1; i < 3; ++i) {
                    for(int j = 1; j < 3; ++j) {
                        if(copy[i][j] != null) {
                            map[i][j] = copy[i][j];
                            arr[i][j] = null;
                        }
                    }
                }

                arr[r][c] = arrStr;
            }//unmarge
            else {
                int r = Integer.parseInt(splitCommand[1]);
                int c = Integer.parseInt(splitCommand[2]);

                Point resultPoint = getUnion(map, r, c);
                if(arr[resultPoint.r][resultPoint.c] == null) {
                    result.add("EMPTY");
                } else {
                    result.add(arr[resultPoint.r][resultPoint.c]);
                }
            }//print
        }


        String[] answer = new String[result.size()];
        int index = 0;
        for(String s : result) {
            answer[index++] = s;
        }
        return answer;
    }

    private static Point getUnion(Point map[][], int r, int c) {

        while(!(map[r][c].r == r && map[r][c].c == c)) {
            r = map[r][c].r;
            c = map[r][c].c;
        }

        return new Point(r, c);
    }
    private static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}