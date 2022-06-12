package patterns;

import utils.FastReader;

public class Pattern2 {
    public static void main(String[] args) {
        /*
            *
            **
            ***
            ****
            *****
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
