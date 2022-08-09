package recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetStairPaths {
    /*
     * 
     */
    public static void main(String[] args) {
        int noOfStairs;
        try(Scanner sc = new Scanner(System.in)) {
            noOfStairs = sc.nextInt();
        }
        System.out.println(getStairPaths(noOfStairs));
    }

    static List<String> getStairPaths(int n) {
        //base-case:
        if(n == 0) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        } else if(n < 0) {
            List<String> negativeRes = new ArrayList<>();
            return negativeRes;
        }
        
        //recursive-case:
        List<String> paths1 = getStairPaths(n - 1);
        List<String> paths2 = getStairPaths(n - 2);
        List<String> paths3 = getStairPaths(n - 3);

        List<String> paths = new ArrayList<>();
        for(String p1: paths1) {
            paths.add("1" + p1);
        }
        for(String p2: paths2) {
            paths.add("2" + p2);
        }
        for(String p3: paths3) {
            paths.add("3" + p3);
        }
        return paths;
    }
}
