package searching;
import java.util.Arrays;

import utils.FastReader;

public class FindPeakElement {
    public static void main(String[] args) {
        /*
        Definition of peak element:
        5 10 20 7 15    -> 20 (since its greater than the elem just left to it & just right to it)
        30 5 21         -> 30 or 21 (corner cases for elems at start & end we just have to check if those greater than the element just right of it if idx is start or element just left to it if the idx is end)
        */
        FastReader sc = new FastReader();
        final int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findPeak(arr));
        System.out.println(findPeakUsingBinarySearch(arr));
    }
    static int findPeakUsingBinarySearch(int[] arr) {
        /*
        the idea is that if arr[mid] >= arr[mid = 1] && arr[mid + 1] then it's peak else
        Then we've to think whether we choose right half or left half but the interesting fact with the peak definition is
        that if arr[mid - 1] >= arr[mid] then for-sure the peak will be in the left-half otherwise it will be in the right-half
        for eg., [5, 20, 40, 35, 30, 15, 10] -> mid = 35 since mid - 1 (40 > 35) so 35 is not peak, Hence we discard right else left
        */
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(mid == 0 || arr[mid - 1] <= arr[mid] &&  arr[mid + 1] <= arr[mid] || mid == arr.length - 1)
                return arr[mid];
            
            if(mid > 0 && arr[mid - 1] >= arr[mid]) //go to left-half
                end = mid - 1;

            else                //go-to right-half
                start = mid + 1;  
        }
        return - 1; 
    }
    static int findPeak(int[] arr) {
        if(arr.length == 1)
            return arr[0];
        if(arr[0] > arr[1])
            return arr[0];
        if(arr[arr.length - 1] > arr[arr.length - 2])
            return arr[arr.length - 1];
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return arr[i];
        }
        return -1;
    }
}
