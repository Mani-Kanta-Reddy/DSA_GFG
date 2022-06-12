package patterns;

import utils.FastReader;

public class Pattern15 {
    public static void main(String[] args) {
        /*
                         *
                        * *
                       *   *
                      *     *
                     *       *
                      *     *
                       *   *
                        * *
                         *
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i < 2 * n; i++) {
            //for upright v (i <= n)
            if(i <= n) {
                //print-some-spaces
                for(int j = 1; j <= n - i; j++) {
                    System.out.printf(" ");
                }
                //print-starting-star
                System.out.printf("*");
                //if you observe carefully the below two patterns can only be print when i != 1
                
                if(i != 1) {
                    //print-some-spaces
                    //2 -> 1 , 3 -> 3, 4 -> 5, 5 -> 7
                    for(int k = 2; k < 2 * i - 1; k++) {
                        System.out.printf(" ");
                    }
                    //print-ending-star
                    System.out.printf("*");
                }
            }
            //for `v` (i > n)
            else {
                //print-some-spaces
                // 6 -> 1, 7 -> 2, 8 -> 3, 9 -> 4
                for(int l = 1; l <= i - n; l++) {
                    System.out.printf(" ");
                }
                //print-starting-star
                System.out.printf("*");
                //if you observe carefully the below two patterns can only be print when i != 2 * n - 1
                if(i != 2 * n - 1) {
                    //print-some-spaces
                    // 6 -> 5, 7 -> 3, 8 -> 1
                    // 11 -> 15, 12 -> 13, 13 -> 11, 14 -> 9, 15 -> 7, 16 -> 5, 17 -> 3 -> 18 -> 1 
                    // 0 -> 5, 1 -> 3, 2 -> 1
                    int temp = i % n;
                    for(int m = 0; m <= 2 * temp - 1; m++) {
                        System.out.printf(" ");
                    }
                    //print-ending-star
                    System.out.printf("*");
                }
            }
            //print-new-line
            System.out.println();
        } 
    }
}
