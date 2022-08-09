package misc;

import java.math.BigInteger;
import java.util.Arrays;

import utils.FastReader;

public class SubArrays {
    public static void main(String[] args) {
        /*
         * Given Array of integers print all of its subArrays
         * SubArray is slice from contiguous array & inherently maintains the order of elems
         * for e.g., [1, 2, 3] -> [1], [1,2], [1,2,3], [2], [2, 3], [3]
         */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
        }
    }
}
