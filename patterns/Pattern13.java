package patterns;

import utils.FastReader;

public class Pattern13 {
    public static void main(String[] args) {
        /*
                  *
                 * *
                *   *
               *     *
              *********

        The other strategy is ignore the last rows mid stars (consider as upright `v`)

                  *
                 * *
                *   *
               *     *
              *       *
                
        Finally fill the last rows mid-stars
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i < n; i++) {
            //print-space
            for(int j = 1; j <= n - i; j++) {
                System.out.printf(" ");
            }
            //print-star
            System.out.printf("*");
            //print-space
            if(i != 1) {
                for(int k = 2; k < 2 * i - 1; k++) {
                    System.out.printf(" ");
                }
                //print-star
                System.out.printf("*");
            }
            //print-line
            System.out.println();
        }
        //if n = 5 print 2 * n - 1 stars
        for(int i = 1; i <= 2 * n - 1; i++) {
            System.out.printf("*");
        }
        System.out.println();
    }
}
