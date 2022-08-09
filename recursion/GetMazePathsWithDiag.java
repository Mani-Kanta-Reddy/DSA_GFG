package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePathsWithDiag {
    static List<String> getMazePathsWithDiag(int sr, int sc, int dr, int dc) {
        //base-case:
        //positiv-case:
        if(sr == dr && sc == dc) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //negative-case:
        if(sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        //recursive -case:
        List<String> hpaths = getMazePathsWithDiag(sr, sc + 1, dr, dc);
        List<String> vpaths = getMazePathsWithDiag(sr + 1, sc, dr, dc);
        List<String> dpaths = getMazePathsWithDiag(sr + 1, sc + 1, dr, dc);
        List<String> paths = new ArrayList<>();
        for(String h1 : hpaths) {
            paths.add("h" + h1);
        }
        for(String v1 : vpaths) {
            paths.add("v" + v1);
        }
        for(String d1 : dpaths) {
            paths.add("d" + d1);
        }
        return paths;
    }
    public static void main(String[] args) {
        System.out.println(getMazePathsWithDiag(1, 1, 3, 3));
    }
}
