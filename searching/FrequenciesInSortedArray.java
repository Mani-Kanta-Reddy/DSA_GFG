package searching;

import java.util.Arrays;
import utils.FastReader;

public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        /*
        Input: [10, 10, 10, 26, 35]
        Output: 10 -> 3
                26 -> 1
                35 -> 1

        Input: [10, 10, 10]
        Output: 10 -> 3

        Input: [10, 20, 30]
        Outpu: 10 -> 1
               20 -> 1
               30 -> 1
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        frequenciesInSortedArray(arr);
    }
    static void frequenciesInSortedArray(int[] arr) {
        /*
        The Idea goes like this as the array is sorted
        Start freq = 1 and keep track of freq & start scan from left, if arr[i] different from arr[i - 1] print count and make count 0
        */
        int i = 1, freq = 1;
        while(i < arr.length) {
            while(i < arr.length && arr[i] == arr[i - 1]) {
                i++;
                freq++;
            }
            System.out.printf("%d -> %d \n", arr[i - 1], freq);
            i++;
            freq = 1;
        }
        if(arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.printf("%d -> %d", arr[arr.length - 1], 1);
        }
    }
}
