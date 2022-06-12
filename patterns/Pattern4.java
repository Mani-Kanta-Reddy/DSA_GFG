package patterns;

import utils.FastReader;

public class Pattern4 {
    public static void main(String[] args) {
        /*
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.printf("%d ", j + 1);
            }
            System.out.println();
        }
    }
}
