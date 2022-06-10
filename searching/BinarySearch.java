package searching;
import java.util.Arrays;

import utils.FastReader;

public class BinarySearch {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] sortedArr = Arrays.stream(sc.nextLine().split("\\s"))
                                .map(Integer::parseInt)
                                .mapToInt(Integer::valueOf)
                                .toArray();
        int target = sc.nextInt();
        //Binary Search for element if element found return it's idx else return -1
        System.out.println(binarySearch(sortedArr, target));
        System.out.println(binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, target));
    }
    static int binarySearchRecursive(int[] arr, int start, int end, int target) {
        int mid = (start + end) / 2;
        //base-case:
        if(start > end)
            return -1;

        //recursive-case:
        if(arr[mid] == target)
            return mid;
        else if(target < arr[mid])
            return binarySearchRecursive(arr, start, mid - 1, target);
        else
            return binarySearchRecursive(arr, mid + 1, end, target);
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2; 
            if(arr[mid] == target) {
                return mid;
            } else if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
