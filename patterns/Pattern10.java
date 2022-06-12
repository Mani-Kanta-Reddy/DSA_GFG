package patterns;

import utils.FastReader;

public class Pattern10 {
    public static void main(String[] args) {
        /*
                *
               * *
              * * *
             * * * *
            * * * * *
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            //print-spaces
            for(int j = 1; j <= n - i; j++) {
                System.out.printf(" ");
            }
            //print star then space respectively 
            for(int k = 1; k <= (2 * i) - 1; k += 2) {
                System.out.printf("* ");
            }
            System.out.println();
        }
    }
}
