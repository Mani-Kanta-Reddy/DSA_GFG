package arrays;
import java.util.Arrays;

import utils.FastReader;

public class Count1sInSortedBinaryArray {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::parseInt)
                          .toArray();
        int firstOccurance = count1sInSortedBinaryArr(arr);
        System.out.println(firstOccurance != -1 ? arr.length - firstOccurance : 0);
    }
    static int count1sInSortedBinaryArr(int[] arr) {
        /*
        The idea goes like this find the first occurance of 1 and since the array is already sorted ans will arr.length - firstIdx
        */
        int start = 0; 
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == 0)
                start = mid + 1;
            else {
                //which means we've to check if this is the first occurance
                if(mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                end = mid - 1;
            }
        }
        return -1;
    }
}
