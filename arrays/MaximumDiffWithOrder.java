package arrays;
import java.util.Arrays;

import utils.FastReader;

public class MaximumDiffWithOrder {
    public static void main(String[] args) {
        /*
        Find the max diff from the given array when arr[j] - arr[i] | j > i
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxDiff(arr)); //O(n ^ 2) | O(1)
        System.out.println(findMaxDiffEfficient(arr));
    }
    static int findMaxDiff(int[] arr) {
        int maxDiff = arr[1] - arr[0];
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                // int curr_diff = arr[j] - arr[i];
                // if(curr_diff > maxDiff)
                //     maxDiff = curr_diff;
                maxDiff = Math.max(maxDiff, arr[j] - arr[i]);
            }
        }
        return maxDiff;
    }
    static int findMaxDiffEfficient(int[] arr) {
        /*
        The idea goes like this:
        The maxDiff is obtained only if we substract min ele from max having this in mind
        we scan from left always keep track of curr_min and if the (next ele - curr_min) is 
        greater than maxDiff update maxDiff & curr_min
        Finally return maxDiff
        */
        int currMin = arr[0];
        int maxDiff = arr[1] - arr[0];
        for(int i = 1; i < arr.length; i++) {
            //check & update maxDiff
            // int currDiff = arr[i] - currMin;
            // if(currDiff > maxDiff) {
            //     maxDiff = currDiff;
            // }
            // //check & update currMin
            // if(arr[i] < currMin) {
            //     currMin = arr[i];
            // }
            //----------OR-----------------
            maxDiff = Math.max(maxDiff, arr[i] - currMin);
            currMin  = Math.min(currMin, arr[i]);
        }
        return maxDiff;
    }
}
