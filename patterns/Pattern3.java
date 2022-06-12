package patterns;

import utils.FastReader;

public class Pattern3 {
    public static void main(String[] args) {
        /*
            *****
            ****
            ***
            **
            *
        */
        FastReader sc = new FastReader();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
