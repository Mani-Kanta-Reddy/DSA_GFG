package patterns;

import utils.FastReader;

public class Pattern12 {
    public static void main(String[] args) {
        /*
              * * * * *
               * * * *
                * * *
                 * *
                  *
                  *
                 * *
                * * *
               * * * *
              * * * * *
        */
        FastReader sc =  new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i <= 2 * n; i++) {
            if(i <= n) {
                //print-space
                for(int j = 1; j < i; j++) {
                    System.out.printf(" ");
                }
                //print-star
                for(int k = 1; k <= (2 * n) - (2 * i - 1); k += 2) {
                    System.out.printf("* ");
                }
                //print-line
                System.out.println();
            } else {
                //print-space
                for(int l = 1; l < (2 * n) - (i - 1); l++) {
                    System.out.printf(" ");
                }
                //print-star
                for(int m = n + 1; m <= i ; m++) {
                    System.out.printf("* ");
                }
                //print-line
                System.out.println();
            }
        }
    }
}
