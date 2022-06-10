package searching;

import java.util.Arrays;
import utils.FastReader;

public class IndexOfLastInSorted {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        int target = sc.nextInt();
        System.out.println(findIndexOfLastOccurance(arr, target));
        System.out.println(findIndexOfLastOccuranceIterative(arr, target));
        System.out.println(findIndexOfLastOccuranceBinarySearchRecursive(arr, 0, arr.length - 1, target));
    }
    static int findIndexOfLastOccuranceIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(target > arr[mid])
                low = mid + 1;
            else if(target < arr[mid])
                high = mid - 1;
            else {
                //This block means target == arr[mid] now we have to check here if it's last occurance return mid else make recursive call to right half
                if(mid == arr.length - 1 || arr[mid + 1] != arr[mid])
                    return mid;
                low = mid + 1;
            }
        }
        return -1;
    }
    static int findIndexOfLastOccuranceBinarySearchRecursive(int[] arr, int low, int high, int target) {
        int mid = (low + high) / 2;
        //base-case:
        if(low > high)
            return -1;
        //recursive-case:
        if(target < arr[mid])
            return findIndexOfLastOccuranceBinarySearchRecursive(arr, low, mid - 1, target);
        else if(target > arr[mid])
            return findIndexOfLastOccuranceBinarySearchRecursive(arr, mid + 1, high, target);
        else {
            /*
            if arr[mid] == target we have to confirm if it's last occurance
            if not do a recursive binary search for right half
            */
            if(mid == arr.length - 1 || arr[mid + 1] != arr[mid]) 
                return mid;
            return findIndexOfLastOccuranceBinarySearchRecursive(arr, mid + 1, high, target);
        }
    }
    static int findIndexOfLastOccurance(int[] arr, int target) {
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == target) 
                return i;
        }
        return -1;
    }
}
