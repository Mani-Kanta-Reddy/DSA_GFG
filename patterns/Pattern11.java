package patterns;

import utils.FastReader;

public class Pattern11 {
    public static void main(String[] args) {
        /*
             * * * * *
              * * * *
               * * *
                * *
                 *
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            //print-space
            for(int j = 1; j < i; j++) {
                System.out.printf(" ");
            }
            //print `* `
            for(int k = 1; k <= (2 * n) - (2 * i - 1); k += 2) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}
