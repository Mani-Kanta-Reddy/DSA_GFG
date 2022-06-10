package bits;

import utils.FastReader;

public class HammingDistance {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(countHammingDistance(x, y));
    }
    static int countHammingDistance(int x, int y) {
        /*
        Input: 1 (0 0 0 1)
               4 (0 1 0 0)
        Hamming distance is the no.of bits differ in the position of (i1 & i2)
        */
        int res = 0;
        int xor = x ^ y;
        while(xor > 0) {
            if(xor % 2 != 0)
                res++;
            xor /= 2;
        }
        return res;
    }
}
