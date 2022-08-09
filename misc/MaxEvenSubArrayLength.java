package misc;

import java.util.Arrays;

import utils.FastReader;

public class MaxEvenSubArrayLength {
    public static void main(String[] args) {
        /*
        max = 4; count = 1
            Input: 2 6 9 8 4 2 8 5
            Output: 4 (since `8 4 2 8` is the maxEvenSubArray possible form given input array)

            Input: 2 3 4 5 6 7 8 9
            Output: 1 (since all of the array elements are alternate odd and even)

            Input: 3 5 7 9 11
            Output: 0 (since there are no even elements to check for the largestEvenSubArray)
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        System.out.println(findMaxEvenSubArrayLenght(arr));
    }
    static int findMaxEvenSubArrayLenght(int[] arr) {
        //if all the elements are odd return 0
        int noOfOdds = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 != 0) {
                noOfOdds++;
            }
        }
        if(noOfOdds == arr.length) {
            return 0;
        }
        //else do this logic
        int count = 1, max = 1;
        for(int i = 0; i < arr.length -1; i++) {
            if(arr[i] % 2 == 0 && arr[i + 1] % 2 == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}
