package misc;

import java.util.Arrays;

import utils.FastReader;

public class DiffIdxOfLargestAndSmallest {
    public static void main(String[] args) {
        /*
        Input: 10 9 3 5 38 33
        Output: 4 - 2 = 2 (largest element is @4 and smallest element is 2)
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int smallestIdx = 0, largestIdx = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                largestIdx = i;
            }
            if(arr[i] < min) {
                min = arr[i];
                smallestIdx = i;
            }
        }
        System.out.println(largestIdx - smallestIdx);             
    }
}
