package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePathsWithJumps {
    public static void main(String[] args) {
        int n, m;
        try(Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
        }
        System.out.println(getMazePathsWithJumps(1, 1, n, m));
    }
    static List<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        //base-case:
        if(sr == dr && sc == dc) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //recursive-case:
        List<String> paths = new ArrayList<>();
        //horizontal Paths:
        for(int h = 1; h <= dc - sc; h++) {
            List<String> hpaths = getMazePathsWithJumps(sr, sc + h, dr, dc);
            for(String hpath : hpaths) {
                paths.add("h" + h + hpath);
            }
        }
        //vertical Paths:
        for(int v = 1; v <= dr - sr; v++) {
            List<String> vpaths = getMazePathsWithJumps(sr + v, sc, dr, dc);
            for(String vpath : vpaths) {
                paths.add("v" + v + vpath);
            }
        }

        //diagonal paths:
        for(int d = 1; d <= dr - sr && d <= dc - sc; d++) {
            List<String> dpaths = getMazePathsWithJumps(sr + d, sc + d, dr, dc);
            for(String dpath : dpaths) {
                paths.add("d" + d + dpath);
            }
        }
        return paths;
    }
}
