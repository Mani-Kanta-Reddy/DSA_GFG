package patterns;

import utils.FastReader;

public class Pattern15A {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        //print upright `v`
        for(int i = 1; i <= n; i++) {
            //print-spaces
            for(int j = 1; j <= n - i; j++) {
                System.out.printf(" ");
            }
            //print-starting-star
            System.out.printf("*");
            //for i != 1
            if(i != 1) {
                //print-some-more-spaces
                for(int k = 2; k < 2 * i - 1; k++) {
                    System.out.printf(" ");
                }
                //print-ending-star
                System.out.printf("*");
            }
            //print-new-line
            System.out.println();
        }
        //print `v`
        for(int j = 2; j <= n; j++) {
            //print-some-spaces
            for(int k = 2; k <= j; k++) {
                System.out.printf(" ");
            }
            //print-starting-star
            System.out.printf("*");
            //if j != n - 1
            if(j != n - 1) {
                //print-some-more-spaces
                //2 -> 5, 3 -> 3, 4 -> 1
                for(int l = 1; l < n - j + 1; l++) {

                }
                //print-ending-star
                System.out.printf("*");
            }
            //print-new-line
            System.out.println();
        }
    }
}
