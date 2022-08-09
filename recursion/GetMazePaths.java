package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        int n, m;
        try(Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
        }
        System.out.println(getMazePaths(1, 1, n, m));
    }
    static List<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //base-case:
        if(sr == dr && sc == dc) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        //recursive-case:
        List<String> hpaths = new ArrayList<>();
        List<String> vpaths = new ArrayList<>();
        List<String> finalRes = new ArrayList<>();

        if(sc < dc) {
            hpaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        if(sr < dr) {
            vpaths = getMazePaths(sr + 1, sc, dr, dc);
        }
        for(String hpath : hpaths) {
            finalRes.add("h" + hpath);
        }
        for(String vpath : vpaths) {
            finalRes.add("v" + vpath);
        }
        return finalRes;
    }
}
