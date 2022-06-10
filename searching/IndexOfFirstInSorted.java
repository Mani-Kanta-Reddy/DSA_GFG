package searching;

import java.util.Arrays;
import utils.FastReader;

public class IndexOfFirstInSorted {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int target = sc.nextInt();
        System.out.println(findFirstOccuranceInSorted(arr, target));
        System.out.println(findFindFirstOccuranceBinarySearchRecursive(arr, 0, arr.length - 1, target));
        System.out.println(findFirstOccuranceBinarySearch(arr, target));
    }
    static int findFindFirstOccuranceBinarySearchRecursive(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;
        //base case:
        if(low > high)
            return -1;

        //recursive case:
        if(target < arr[mid])
            return findFindFirstOccuranceBinarySearchRecursive(arr, low, mid - 1, target);
        else if(target > arr[mid])
            return findFindFirstOccuranceBinarySearchRecursive(arr, mid + 1, high, target);
        else {
            /*
            if arr[mid] == target we have to confirm if it's first occurance
            if not do a recursive binary search for left half
            */
            if(mid == 0 || arr[mid -1] != arr[mid])
                return mid;
            return findFindFirstOccuranceBinarySearchRecursive(arr, low, mid - 1, target);
        }
    }
    static int findFirstOccuranceBinarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(target < arr[mid])
                high = mid - 1;
            else if(target > arr[mid])
                low = mid + 1;
            else {
                //This block means target == arr[mid] now we have to check here if it's first occurance return mid else make recursive call to left half
                if(mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                high = mid - 1;                
            }
        }
        return -1;
    }
    static int findFirstOccuranceInSorted(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
}
