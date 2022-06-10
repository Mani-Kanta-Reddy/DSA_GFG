package arrays;
import java.util.Arrays;

import utils.FastReader;

public class FindMaxSubArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxSubArray(arr));
        System.out.println(findMaxSubArrayEfficient(arr));
    }
    static int findMaxSubArrayEfficient(int[] arr) {
        /*
        The idea is if we know the maxSubArray for n - 1 elem's then the maxSubArray for nth
        is max(maxSubArray(n - 1) + arr[i] or arr[i])
        */
        int res = arr[0], maxEnding = arr[0];
        for(int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }
    static int findMaxSubArray(int[] arr) {
        int res = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int curr = 0;
            for(int j = i; j < arr.length; j++) {
                curr = curr + arr[j];
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
