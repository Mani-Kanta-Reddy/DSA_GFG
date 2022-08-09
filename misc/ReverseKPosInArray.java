package misc;

import java.util.Arrays;

import utils.FastReader;

public class ReverseKPosInArray {
    public static void main(String[] args) {
        /*
         * Input:  5 3 (5 is the size of the array and 3 is the first `k` elements that needs to reversed)
         *         1 2 3 4 5
         * Output: 3 2 1 4 5
         * 
         * Input:  4 4 
         *         4 3 2 1
         * Output: 1 2 3 4
         */ 
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        for(int i = 0, j = k - 1; i < k / 2; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
