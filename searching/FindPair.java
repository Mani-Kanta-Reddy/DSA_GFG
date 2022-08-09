package searching;

import java.util.Arrays;
import utils.FastReader;

public class FindPair {
    public static void main(String[] args) {
        /*
        Given an integer array and x, Check if a pair exists in the array whose sum is = x 
        Input: 2 3 8 10 15
               12
        Output: true (3 + 8)
        */
        FastReader sc = new FastReader();
        final int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        final int x = sc.nextInt();

        System.out.println(checkIfPairExistsNavie(arr, x)); //O(n ^ 2) | O(n)
        /*
        There is a better solution with O(n) if the array is sorted
        The two pointer approach (WORKS ONLY WITH SORTED ARRAY):
        The Idea goes like this start left with 0 & right with n - 1, check if arr[left] + arr[right] == x
        case 1: if equals then return true
        case 2: arr[left] + arr[right] > x
                which means we've to move the right pointer to obtain comparatively smaller sum b/c if we move
                the left pointer it will produce even more sum
        case 3: arr[left] + arr[right] < x
                which means we've to move the left to find greater sum that may match with `x` b/c if we move
                the right pointer this will produce even less sum
        */
        System.out.println(checkIfPairExistsTwoPointer(arr, x));  //O(n)  | O(1)
    }
    static boolean checkIfPairExistsTwoPointer(int[] arr, int x) {
        for(int left = 0, right = arr.length - 1; left < right; ) { //If this looks ugly use `while` loop
            if(arr[left] + arr[right] == x)
                return true;
            if(arr[left] + arr[right] > x)
                right--;
            else
                left++;
        }
        return false;
    }
    static boolean checkIfPairExistsNavie(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == x)    
                    return true;
            }
        }
        return false;
    }
}
