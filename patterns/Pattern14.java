package patterns;

import utils.FastReader;

public class Pattern14 {
    public static void main(String[] args) {
        /*
               *********
                *     *
                 *   *
                  * *
                   *
        
        The Other strategy is to ignore the first rows mid-stars (consider it as `v`) treats them as spaces  
               
               *       *
                *     *
                 *   *
                  * *
                   *      
        
        Finally fill the first row mid-stars
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            //print-spaces
            for(int j = 1; j < i; j++) {
                System.out.printf(" ");
            }
            //print-star
            System.out.printf("*");
            if(i == 1) {
                for(int x = 1; x <= 2 * n - 3; x++) {
                    System.out.printf("*");
                }
            } else {
                //print-spaces
                // 5, 3, 1
                for(int k = 2; k < (2 * n) - (2 * i - 1); k++) {
                    System.out.printf(" ");
                }
            }
            if(i != n) {
                //print-star
                System.out.printf("*");
            }
            //print-line
            System.out.println();
        }                
    }
}
