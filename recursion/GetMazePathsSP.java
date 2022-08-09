package recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMazePathsSP {
    static List<String> getMazePathsSP(int sr, int sc, int dr, int dc) {
        //base-case:    
        //positive-case
        if(sr == dr && sc == dc) {
            return Arrays.asList("");
        }

        //negative-case:
        if(sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        //recursive-case:
        List<String> finalRes = new ArrayList<>();
        for(int i = 1; i < dc; i++) {
            List<String> hpaths = getMazePathsSP(sr, sc + i, dr, dc);
            for(String h : hpaths) {
                finalRes.add("h" + i + h);
            }
        }
        for(int k = 1; k < dc && k < dr; k++) {
            List<String> dpaths = getMazePathsSP(sr + k, sc + k, dr, dc);
            for(String d : dpaths) {
                finalRes.add("d" + k + d);
            }
        }
        for(int j = 1; j < dr; j++) {
            List<String> vpaths = getMazePathsSP(sr + j, sc, dr, dc);
            for(String v : vpaths) {
                finalRes.add("v" + j + v);
            }
        }
        return finalRes;

    }
    public static void main(String[] args) {
        System.out.println(getMazePathsSP(1, 1, 3, 3));
    }
}