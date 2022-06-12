package patterns;

import utils.FastReader;

public class Pattern5 {
    public static void main(String[] args) {
        /*
            *
            **
            ***
            ****
            *****
            ****
            ***
            **
            *
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i < 2 * n; i++) {
            int c = (i <= n) ? i : 2 * n - i;
            for(int j = 0; j < c; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
