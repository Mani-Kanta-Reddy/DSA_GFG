package arrays;
import java.util.Arrays;

import utils.FastReader;

public class FindElementInSortedRotated {
    public static void main(String[] args) {
        /*
        Sorted Rotated Array means:
        Given array is sorted but rotated counter-clockwise `k` times
        100 200 250 30 50 60 whose sorted version is 30 50 60 100 200 250 

        One interesting thing from this kind of sortedRotated array is that there
        is always one-half sorted (either left-half or right-half)
        */
        FastReader sc = new FastReader();
        final int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int target = sc.nextInt();
        System.out.println(findIdxOfTarget(arr, target));
    }
    static int findIdxOfTarget(int[] arr, int target) {
        int start = 0; 
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(target == arr[mid])
                return mid;
            //check which half does the elment belongs to
            if(target >= arr[start] && target < arr[mid]) //this means left-half
                end = mid - 1;
            else    //means right half
                start = mid + 1;
            
        }
        return -1;
    }
}
