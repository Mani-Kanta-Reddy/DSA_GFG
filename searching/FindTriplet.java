package searching;

import java.util.Arrays;
import utils.FastReader;

public class FindTriplet {
    public static void main(String[] args) {
        /*
        Given an integer array and x. Check if there is a triplet from the array whose sum is `x`
        This uses the two pointer approach for details on this check `FindPair` solution

        Input: 2 3 4 8 9 20 40
               32
        Output: true (4 + 8 + 20)
        */
        FastReader sc = new FastReader();
        final int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        final int x = sc.nextInt();
        System.out.println(checkIfTripletPresentNaive(arr,x));  //O(n ^ 3) | O(1)
        //WORKS ONLY WITH SORTED ARRAY
        System.out.println(checkIfTripletPresentTwoPointer(arr, x));  //O(n ^ 2) | O(1)
    }
    static boolean checkIfTripletPresentTwoPointer(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            /*two-pointer solution
                The idea is we fix each element in the outer loop and inside the loop
                we apply two pointer from i + 1 till n - 1 to find a pair exists whose sum is x - arr[i]
            */
            for(int j = i + 1, k = arr.length - 1; j < k; ) {
                if(arr[j] + arr[k] == x - arr[i])
                    return true;
                if(arr[j] + arr[k] > x - arr[i])
                    k--;
                else
                    j++;
            }
        }
        return false;
    }
    static boolean checkIfTripletPresentNaive(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j + 1; k < arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == x)
                        return true;
                }
            }
        }
        return false;
    }
}
