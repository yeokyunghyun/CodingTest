package etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

       Point arr[][] = new Point[51][51];

      arr[0][0] = new Point(1, 2);
        System.out.println(arr[0][0].r);


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
