package patterns;

import utils.FastReader;

public class Pattern7 {
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
        
        //technique1(n);
        technique2(n);
    }
    static void technique2(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j < i)   System.out.printf(" ");
                else    System.out.printf("*");
            }
            System.out.println();
        }
    }
    static void technique1(int n) {
        for(int i = 0; i < n; i++) {
            //print spaces:
            for(int j = 0; j < i; j++) {
                System.out.printf(" ");
            }
            //print stars:
            for(int k = 0; k < n - i; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
