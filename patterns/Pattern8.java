package patterns;

import utils.FastReader;

public class Pattern8 {
    public static void main(String[] args) {
        /*
                    *
                   ***
                  *****
                 *******
                *********
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            //print-spaces:
            for(int j = 1; j <= n - i; j++) {
                System.out.printf(" ");
            }
            //print-stars
            int noOfStars = 2 * i - 1;
            for(int k = 1; k <= noOfStars; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
