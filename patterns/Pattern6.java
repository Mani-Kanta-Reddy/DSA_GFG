package patterns;

import utils.FastReader;

public class Pattern6 {
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

        //technique1(n);
        technique2(n);
    }
    static void technique2(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 5; j > 0; j--) {
                if(j > i)   System.out.printf(" ");
                else System.out.printf("*");
            }
            System.out.println();
        }
    }
    static void technique1(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = n; j > i; j--) {
                System.out.printf(" ");
            }
            for(int k = 1; k <= i; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
